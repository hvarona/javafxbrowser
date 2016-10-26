package javafxbrowser.manager;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.internal.DnsNameResolverProvider;
import io.grpc.netty.NettyChannelBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import javafxbrowser.JavaFxBrowserBase;
import javafxbrowser.rpc.StringObject;
import javafxbrowser.rpc.StreamRead;
import javafxbrowser.rpc.URLPetitionGrpc;

/**
 *
 * @author hvarona
 */
public class RPCURLConnectionSlave extends URLConnection {

    private final ManagedChannel channel;
    private final URLPetitionGrpc.URLPetitionBlockingStub blockingStub;
    private final long idCon;

    public RPCURLConnectionSlave(URL url) {
        super(url);
        channel = NettyChannelBuilder.forAddress("localhost", JavaFxBrowserBase.port)
                .nameResolverFactory(new DnsNameResolverProvider())
                .usePlaintext(true).build();
        blockingStub = URLPetitionGrpc.newBlockingStub(channel);
        System.out.println(url.toString());
        idCon = blockingStub.constructor(StringObject.newBuilder().setValue(url.toString()).build()).getConId();
    }

    @Override
    public void setDefaultUseCaches(boolean defaultusecaches) {
        blockingStub.setDefaultUseCaches(javafxbrowser.rpc.Boolean.newBuilder().setConId(idCon).setValue(defaultusecaches).build());
    }

