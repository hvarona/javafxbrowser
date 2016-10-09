package javafxbrowser.frame;

import java.awt.Dimension;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingNode;
import javafx.scene.Node;
import javax.swing.JApplet;
import javax.swing.SwingUtilities;

/**
 *
 * @author hvarona
 */
public class LoadAppletFrame {

    private Dimension appletSize;

    public Node getNode(JApplet applet) {
        applet.init();
        applet.start();
        FutureTask<Dimension> sizingTask = new FutureTask<>(()
                -> applet.getRootPane().getPreferredSize()
        );
        SwingUtilities.invokeLater(sizingTask);
        try {
            appletSize = sizingTask.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(LoadAppletFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        final SwingNode swingNode = new SwingNode();
        SwingUtilities.invokeLater(()
                -> swingNode.setContent(applet.getRootPane())
        );

        return swingNode;
    }
}
