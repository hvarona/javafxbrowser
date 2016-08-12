package javafxbrowser.listener;

import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafxbrowser.frame.BroswerFXFrame;

/**
 *
 * @author henry
 */
public class BasicWebEngineChangeAction implements WebEngineChangeAction {

    private TitleChangeAction titleChangeAction;
    private BroswerFXFrame browserFrame;

    public BasicWebEngineChangeAction(TitleChangeAction titleChangeAction) {
        this.titleChangeAction = titleChangeAction;
    }

    @Override
    public void setBroswerFXFrame(BroswerFXFrame broswerFXFrame) {
        browserFrame = broswerFXFrame;
    }

    @Override
    public void titleChangeAction(String newValue) {
        titleChangeAction.changeTitle(newValue);
    }

    @Override
    public void workDoneAction(int newValue) {
        browserFrame.getLoadingBar().progressProperty().bind(browserFrame.getEngine().getLoadWorker().progressProperty());
        if (newValue >= 100) {
            browserFrame.getLoadingBar().setVisible(false);
            browserFrame.enableDisableButtons();
        } else {
            browserFrame.getLoadingBar().setVisible(true);
            browserFrame.enableDisableButtons();
        }
    }

    @Override
    public void onStatusChangeAction(String newValue) {
        browserFrame.getTextStatus().setText(newValue);
    }

    @Override
    public void locationChangeAction(String newValue) {
        browserFrame.getTextURL().setText(newValue);
        browserFrame.setCurrentURL(newValue);
        browserFrame.enableDisableButtons();
    }

    @Override
    public void runStateAction(boolean newValue) {
        if (newValue) {
            browserFrame.getRefreshStopButton().setGraphic(new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("javafxbrowser/frame/icon/stop-icon.png"))));
        } else {
            browserFrame.getRefreshStopButton().setGraphic(new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("javafxbrowser/frame/icon/refresh-icon.png"))));
        }
    }

    @Override
    public void exceptionAction(Throwable newValue) {
        /*if (state == Worker.State.FAILED) {

        }*/
    }

}