    @Override
    public boolean getDefaultUseCaches() {
        return blockingStub.getDefaultUseCaches(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
    }

    @Override
    public long getIfModifiedSince() {
        return blockingStub.getIfModifiedSince(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
    }

    @Override
    public void setIfModifiedSince(long ifmodifiedsince) {
        blockingStub.setIfModifiedSince(javafxbrowser.rpc.Long.newBuilder().setConId(idCon).setValue(ifmodifiedsince).build());
    }

    @Override
    public boolean getUseCaches() {
        return blockingStub.getUseCaches(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
    }

    @Override
    public void setUseCaches(boolean usecaches) {
        blockingStub.setUseCaches(javafxbrowser.rpc.Boolean.newBuilder().setConId(idCon).setValue(usecaches).build());
    }

    @Override
    public boolean getAllowUserInteraction() {
        return blockingStub.getAllowUserInteraction(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
    }

    @Override
    public void setAllowUserInteraction(boolean allowuserinteraction) {
        blockingStub.setAllowUserInteraction(javafxbrowser.rpc.Boolean.newBuilder().setConId(idCon).setValue(allowuserinteraction).build());
    }

    @Override
    public boolean getDoOutput() {
        return blockingStub.getDoOutput(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
    }

    @Override
    public void setDoOutput(boolean dooutput) {
        blockingStub.setDoOutput(javafxbrowser.rpc.Boolean.newBuilder().setConId(idCon).setValue(dooutput).build());
    }

    @Override
    public boolean getDoInput() {
        return blockingStub.getDoInput(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
    }

    @Override
    public void setDoInput(boolean doinput) {
        blockingStub.setDoInput(javafxbrowser.rpc.Boolean.newBuilder().setConId(idCon).setValue(doinput).build());
    }

    @Override
    public String toString() {
        return blockingStub.toStringObject(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
    }

    @Override
    public long getHeaderFieldLong(String name, long Default) {
        return blockingStub.getHeaderFieldLong(javafxbrowser.rpc.FieldLong.newBuilder().setConId(idCon).setName(name).setDefault(Default).build()).getValue();
    }

    @Override
    public int getHeaderFieldInt(String name, int Default) {
        return blockingStub.getHeaderFieldInt(javafxbrowser.rpc.FieldInt.newBuilder().setConId(idCon).setName(name).setDefault(Default).build()).getValue();
    }

    @Override
    public long getLastModified() {
        return blockingStub.getLastModified(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
    }

    @Override
    public long getDate() {
        return blockingStub.getDate(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
    }

    @Override
    public long getExpiration() {
        return blockingStub.getExpiration(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
    }

    @Override
    public String getContentEncoding() {
        String answer = blockingStub.getContentEncoding(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
        if (answer.equals("NulV")) {
            return null;
        }
        return answer;
    }

    @Override
    public String getContentType() {
        String answer = blockingStub.getContentType(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
        if (answer.equals("NulV")) {
            return null;
        }
        return answer;
    }

    @Override
    public long getContentLengthLong() {
        return blockingStub.getContentLengthLong(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
    }

    @Override
    public int getContentLength() {
        return blockingStub.getContentLength(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
    }

    @Override
    public void connect() throws IOException {
        blockingStub.connect(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build());
    }

    //Not implemented yet
    @Override
    public URL getURL() {
        System.out.println("25");
        return super.getURL();
    }

    //Not implemented yet
    @Override
    public Object getContent(Class[] classes) throws IOException {
        System.out.println("14");
        return super.getContent(classes);
    }

    //Not implemented yet
    @Override
    public Object getContent() throws IOException {
        System.out.println("15");
        return super.getContent();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        long idInput = blockingStub.getInputStream(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
        if (idInput < 0) {
            throw new IOException();
        }
        return new RPCSlaveInputStream(idInput);
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        long idOutput = blockingStub.getOutputStream(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
        if (idOutput < 0) {
            throw new IOException();
        }
        return new RPCSlaveOutputStream(idOutput);
    }

    public class RPCSlaveInputStream extends InputStream {

        private final long idInput;

        public RPCSlaveInputStream(long idInput) {
            this.idInput = idInput;
        }

        @Override
        public int read() throws IOException {
            int answer = blockingStub.inputStreamRead(javafxbrowser.rpc.Void.newBuilder().setConId(idInput).build()).getValue();
            if (answer < -1) {
                throw new IOException();
            }
            return answer;
        }

        @Override
        public boolean markSupported() {
            return blockingStub.inputStreamMarkSupported(javafxbrowser.rpc.Void.newBuilder().setConId(idInput).build()).getValue();
        }

        @Override
        public synchronized void reset() throws IOException {
            if (blockingStub.inputStreamReset(javafxbrowser.rpc.Void.newBuilder().setConId(idInput).build()).getConId() < 0) {
                throw new IOException();
            }
        }

        @Override
        public synchronized void mark(int readlimit) {
            blockingStub.inputStreamMark(javafxbrowser.rpc.Int.newBuilder().setConId(idInput).setValue(readlimit).build()).getConId();
        }

        @Override
        public void close() throws IOException {
            if (blockingStub.inputStreamClose(javafxbrowser.rpc.Void.newBuilder().setConId(idInput).build()).getConId() < 0) {
                throw new IOException();
            }
        }

        @Override
        public int available() throws IOException {
            int answer = blockingStub.inputStreamAvailable(javafxbrowser.rpc.Void.newBuilder().setConId(idInput).build()).getValue();
            if (answer < -1) {
                throw new IOException();
            }
            return answer;
        }

        @Override
        public long skip(long n) throws IOException {
            long answer = blockingStub.inputStreamSkip(javafxbrowser.rpc.Long.newBuilder().setConId(idInput).setValue(n).build()).getValue();
            if (answer < -1) {
                throw new IOException();
            }
            return answer;
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            StreamRead answer = blockingStub.inputStreamReadArrayOff(javafxbrowser.rpc.ByteArrayOffset.newBuilder().setConId(idInput).setOffset(off).setLen(len).setArray(ByteString.copyFrom(b)).build());
            System.arraycopy(answer.getArray().toByteArray(), 0, b, 0, b.length);
            if (answer.getAmount() < -1) {
                throw new IOException();
            }
            return answer.getAmount();
        }

        @Override
        public int read(byte[] b) throws IOException {
            StreamRead answer = blockingStub.inputStreamReadArray(javafxbrowser.rpc.ByteArray.newBuilder().setConId(idInput).setArray(ByteString.copyFrom(b)).build());
            byte[] answerArray = answer.getArray().toByteArray();
            System.arraycopy(answerArray, 0, b, 0, answerArray.length);
            if (answer.getAmount() < -1) {
                throw new IOException();
            }
            return answer.getAmount();
        }

    }

    public class RPCSlaveOutputStream extends OutputStream {

        private final long idOutput;

        public RPCSlaveOutputStream(long idOutput) {
            this.idOutput = idOutput;
        }

        @Override
        public void write(int b) throws IOException {
            if (blockingStub.outputStreamWrite(javafxbrowser.rpc.Int.newBuilder().setConId(idOutput).setValue(b).build()).getConId() < 0) {
                throw new IOException();
            }
        }

        @Override
        public void close() throws IOException {
            if (blockingStub.outputStreamClose(javafxbrowser.rpc.Void.newBuilder().setConId(idOutput).build()).getConId() < 0) {
                throw new IOException();
            }
        }

        @Override
        public void flush() throws IOException {
            if (blockingStub.outputStreamFlush(javafxbrowser.rpc.Void.newBuilder().setConId(idOutput).build()).getConId() < 0) {
                throw new IOException();
            }
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            if (blockingStub.outputStreamWriteArrayOff(javafxbrowser.rpc.ByteArrayOffset.newBuilder().setConId(idOutput).setArray(ByteString.copyFrom(b)).setLen(len).setOffset(off).build()).getConId() < 0) {
                throw new IOException();
            }
        }

        @Override
        public void write(byte[] b) throws IOException {
            if (blockingStub.outputStreamWriteArray(javafxbrowser.rpc.ByteArray.newBuilder().setConId(idOutput).setArray(ByteString.copyFrom(b)).build()).getConId() < 0) {
                throw new IOException();
            }
        }
    }

}
