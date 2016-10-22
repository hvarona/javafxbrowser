/*
 * Copyright 2016, Google Inc. All rights reserved.
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

import static com.google.common.base.Preconditions.checkState;

import com.google.census.CensusContext;
import com.google.census.CensusContextFactory;
import com.google.census.MetricMap;
import com.google.census.MetricName;
import com.google.census.RpcConstants;
import com.google.census.TagKey;
import com.google.census.TagValue;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;

import io.grpc.Metadata;
import io.grpc.Status;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * The stats and tracing information for a call.
 */
public final class StatsTraceContext {
  public static final StatsTraceContext NOOP = StatsTraceContext.newClientContext(
      "noopservice/noopmethod", NoopCensusContextFactory.INSTANCE,
      GrpcUtil.STOPWATCH_SUPPLIER);

  private enum Side {
    CLIENT, SERVER
  }

  private final CensusContext censusCtx;
  private final Stopwatch stopwatch;
  private final Side side;
  private final Metadata.Key<CensusContext> censusHeader;
  private long wireBytesSent;
  private long wireBytesReceived;
  private long uncompressedBytesSent;
  private long uncompressedBytesReceived;
  private boolean callEnded;

  private StatsTraceContext(Side side, String fullMethodName, CensusContext parentCtx,
      Supplier<Stopwatch> stopwatchSupplier, Metadata.Key<CensusContext> censusHeader) {
    this.side = side;
    TagKey methodTagKey =
        side == Side.CLIENT ? RpcConstants.RPC_CLIENT_METHOD : RpcConstants.RPC_SERVER_METHOD;
    // TODO(carl-mastrangelo): maybe cache TagValue in MethodDescriptor
    this.censusCtx = parentCtx.with(methodTagKey, new TagValue(fullMethodName));
    this.stopwatch = stopwatchSupplier.get().start();
    this.censusHeader = censusHeader;
  }

  /**
   * Creates a {@code StatsTraceContext} for an outgoing RPC, using the current CensusContext.
   *
   * <p>The current time is used as the start time of the RPC.
   */
  public static StatsTraceContext newClientContext(String methodName,
      CensusContextFactory censusFactory, Supplier<Stopwatch> stopwatchSupplier) {
    return new StatsTraceContext(Side.CLIENT, methodName,
        // TODO(zhangkun83): use the CensusContext out of the current Context
        censusFactory.getDefault(),
        stopwatchSupplier, createCensusHeader(censusFactory));
  }

  @VisibleForTesting
  static StatsTraceContext newClientContextForTesting(String methodName,
      CensusContextFactory censusFactory, CensusContext parent,
      Supplier<Stopwatch> stopwatchSupplier) {
    return new StatsTraceContext(Side.CLIENT, methodName, parent, stopwatchSupplier,
        createCensusHeader(censusFactory));
  }

  /**
   * Creates a {@code StatsTraceContext} for an incoming RPC, using the CensusContext deserialized
   * from the headers.
   *
   * <p>The current time is used as the start time of the RPC.
   */
  public static StatsTraceContext newServerContext(String methodName,
      CensusContextFactory censusFactory, Metadata headers,
      Supplier<Stopwatch> stopwatchSupplier) {
    Metadata.Key<CensusContext> censusHeader = createCensusHeader(censusFactory);
    CensusContext parentCtx = headers.get(censusHeader);
    if (parentCtx == null) {
      parentCtx = censusFactory.getDefault();
    }
    return new StatsTraceContext(Side.SERVER, methodName, parentCtx, stopwatchSupplier,
        censusHeader);
  }

  /**
   * Propagate the context to the outgoing headers.
   */
  void propagateToHeaders(Metadata headers) {
    headers.discardAll(censusHeader);
    headers.put(censusHeader, censusCtx);
  }

  Metadata.Key<CensusContext> getCensusHeader() {
    return censusHeader;
  }

  @VisibleForTesting
  CensusContext getCensusContext() {
    return censusCtx;
  }

