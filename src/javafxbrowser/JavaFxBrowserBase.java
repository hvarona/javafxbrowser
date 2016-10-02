/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxbrowser;

/**
 *
 * @author henry
 */
public class JavaFxBrowserBase {

    public static void
            main(String[] args) {
        int status = 0;
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
        System.exit(status);
    }
}
