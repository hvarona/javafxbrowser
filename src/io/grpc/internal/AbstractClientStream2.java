/*
 * Copyright 2014, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

import io.grpc.Metadata;
import io.grpc.Status;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Nullable;

/**
 * The abstract base class for {@link ClientStream} implementations. Extending classes only need to
 * implement {@link #transportState()} and {@link #abstractClientStreamSink()}. Must only be called
 * from the sending application thread.
 */
public abstract class AbstractClientStream2 extends AbstractStream2
    implements ClientStream, MessageFramer.Sink {

  private static final Logger log = Logger.getLogger(AbstractClientStream2.class.getName());

  /**
   * A sink for outbound operations, separated from the stream simply to avoid name
   * collisions/confusion. Only called from application thread.
   */
  protected interface Sink {
    /**
     * Sends an outbound frame to the remote end point.
     *
     * @param frame a buffer containing the chunk of data to be sent, or {@code null} if {@code
     *     endOfStream} with no data to send
     * @param endOfStream {@code true} if this is the last frame; {@code flush} is guaranteed to be
     *     {@code true} if this is {@code true}
     * @param flush {@code true} if more data may not be arriving soon
     */
    void writeFrame(@Nullable WritableBuffer frame, boolean endOfStream, boolean flush);

    /**
     * Requests up to the given number of messages from the call to be delivered to the client. This
     * should end up triggering {@link TransportState#requestMessagesFromDeframer(int)} on the
     * transport thread.
     */
    void request(int numMessages);

    /**
     * Tears down the stream, typically in the event of a timeout. This method may be called
     * multiple times and from any thread.
     *
     * <p>This is a clone of {@link ClientStream#cancel()}; {@link AbstractClientStream2#cancel}
     * delegates to this method.
     */
    void cancel(Status status);
  }

  private final MessageFramer framer;
  private boolean outboundClosed;
  /**
   * Whether cancel() has been called. This is not strictly necessary, but removes the delay between
   * cancel() being called and isReady() beginning to return false, since cancel is commonly
   * processed asynchronously.
   */
  private volatile boolean cancelled;

  protected AbstractClientStream2(WritableBufferAllocator bufferAllocator,
      StatsTraceContext statsTraceCtx) {
    framer = new MessageFramer(this, bufferAllocator, statsTraceCtx);
  }

  /** {@inheritDoc} */
  @Override
  protected abstract TransportState transportState();

  @Override
  public void start(ClientStreamListener listener) {
    transportState().setListener(listener);
  }

  /**
   * Sink for transport to be called to perform outbound operations. Each stream must have its own
   * unique sink.
   */
  protected abstract Sink abstractClientStreamSink();

  @Override
  protected final MessageFramer framer() {
    return framer;
  }

  @Override
  public final void request(int numMessages) {
    abstractClientStreamSink().request(numMessages);
  }

  @Override
  public final void deliverFrame(WritableBuffer frame, boolean endOfStream, boolean flush) {
    Preconditions.checkArgument(frame != null || endOfStream, "null frame before EOS");
    abstractClientStreamSink().writeFrame(frame, endOfStream, flush);
  }

  @Override
  public final void halfClose() {
    if (!outboundClosed) {
      outboundClosed = true;
      endOfMessages();
    }
  }

  @Override
  public final void cancel(Status reason) {
    Preconditions.checkArgument(!reason.isOk(), "Should not cancel with OK status");
    cancelled = true;
    abstractClientStreamSink().cancel(reason);
  }

  @Override
  public final boolean isReady() {
    return super.isReady() && !cancelled;
  }

  /** This should only called from the transport thread. */
  protected abstract static class TransportState extends AbstractStream2.TransportState {
    /** Whether listener.closed() has been called. */
    private boolean listenerClosed;
    private ClientStreamListener listener;

    private Runnable deliveryStalledTask;

    private boolean headersReceived;
    /**
     * Whether the stream is closed from the transport's perspective. This can differ from {@link
     * #listenerClosed} because there may still be messages buffered to deliver to the application.
     */
    private boolean statusReported;

    protected TransportState(int maxMessageSize, StatsTraceContext statsTraceCtx) {
      super(maxMessageSize, statsTraceCtx);
    }

    @VisibleForTesting
    public final void setListener(ClientStreamListener listener) {
      Preconditions.checkState(this.listener == null, "Already called setListener");
      this.listener = Preconditions.checkNotNull(listener, "listener");
    }

    @Override
    public final void deliveryStalled() {
      if (deliveryStalledTask != null) {
        deliveryStalledTask.run();
        deliveryStalledTask = null;
      }
    }

    @Override
    public final void endOfStream() {
      deliveryStalled();
    }

    @Override
    protected final ClientStreamListener listener() {
      return listener;
    }

    /**
     * Called by transport implementations when they receive headers.
     *
     * @param headers the parsed headers
     */
    protected void inboundHeadersReceived(Metadata headers) {
      Preconditions.checkState(!statusReported, "Received headers on closed stream");
      headersReceived = true;
      listener().headersRead(headers);
    }

    /**
     * Processes the contents of a received data frame from the server.
     *
     * @param frame the received data frame. Its ownership is transferred to this method.
     */
    protected void inboundDataReceived(ReadableBuffer frame) {
      Preconditions.checkNotNull(frame, "frame");
      boolean needToCloseFrame = true;
      try {
        if (statusReported) {
          log.log(Level.INFO, "Received data on closed stream");
          return;
        }
        if (!headersReceived) {
          transportReportStatus(
              Status.INTERNAL.withDescription("headers not received before payload"),
              false, new Metadata());
          return;
        }

        needToCloseFrame = false;
        deframe(frame, false);
      } finally {
        if (needToCloseFrame) {
          frame.close();
        }
      }
    }

    /**
     * Processes the trailers and status from the server.
     *
     * @param trailers the received trailers
     * @param status the status extracted from the trailers
     */
    protected void inboundTrailersReceived(Metadata trailers, Status status) {
      Preconditions.checkNotNull(status, "status");
      Preconditions.checkNotNull(trailers, "trailers");
      if (statusReported) {
        log.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}",
            new Object[]{status, trailers});
        return;
      }
      transportReportStatus(status, false, trailers);
    }

    /**
     * Report stream closure with status to the application layer if not already reported. This
     * method must be called from the transport thread.
     *
     * @param status the new status to set
     * @param stopDelivery if {@code true}, interrupts any further delivery of inbound messages that
     *        may already be queued up in the deframer. If {@code false}, the listener will be
     *        notified immediately after all currently completed messages in the deframer have been
     *        delivered to the application.
     * @param trailers new instance of {@code Trailers}, either empty or those returned by the
     *        server
     */
    public final void transportReportStatus(final Status status, boolean stopDelivery,
        final Metadata trailers) {
      Preconditions.checkNotNull(status, "status");
      Preconditions.checkNotNull(trailers, "trailers");
      // If stopDelivery, we continue in case previous invocation is waiting for stall
      if (statusReported && !stopDelivery) {
        return;
      }
      statusReported = true;
      onStreamDeallocated();

      // If not stopping delivery, then we must wait until the deframer is stalled (i.e., it has no
      // complete messages to deliver).
      if (stopDelivery || isDeframerStalled()) {
        deliveryStalledTask = null;
        closeListener(status, trailers);
      } else {
        deliveryStalledTask = new Runnable() {
          @Override
          public void run() {
            closeListener(status, trailers);
          }
        };
      }
    }

    /**
     * Closes the listener if not previously closed.
     *
     * @throws IllegalStateException if the call has not yet been started.
     */
    private void closeListener(Status status, Metadata trailers) {
      if (!listenerClosed) {
        listenerClosed = true;
        closeDeframer();
        listener().closed(status, trailers);
      }
    }
  }
}