  @VisibleForTesting
  static Metadata.Key<CensusContext> createCensusHeader(
      final CensusContextFactory censusCtxFactory) {
    return Metadata.Key.of("grpc-census-bin", new Metadata.BinaryMarshaller<CensusContext>() {
        @Override
        public byte[] toBytes(CensusContext context) {
          ByteBuffer buffer = context.serialize();
          // TODO(carl-mastrangelo): currently we only make sure the correctness. We may need to
          // optimize out the allocation and copy in the future.
          byte[] bytes = new byte[buffer.remaining()];
          buffer.get(bytes);
          return bytes;
        }

        @Override
        public CensusContext parseBytes(byte[] serialized) {
          return censusCtxFactory.deserialize(ByteBuffer.wrap(serialized));
        }
      });
  }

  /**
   * Record the outgoing number of payload bytes as on the wire.
   */
  void wireBytesSent(long bytes) {
    // TODO(zhangkun83): maybe change of the checkState() to assert after this class is stabilized.
    checkState(!callEnded, "already eneded");
    wireBytesSent += bytes;
  }

  /**
   * Record the incoming number of payload bytes as on the wire.
   */
  void wireBytesReceived(long bytes) {
    checkState(!callEnded, "already eneded");
    wireBytesReceived += bytes;
  }

  /**
   * Record the outgoing number of payload bytes in uncompressed form.
   *
   * <p>The time this method is called is unrelated to the actual time when those byte are sent.
   */
  void uncompressedBytesSent(long bytes) {
    checkState(!callEnded, "already ended");
    uncompressedBytesSent += bytes;
  }

  /**
   * Record the incoming number of payload bytes in uncompressed form.
   *
   * <p>The time this method is called is unrelated to the actual time when those byte are received.
   */
  void uncompressedBytesReceived(long bytes) {
    checkState(!callEnded, "already ended");
    uncompressedBytesReceived += bytes;
  }

  /**
   * Record a finished all and mark the current time as the end time.
   */
  void callEnded(Status status) {
    checkState(!callEnded, "already ended");
    callEnded = true;
    stopwatch.stop();
    MetricName latencyMetric;
    MetricName wireBytesSentMetric;
    MetricName wireBytesReceivedMetric;
    MetricName uncompressedBytesSentMetric;
    MetricName uncompressedBytesReceivedMetric;
    if (side == Side.CLIENT) {
      latencyMetric = RpcConstants.RPC_CLIENT_ROUNDTRIP_LATENCY;
      wireBytesSentMetric = RpcConstants.RPC_CLIENT_REQUEST_BYTES;
      wireBytesReceivedMetric = RpcConstants.RPC_CLIENT_RESPONSE_BYTES;
      uncompressedBytesSentMetric = RpcConstants.RPC_CLIENT_UNCOMPRESSED_REQUEST_BYTES;
      uncompressedBytesReceivedMetric = RpcConstants.RPC_CLIENT_UNCOMPRESSED_RESPONSE_BYTES;
    } else {
      latencyMetric = RpcConstants.RPC_SERVER_SERVER_LATENCY;
      wireBytesSentMetric = RpcConstants.RPC_SERVER_RESPONSE_BYTES;
      wireBytesReceivedMetric = RpcConstants.RPC_SERVER_REQUEST_BYTES;
      uncompressedBytesSentMetric = RpcConstants.RPC_SERVER_UNCOMPRESSED_RESPONSE_BYTES;
      uncompressedBytesReceivedMetric = RpcConstants.RPC_SERVER_UNCOMPRESSED_REQUEST_BYTES;
    }
    censusCtx
        .with(RpcConstants.RPC_STATUS, new TagValue(status.getCode().toString()))
        .record(MetricMap.builder()
            .put(latencyMetric, stopwatch.elapsed(TimeUnit.MILLISECONDS))
            .put(wireBytesSentMetric, wireBytesSent)
            .put(wireBytesReceivedMetric, wireBytesReceived)
            .put(uncompressedBytesSentMetric, uncompressedBytesSent)
            .put(uncompressedBytesReceivedMetric, uncompressedBytesReceived)
            .build());
  }
}
