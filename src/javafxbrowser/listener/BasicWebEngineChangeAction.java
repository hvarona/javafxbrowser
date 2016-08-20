package javafxbrowser.listener;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafxbrowser.frame.BroswerFXFrame;

/**
 *
 * @author henry
 */
public class BasicWebEngineChangeAction extends WebEngineChangeAction {

    private TitleChangeAction titleChangeAction;

    public BasicWebEngineChangeAction(TitleChangeAction titleChangeAction) {
        this.titleChangeAction = titleChangeAction;
    }

    @Override
    public void titleChangeAction(String newValue) {
        titleChangeAction.changeTitle(newValue);
    }

    @Override
    public void workDoneAction(int newValue, BroswerFXFrame browserFrame) {
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
    public void onStatusChangeAction(String newValue, BroswerFXFrame browserFrame) {
        browserFrame.getTextStatus().setText(newValue);
    }

    @Override
    public void locationChangeAction(String newValue, BroswerFXFrame browserFrame) {
        browserFrame.getTextURL().setText(newValue);
        browserFrame.setCurrentURL(newValue);
        browserFrame.enableDisableButtons();
    }

    @Override
    public void runStateAction(boolean newValue, BroswerFXFrame browserFrame) {
        if (newValue) {
            browserFrame.getRefreshStopButton().setGraphic(new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("javafxbrowser/frame/icon/stop-icon.png"))));
        } else {
            browserFrame.getRefreshStopButton().setGraphic(new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("javafxbrowser/frame/icon/refresh-icon.png"))));
        }
    }

    @Override
    public void exceptionAction(Throwable newValue, BroswerFXFrame browserFrame) {
    }

}
