package javafxbrowser;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import javafxbrowser.cfg.BrowserConfigurator;
import javafxbrowser.rpc.Config;
import javafxbrowser.rpc.ServerPetitionGrpc;

/**
 *
 * @author henry
 */
public class JavaFxBrowserBase extends ServerPetitionGrpc.ServerPetitionImplBase {

    private BrowserConfigurator config;
    private static Server server;
    private final static int port = 12000;

    public JavaFxBrowserBase() {
        config = new BrowserConfigurator();
    }

    @Override
    public void getConfig(Config request, StreamObserver<Config> responseObserver) {
        responseObserver.onNext(config.getConfig());
        responseObserver.onCompleted();
    }

    @Override
    public void setConfig(Config request, StreamObserver<Config> responseObserver) {
        config.SetConfig(request);
        responseObserver.onCompleted();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        server = NettyServerBuilder.forPort(port).addService(new JavaFxBrowserBase()).build();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may has been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                server.shutdown();
                System.err.println("*** server shut down");
            }
        });
    }
}
