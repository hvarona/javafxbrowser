package javafxbrowser.listener;

import javafx.concurrent.Worker;
import javafxbrowser.frame.BroswerFXFrame;

/**
 *
 * @author henry
 */
public interface WebEngineChangeAction {
    
    public void setBroswerFXFrame(BroswerFXFrame broswerFXFrame);

    public void titleChangeAction(String newValue);

    public void workDoneAction(int newValue);

    public void onStatusChangeAction(String newValue);

    public void locationChangeAction(String newValue);

    public void runStateAction(boolean newValue);

    public void exceptionAction(Throwable newValue);
}
