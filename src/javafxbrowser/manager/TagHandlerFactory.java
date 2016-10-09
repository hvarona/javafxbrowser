package javafxbrowser.manager;

import org.w3c.dom.Node;
import javafxbrowser.frame.BrowserFXFrame;

/**
 *
 * @author henry
 */
public interface TagHandlerFactory {

    public boolean loadTag(Node nodeTage, BrowserFXFrame engine);

}
