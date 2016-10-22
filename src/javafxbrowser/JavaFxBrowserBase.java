package javafxbrowser;

import io.grpc.Server;
import io.grpc.ServerBuilder;
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

    private BrowserConfigurator config = new BrowserConfigurator();
    private static Server server;
    private final static int port = 10000;

    public JavaFxBrowserBase() {
    }

    @Override
    public void getConfig(Config request, StreamObserver<Config> responseObserver) {
        responseObserver.onNext(config.getConfig());
        responseObserver.onCompleted();
        //super.getConfig(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        server = ServerBuilder.forPort(port).addService(new JavaFxBrowserBase()).build();
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
        /*int status = 0;
         Ice.Communicator ic = null;
         try {
         System.out.println("Running the server");
         ic = Ice.Util.initialize(args);
         Ice.ObjectAdapter adapter
         = ic.createObjectAdapterWithEndpoints("JavaFxBroswerInterCommAdapter", "default -p 12234");
         Ice.Object object = new InterCommI(adapter);
         adapter.add(object, ic.stringToIdentity("JavaFxBroswerInterComm"));
         adapter.activate();
         ic.waitForShutdown();
         } catch (Ice.LocalException e) {
         e.printStackTrace();
         status = 1;
         } catch (Exception e) {
         System.err.println(e.getMessage());
         status = 1;
         }
         if (ic != null) {
         // Clean up
         //
         try {
         ic.destroy();
         } catch (Exception e) {
         System.err.println(e.getMessage());
         status = 1;
         }
         }
         System.exit(status);*/
    }
}
