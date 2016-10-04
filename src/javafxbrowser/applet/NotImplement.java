package javafxbrowser.applet;

import java.lang.reflect.InvocationTargetException;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author hvarona
 */
public class NotImplement extends JApplet {

    @Override
    public void init() {
        try {
            SwingUtilities.invokeAndWait(() -> {
                JLabel lbl = new JLabel("Not implementedF");
                add(lbl);
            });
        } catch (InterruptedException | InvocationTargetException e) {
            System.err.println("createGUI didn't complete successfully");
        }
    }

}
