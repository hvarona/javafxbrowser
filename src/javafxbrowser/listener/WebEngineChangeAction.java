package javafxbrowser.listener;

import javafxbrowser.frame.BroswerFXFrame;

/**
 *
 * @author henry
 */
public abstract class WebEngineChangeAction {

    public void titleChangeAction(String newValue){};
    
    public void workDoneAction(int newValue, BroswerFXFrame broswerFXFrame){};

    public void onStatusChangeAction(String newValue, BroswerFXFrame broswerFXFrame){};

    public void locationChangeAction(String newValue, BroswerFXFrame broswerFXFrame){};

    public void runStateAction(boolean newValue, BroswerFXFrame broswerFXFrame){};

    public void exceptionAction(Throwable newValue, BroswerFXFrame broswerFXFrame){};
}
