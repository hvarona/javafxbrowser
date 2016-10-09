package javafxbrowser.manager;

import javafxbrowser.frame.BrowserFXFrame;
import org.w3c.dom.NodeList;

/**
 *
 * @author henry
 */
public class TagHandler {

    private final String tag;
    private final BrowserFXFrame frame;
    private final TagHandlerFactory tagHandlerFactory;

    public TagHandler(String tag, BrowserFXFrame frame, TagHandlerFactory tagHandlerFactory) {
        this.tag = tag;
        this.frame = frame;
        this.tagHandlerFactory = tagHandlerFactory;
    }

    public String getTag() {
        return tag;
    }

    public void OnSuccess() {
        NodeList nodes = frame.getEngine().getDocument().getElementsByTagName(tag);

        for (int i = 0; i < nodes.getLength(); i++) {
            tagHandlerFactory.loadTag(nodes.item(i), frame);
        }
    }

}
