package javafxbrowser.frame;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafxbrowser.listener.WebEngineChangeAction;

/**
 *
 * @author henry
 */
public class BroswerFXFrame {
    
    private String currentURL = "";
    
    private BorderPane rootPane;
    private BorderPane topPanel;
    private StackPane bottomPanel;
    
    private Button backwardButton;
    private Button forwardButton;
    private Button refreshStopButton;
    private ProgressBar loadingBar;
    
    private Label textStatus;
    private TextField textURL;
    private WebEngine engine;
    
    public synchronized Pane getRootPane(WebEngineChangeAction engineChangeAction) {
        engineChangeAction.setBroswerFXFrame(this);
        if (rootPane != null) {
            return rootPane;
        }
        rootPane = new BorderPane();
        createTopPane();
        rootPane.setTop(topPanel);
        
        createBottomPane();
        rootPane.setBottom(bottomPanel);
        
        ScrollPane scrollPane = new ScrollPane();
        WebView webView = new WebView();
        engine = webView.getEngine();
        
        scrollPane.setContent(webView);
        scrollPane.getStyleClass().add("noborder-scroll-pane");
        scrollPane.setStyle("-fx-background-color: white");
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        
        engine.titleProperty().addListener((ObservableValue<? extends String> observable, String oldValue, final String newValue) -> {
            engineChangeAction.titleChangeAction(newValue);
        });
        
        engine.setOnStatusChanged((final WebEvent<String> event) -> {
            engineChangeAction.onStatusChangeAction(event.getData());
        });
        
        engine.locationProperty().addListener((ObservableValue<? extends String> ov, String oldValue, final String newValue) -> {
            engineChangeAction.locationChangeAction(newValue);
        });
        
        engine.getLoadWorker().workDoneProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldValue, final Number newValue) -> {
            engineChangeAction.workDoneAction(newValue.intValue());
        });
        
        engine.getLoadWorker().exceptionProperty().addListener((ObservableValue<? extends Throwable> o, Throwable old, final Throwable value) -> {
            engineChangeAction.exceptionAction(value);
        });
        engine.getLoadWorker().runningProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            engineChangeAction.runStateAction(newValue);
        });
        
        rootPane.setCenter(webView);
        
        return rootPane;
    }
    
    private void createTopPane() {
        topPanel = new BorderPane();
        topPanel.setPrefHeight(20);
        
        HBox topPanelLeft = new HBox();
        backwardButton = new Button("", new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("javafxbrowser/frame/icon/arrow--icon-left.png"))));
        backwardButton.setDisable(true);
        backwardButton.setPrefSize(35, 17);
        backwardButton.setOnAction(backwardButtonActionPerformed());
        forwardButton = new Button("", new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("javafxbrowser/frame/icon/arrow--icon-right.png"))));
        forwardButton.setDisable(true);
        forwardButton.setPrefSize(35, 17);
        forwardButton.setOnAction(fowardButtonActionPerformed());
        refreshStopButton = new Button("", new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("javafxbrowser/frame/icon/refresh-icon.png"))));
        refreshStopButton.setPrefSize(35, 17);
        refreshStopButton.setOnAction(stopRefreshButtonActionPerformed());
        topPanelLeft.getChildren().addAll(backwardButton, forwardButton, refreshStopButton);
        
        textURL = new TextField();
        
        HBox topPaneRight = new HBox();
        Button goButton = new Button("GO");
        goButton.setPrefSize(35, 17);
        topPaneRight.getChildren().addAll(goButton);
        
        goButton.setOnAction(goButtonAction());
        textURL.setOnAction(goButtonAction());
        
        topPanel.setLeft(topPanelLeft);
        topPanel.setCenter(textURL);
        topPanel.setRight(goButton);
    }
    
    private void createBottomPane() {
        bottomPanel = new StackPane();
        bottomPanel.setAlignment(Pos.CENTER_LEFT);
        
        textStatus = new Label();
        loadingBar = new ProgressBar(0);
        bottomPanel.getChildren().addAll(textStatus, loadingBar);
    }
    
    public WebEngine getEngine() {
        return engine;
    }
    
    private EventHandler<ActionEvent> goButtonAction() {
        return (ActionEvent event) -> {
            String route = textURL.getText();
            engine.load(route);
        };
    }
    
    private EventHandler<ActionEvent> fowardButtonActionPerformed() {
        return (ActionEvent event) -> {
            final WebHistory history = engine.getHistory();
            ObservableList<WebHistory.Entry> entryList = history.getEntries();
            int currentIndex = history.getCurrentIndex();
            if (currentIndex < entryList.size() - 1) {
                history.go(1);
            }
        };
    }
    
    private EventHandler<ActionEvent> stopRefreshButtonActionPerformed() {
        return (ActionEvent event) -> {
            if (engine.getLoadWorker().isRunning()) {
                engine.getLoadWorker().cancel();
                loadingBar.setVisible(false);
                enableDisableButtons();
            } else if (!currentURL.isEmpty()) {
                engine.load(currentURL);
            }
        };
    }
    
    private EventHandler<ActionEvent> backwardButtonActionPerformed() {
        return (ActionEvent event) -> {
            final WebHistory history = engine.getHistory();
            int currentIndex = history.getCurrentIndex();
            if (currentIndex > 0) {
                history.go(-1);
            }
        };
    }
    
    public void enableDisableButtons() {
        final WebHistory history = engine.getHistory();
        ObservableList<WebHistory.Entry> entryList = history.getEntries();
        if (history.getCurrentIndex() > 0) {
            backwardButton.setDisable(false);
        } else {
            backwardButton.setDisable(true);
        }
        if (history.getCurrentIndex() < entryList.size() - 1) {
            forwardButton.setDisable(false);
        } else {
            forwardButton.setDisable(true);
        }
    }
    
    public ProgressBar getLoadingBar() {
        return loadingBar;
    }
    
    public Label getTextStatus() {
        return textStatus;
    }
    
    public TextField getTextURL() {
        return textURL;
    }
    
    public void setCurrentURL(String currentURL) {
        this.currentURL = currentURL;
    }
    
    public Button getRefreshStopButton() {
        return refreshStopButton;
    }
    
}
