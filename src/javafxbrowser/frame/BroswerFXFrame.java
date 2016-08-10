package javafxbrowser.frame;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author henry
 */
public class BroswerFXFrame extends Application {

    private String currentURL = "";

    private VBox rootPane;
    private HBox topPanel;

    private Button backwardButton;
    private Button forwardButton;
    private Button refreshStopButton;
    //private Button goButton;
    private ProgressBar loadingBar;

    private Label textStatus;
    private TextField textURL;
    private WebEngine engine;

    @Override
    public void start(Stage stage) {
        rootPane = new VBox(0);
        rootPane.setAlignment(Pos.CENTER_LEFT);

        topPanel = new HBox(5);
        topPanel.setAlignment(Pos.CENTER_LEFT);
        topPanel.setPrefHeight(20);

        backwardButton = new Button("", new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("javafxbrowser/frame/icon/arrow--icon-left.png"))));
        backwardButton.setDisable(true);
        backwardButton.setPrefSize(35, 17);
        backwardButton.setOnAction(backwardButtonActionPerformed());
        forwardButton = new Button("", new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("javafxbrowser/frame/icon/arrow--icon-right.png"))));
        forwardButton.setDisable(true);
        forwardButton.setPrefSize(35, 17);
        forwardButton.setOnAction(fowardButtonActionPerformed());
        refreshStopButton = new Button("", new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("javafxbrowser/frame/icon/refresh-icon.png"))));;
        refreshStopButton.setPrefSize(35, 17);
        refreshStopButton.setOnAction(stopRefreshButtonActionPerformed());
        textURL = new TextField();
        Button button = new Button("GO");
        button.setPrefSize(35, 17);
        topPanel.getChildren().addAll(backwardButton, forwardButton, refreshStopButton, textURL, button);
        rootPane.getChildren().add(topPanel);

        HBox bottomPanel = new HBox();
        bottomPanel.setAlignment(Pos.CENTER_LEFT);

        textStatus = new Label();
        loadingBar = new ProgressBar(0);
        bottomPanel.getChildren().addAll(textStatus, loadingBar);

        ScrollPane scrollPane = new ScrollPane();
        WebView webView = new WebView();
        engine = webView.getEngine();

        scrollPane.setContent(webView);
        scrollPane.getStyleClass().add("noborder-scroll-pane");
        scrollPane.setStyle("-fx-background-color: white");
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        rootPane.getChildren().add(webView);
        rootPane.getChildren().add(bottomPanel);

        button.setOnAction(buttonAction(textURL, loadingBar, engine, webView));

        Scene scene = new Scene(rootPane);
        stage.setScene(scene);
        stage.show();
        textURL.setPrefWidth(topPanel.getWidth() - 200);

        scene.heightProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            rootPane.setPrefHeight(newValue.doubleValue());
            webView.setPrefHeight(newValue.doubleValue() - 40);
        });
        scene.widthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            rootPane.setPrefWidth(newValue.doubleValue());
            topPanel.setPrefWidth(newValue.doubleValue());
            textURL.setPrefWidth(topPanel.getWidth() - 200);
        });

        engine.titleProperty().addListener((ObservableValue<? extends String> observable, String oldValue, final String newValue) -> {
            stage.setTitle(newValue);
        });

        engine.setOnStatusChanged((final WebEvent<String> event) -> {
            textStatus.setText(event.getData());
        });

        engine.locationProperty().addListener((ObservableValue<? extends String> ov, String oldValue, final String newValue) -> {
            textURL.setText(newValue);
            currentURL = newValue;
            enableDisableButtons();
        });

        engine.getLoadWorker().workDoneProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldValue, final Number newValue) -> {
            if (newValue.intValue() >= 100) {
                loadingBar.setVisible(false);
                enableDisableButtons();
            } else {
                loadingBar.setVisible(true);
                enableDisableButtons();
            }
        });

        engine.getLoadWorker()
                .exceptionProperty()
                .addListener((ObservableValue<? extends Throwable> o, Throwable old, final Throwable value) -> {
                    if (engine.getLoadWorker().getState() == State.FAILED) {

                    }
                });
        engine.getLoadWorker().runningProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (newValue) {
                refreshStopButton.setGraphic(new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("javafxbrowser/frame/icon/stop-icon.png")))); // NOI18N
            } else {
                refreshStopButton.setGraphic(new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("javafxbrowser/frame/icon/refresh-icon.png")))); // NOI18N
            }
        });

        engine.load("http://www.google.com/");
    }

    private EventHandler<ActionEvent> buttonAction(final TextField textField,
            final ProgressBar progressBar,
            final WebEngine webEngine,
            final WebView webView) {
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String route = textField.getText();
                progressBar.progressProperty().bind(webEngine.getLoadWorker().progressProperty());
                webEngine.load(route);
            }
        };
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
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

    private void enableDisableButtons() {
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

}
