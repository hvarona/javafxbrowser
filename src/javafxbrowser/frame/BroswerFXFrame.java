package javafxbrowser.frame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafxbrowser.JavaFxBrowser;
import javafxbrowser.cfg.BrowserConfigurator;
import javafxbrowser.listener.WebEngineChangeAction;
import org.w3c.dom.Document;

/**
 *
 * @author henry
 */
public class BroswerFXFrame {

    /*
    TODO:
    - MEnu bar
    - Print option
    - Save PAge option
    - Search url textField
     */
    private String currentURL = "";

    private BorderPane rootPane;
    private VBox topPanel;
    private StackPane bottomPanel;
    private StackPane centerPane;

    private Button backwardButton;
    private Button forwardButton;
    private Button refreshStopButton;
    private ProgressBar loadingBar;

    private Label textStatus;
    private TextField textURL;
    private WebEngine engine;
    private WebView webView;

    private String lastFindText = "";

    private BrowserConfigurator config;

    private JavaFxBrowser parent;

    private final List<WebEngineChangeAction> changeActions = new ArrayList();

    public synchronized Parent getRootPane(BrowserConfigurator config, JavaFxBrowser parent) {
        if (rootPane != null) {
            return rootPane;
        }
        this.parent = parent;

        this.config = config;

        rootPane = new BorderPane();
        topPanel = new VBox();
        topPanel.getChildren().add(createMenuBar());
        topPanel.getChildren().add(createNAvigatorBar());
        rootPane.setTop(topPanel);

        createBottomPane();
        rootPane.setBottom(bottomPanel);
        centerPane = new StackPane();
        centerPane.setAlignment(Pos.TOP_RIGHT);

        ScrollPane scrollPane = new ScrollPane();
        centerPane.getChildren().add(scrollPane);
        webView = new WebView();
        engine = webView.getEngine();

        scrollPane.setContent(webView);
        scrollPane.getStyleClass().add("noborder-scroll-pane");
        scrollPane.setStyle("-fx-background-color: white");
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        engine.titleProperty().addListener((ObservableValue<? extends String> observable, String oldValue, final String newValue) -> {
            changeActions.stream().forEach((action) -> {
                action.titleChangeAction(newValue);
            });
        });

        engine.setOnStatusChanged((final WebEvent<String> event) -> {
            changeActions.stream().forEach((action) -> {
                action.onStatusChangeAction(event.getData(), this);
            });
        });

        engine.locationProperty().addListener((ObservableValue<? extends String> ov, String oldValue, final String newValue) -> {
            changeActions.stream().forEach((action) -> {
                action.locationChangeAction(newValue, this);
            });
        });

        engine.getLoadWorker().workDoneProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldValue, final Number newValue) -> {

            changeActions.stream().forEach((action) -> {
                action.workDoneAction(newValue.intValue(), this);
            });
        });

        engine.getLoadWorker().exceptionProperty().addListener((ObservableValue<? extends Throwable> o, Throwable old, final Throwable value) -> {
            changeActions.stream().forEach((action) -> {
                action.exceptionAction(value, this);
            });
        });
        engine.getLoadWorker().runningProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            changeActions.stream().forEach((action) -> {
                action.runStateAction(newValue, this);
            });
        });

        rootPane.setCenter(centerPane);

        return rootPane;
    }

    public void addChangeAction(WebEngineChangeAction action) {
        changeActions.add(action);
    }

    private BorderPane createNAvigatorBar() {
        BorderPane navigatorPane = new BorderPane();
        navigatorPane.setId("navigatorBar");
        navigatorPane.setPrefHeight(20);

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
        MenuButton menu = new MenuButton("Menu");
        loadMenu(menu);
        goButton.setPrefSize(35, 17);
        topPaneRight.getChildren().addAll(goButton, menu);

        goButton.setOnAction(goButtonAction());
        textURL.setOnAction(goButtonAction());

        navigatorPane.setLeft(topPanelLeft);
        navigatorPane.setCenter(textURL);
        navigatorPane.setRight(topPaneRight);
        return navigatorPane;
    }

    private MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.setId("menuBar");
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);

        MenuItem newTabOption = new MenuItem("New Tab");
        menuFile.getItems().add(newTabOption);
        newTabOption.setOnAction((ActionEvent evt) -> {
            parent.addTab();
        });

        MenuItem saveOption = new MenuItem("Save Page");
        menuFile.getItems().add(saveOption);
        saveOption.setOnAction((ActionEvent evt) -> {
            savePage();
        });
        MenuItem printOption = new MenuItem("Print page");
        menuFile.getItems().add(printOption);
        printOption.setOnAction((ActionEvent evt) -> {
            printPage();
        });

        MenuItem closeOption = new MenuItem("Exit");
        menuFile.getItems().add(closeOption);
        closeOption.setOnAction((ActionEvent evt) -> {
            System.exit(0);
        });
        MenuItem searchOption = new MenuItem("Search");
        menuEdit.getItems().add(searchOption);
        searchOption.setOnAction((ActionEvent evt) -> {
            createSearchWindow();
        });

        CheckMenuItem viewNavigationOption = new CheckMenuItem("NavigationBar");
        viewNavigationOption.setSelected(true);
        viewNavigationOption.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            if (new_val) {
                topPanel.getChildren().add(createNAvigatorBar());
                textURL.setText(currentURL);
            } else {
                Node navigatorNode = null;
                for (Node node : topPanel.getChildren()) {
                    if (node.getId().equalsIgnoreCase("navigatorBar")) {
                        navigatorNode = node;
                    }
                }
                if (navigatorNode != null) {
                    topPanel.getChildren().remove(navigatorNode);
                }
            }
        });

        menuView.getItems().add(viewNavigationOption);

        return menuBar;
    }

    private void loadMenu(MenuButton menu) {
        MenuItem saveOption = new MenuItem("Save Page");
        menu.getItems().add(saveOption);
        saveOption.setOnAction((ActionEvent evt) -> {
            savePage();
        });
        MenuItem searchOption = new MenuItem("Search");
        menu.getItems().add(searchOption);
        searchOption.setOnAction((ActionEvent evt) -> {
            createSearchWindow();
        });
        MenuItem printOption = new MenuItem("Print page");
        menu.getItems().add(printOption);
        printOption.setOnAction((ActionEvent evt) -> {
            printPage();
        });

        MenuItem closeOption = new MenuItem("Exit");
        menu.getItems().add(closeOption);
        closeOption.setOnAction((ActionEvent evt) -> {
            System.exit(0);
        });
    }

    private void createSearchWindow() {
        for (Node child : centerPane.getChildren()) {
            if (child.getId() != null && child.getId().equals("searchPanel")) {
                return;
            }
        }
        HBox hbox = new HBox(5);
        hbox.setId("searchPanel");
        hbox.setMinHeight(30);
        hbox.setMaxHeight(30);
        hbox.setMaxWidth(260);
        hbox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        TextField searchText = new TextField();
        Button nextSearchButton = new Button(">");
        nextSearchButton.setPrefSize(35, 17);
        nextSearchButton.setDisable(true);
        Button prevSearchButton = new Button("<");
        nextSearchButton.setPrefSize(35, 17);
        prevSearchButton.setDisable(true);
        Button closSearchButton = new Button("X");
        closSearchButton.setPrefSize(35, 17);
        searchText.setOnAction((ActionEvent evt) -> {
            if (engine.getDocument() != null) {
                lastFindText = searchText.getText();
                if ((boolean) engine.executeScript("window.find(\"" + lastFindText + "\");")) {
                    nextSearchButton.setDisable(false);
                    prevSearchButton.setDisable(false);
                } else {
                    engine.executeScript("window.getSelection().removeAllRanges();");
                    nextSearchButton.setDisable(true);
                    prevSearchButton.setDisable(true);
                }
            }
        });
        nextSearchButton.setOnAction((ActionEvent evt) -> {
            engine.executeScript("window.find(\"" + lastFindText + "\",false,false)");
        });
        prevSearchButton.setOnAction((ActionEvent evt) -> {
            engine.executeScript("window.find(\"" + lastFindText + "\",false,true)");
        });
        closSearchButton.setOnAction((ActionEvent evt) -> {
            centerPane.getChildren().remove(hbox);
        });
        hbox.getChildren().addAll(searchText, prevSearchButton, nextSearchButton, closSearchButton);
        //AnchorPane.setRightAnchor(hbox, 5.0);
        centerPane.getChildren().add(hbox);
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
            try {
                new URL(route).openStream().close();
            } catch (MalformedURLException exception) {
                if (route.contains(" ")) {
                    searchURL(textURL.getText());
                    return;
                }
                route = "http://" + route + "/";
                try {
                    new URL(route).openStream().close();
                } catch (MalformedURLException ex) {
                    searchURL(textURL.getText());
                    return;
                } catch (IOException ex) {
                    searchURL(textURL.getText());
                    return;
                }
            } catch (IOException ex) {
                searchURL(textURL.getText());
                return;
            }
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

    public void printPage() {
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null && job.showPrintDialog(webView.getScene().getWindow())) {
            engine.print(job);
            job.endJob();
        }
    }

    private void savePage() {
        Document doc = engine.getDocument();
        if (doc != null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Page File");
            fileChooser.setInitialDirectory(engine.getUserDataDirectory());
            try {

                String fileName = new URL(currentURL).getFile();
                while (fileName.contains("/")) {
                    fileName = fileName.substring(fileName.indexOf("/") + 1);
                }
                if (fileName.contains("?")) {
                    fileName = fileName.substring(0, fileName.indexOf("?"));
                }
                if (fileName.isEmpty()) {
                    fileName = engine.getTitle() + ".html";
                }

                fileChooser.setInitialFileName(fileName);
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
                fileChooser.setInitialFileName(engine.getTitle());
            }
            fileChooser.getExtensionFilters().add(new ExtensionFilter("HTML File", "*.html"));

            File file = fileChooser.showSaveDialog(webView.getScene().getWindow());
            if (file != null) {
                if (doc.getDoctype() != null) {
                    try (FileWriter fileWriter = new FileWriter(file)) {
                        fileWriter.write((String) engine.executeScript("document.documentElement.outerHTML"));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                } else {
                    //not an html file;
                }
            }
        }
    }

    private void searchURL(String searchText) {
        String url = this.config.getDefaultSearchEngine().getUrl();
        url = url.replaceAll("%s", "\"" + searchText + "\"");
        engine.load(url);
    }

}
