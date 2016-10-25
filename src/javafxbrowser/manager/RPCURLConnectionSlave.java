package javafxbrowser.manager;

import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.internal.DnsNameResolverProvider;
import io.grpc.netty.NettyChannelBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import javafxbrowser.JavaFxBrowserBase;
import javafxbrowser.rpc.ServerPetitionGrpc;
import javafxbrowser.rpc.StringObject;
import javafxbrowser.rpc.URLPetitionGrpc;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 *
 * @author hvarona
 */
public class RPCURLConnectionSlave extends HttpURLConnection {

    private ManagedChannel channel;
    private URLPetitionGrpc.URLPetitionBlockingStub blockingStub;
    private long idCon;
    private RPCSlaveInputStream inputStream = new RPCSlaveInputStream();

    public RPCURLConnectionSlave(URL url) {
        super(url, Proxy.NO_PROXY);
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
        return blockingStub.getContentEncoding(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
    }

    @Override
    public String getContentType() {
        return blockingStub.getContentType(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
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
        super.connect();
        blockingStub.connect(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build());
    }

    //Not implemented yet
    @Override
    public URL getURL() {
        System.out.println("25");
        return super.getURL(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getContent(Class[] classes) throws IOException {
        System.out.println("14");
        return super.getContent(classes); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getContent() throws IOException {
        System.out.println("15");
        return super.getContent(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InputStream getInputStream() throws IOException {
        System.out.println("16");
        return inputStream;
        //return super.getInputStream(); //To change body of generated methods, choose Tools | Templates.
        //return new RPCSlaveInputStream();
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        System.out.println("17");
        return super.getOutputStream(); //To change body of generated methods, choose Tools | Templates.
    }

    public class RPCSlaveInputStream extends InputStream {

        public RPCSlaveInputStream() {
        }

        @Override
        public int read() throws IOException {
            System.out.println("en read");
            return blockingStub.inputStreamRead(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
        }

        @Override
        public boolean markSupported() {
            System.out.println("en mark Supported");
            return blockingStub.inputStreamMarkSupported(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
        }

        @Override
        public synchronized void reset() throws IOException {
            System.out.println("en reset");
            blockingStub.inputStreamReset(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build());
        }

        @Override
        public synchronized void mark(int readlimit) {
            System.out.println("en mark");
            blockingStub.inputStreamMark(javafxbrowser.rpc.Int.newBuilder().setConId(idCon).setValue(readlimit).build());
        }

        @Override
        public void close() throws IOException {
            System.out.println("en close");
            blockingStub.inputStreamClose(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build());
            System.out.println("sali de close");
            //super.close();
        }

        @Override
        public int available() throws IOException {
            System.out.println("en avaible");
            return blockingStub.inputStreamAvailable(javafxbrowser.rpc.Void.newBuilder().setConId(idCon).build()).getValue();
        }

        @Override
        public long skip(long n) throws IOException {
            System.out.println("skip");
            return blockingStub.inputStreamSkip(javafxbrowser.rpc.Long.newBuilder().setConId(idCon).setValue(n).build()).getValue();
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            return blockingStub.inputStreamReadArrayOff(javafxbrowser.rpc.ByteArrayOffset.newBuilder().setConId(idCon).setOffset(off).setLen(len).setArray(ByteString.copyFrom(b)).build()).getValue();
        }

        @Override
        public int read(byte[] b) throws IOException {
            return blockingStub.inputStreamReadArrayOff(javafxbrowser.rpc.ByteArrayOffset.newBuilder().setConId(idCon).setArray(ByteString.copyFrom(b)).build()).getValue();
        }

    }

}
