package javafxbrowser.manager;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafxbrowser.applet.NotImplement;
import javafxbrowser.frame.BrowserFXFrame;
import javafxbrowser.frame.LoadAppletFrame;
import javax.swing.JApplet;
import netscape.javascript.JSObject;
import org.w3c.dom.Node;
import sun.applet.AppletViewer;

/**
 *
 * @author henry
 */
public class AppletHandler implements TagHandlerFactory {

    private static final int minHeight = 200;
    private static final int minWidth = 200;

    @Override
    public boolean loadTag(Node nodeTag, BrowserFXFrame frame) {
        try {
            String code = nodeTag.getAttributes().getNamedItem("code").getNodeValue();
            String name = "appletNode";
            try {
                name = nodeTag.getAttributes().getNamedItem("name").getNodeValue();
            } catch (Exception e) {
            }
            URL currentURL = frame.getCurrentURL();
            String codeBase = currentURL.getPath();
            try {

                codeBase = currentURL.getProtocol() + "://" + currentURL.getHost()
                        + nodeTag.getAttributes().getNamedItem("codebase").getNodeValue();
            } catch (Exception e) {

            }
            int height = minHeight;
            try {

                height = Integer.parseInt(nodeTag.getAttributes().getNamedItem("height").getNodeValue());
            } catch (Exception e) {
            }
            int width = minWidth;
            try {

                width = Integer.parseInt(nodeTag.getAttributes().getNamedItem("width").getNodeValue());
            } catch (Exception e) {
            }

            String archive = "";
            try {
                archive = nodeTag.getAttributes().getNamedItem("archive").getNodeValue();
            } catch (Exception e) {

            }

            String location = codeBase + archive;

            URLClassLoader ucl = new URLClassLoader(new URL[]{new URL(location)}, AppletHandler.class.getClassLoader());
            if (code.endsWith(".class")) {
                code = code.substring(0, code.length() - 6);
            }
            Class appletClazz = ucl.loadClass(code);
            AppletViewer viewer = new AppletViewer(width, height, currentURL, null, null, null);

            Applet appletObject = (Applet) appletClazz.newInstance();
            appletObject.init();
            appletObject.start();

            JSObject doc = (JSObject) frame.getEngine().executeScript("window");
            doc.setMember(name, appletObject);

            return true;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | MalformedURLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
