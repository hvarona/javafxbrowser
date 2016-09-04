package javafxbrowser.listener;

import javafxbrowser.frame.BrowserFXFrame;

/**
 *
 * @author henry
 */
public abstract class WebEngineChangeAction {

    public void titleChangeAction(String newValue){};
    
    public void workDoneAction(int newValue, BrowserFXFrame broswerFXFrame){};

    public void onStatusChangeAction(String newValue, BrowserFXFrame broswerFXFrame){};

    public void locationChangeAction(String newValue, BrowserFXFrame broswerFXFrame){};

    public void runStateAction(boolean newValue, BrowserFXFrame broswerFXFrame){};

    public void exceptionAction(Throwable newValue, BrowserFXFrame broswerFXFrame){};
}
