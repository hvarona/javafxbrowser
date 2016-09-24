package javafxbrowser.frame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
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
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.PopupFeatures;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Callback;
import javafxbrowser.JavaFxBrowser;
import javafxbrowser.cfg.BrowserConfigurator;
import javafxbrowser.listener.WebEngineChangeAction;
import javafxbrowser.manager.MenuHandler;
import javafxbrowser.util.DragResizer;
import netscape.javascript.JSObject;
import org.w3c.dom.Document;

/**
 *
 * @author henry
 */
public class BrowserFXFrame {

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

    private MenuHandler menuHandler;
    private ContextMenu contextMenu;

    private JavaFxBrowser parent;

    private final List<WebEngineChangeAction> changeActions = new ArrayList();

    public synchronized Parent getRootPane(JavaFxBrowser parent) {
        if (rootPane != null) {
            return rootPane;
        }
        menuHandler = new MenuHandler(parent, this);

        this.parent = parent;

        rootPane = new BorderPane();
        topPanel = new VBox();

        if (parent.getConfig().isShowMenuBar()) {
            topPanel.getChildren().add(menuHandler.getMenuBar());
        }
        if (parent.getConfig().isShowNavigationBar()) {
            topPanel.getChildren().add(createNavigatorBar());
        }
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
                String title = newValue;
                if (title == null || title.isEmpty()) {
                    try {
                        String fileName = new URL(currentURL).getFile();
                        while (fileName.contains("/")) {
                            fileName = fileName.substring(fileName.indexOf("/") + 1);
                        }
                        if (fileName.contains("?")) {
                            fileName = fileName.substring(0, fileName.indexOf("?"));
                        }
                        if (fileName.contains(".")) {
                            fileName = fileName.substring(0, fileName.indexOf("."));
                        }
                        title = fileName;
                    } catch (MalformedURLException ex) {
                        ex.printStackTrace();
                    }
                }
                action.titleChangeAction(title);
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

        webView.setContextMenuEnabled(false);
        webView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouse) {
                if (mouse.getButton() == MouseButton.SECONDARY) {
                    Point2D mousePoint = webView.sceneToLocal(mouse.getSceneX(), mouse.getSceneY());

                    JSObject el = (JSObject) engine.executeScript("document.elementFromPoint(" + mousePoint.getX() + "," + mousePoint.getY() + ");");
                    contextMenu = menuHandler.getContextMenu(el);
                    contextMenu.show(webView, mouse.getScreenX(), mouse.getScreenY());
                } else if (contextMenu != null) {
                    contextMenu.hide();
                }
            }
        });

        webView.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                System.out.println("contextMenu Event");

            }
        });

        engine.setCreatePopupHandler(new Callback<PopupFeatures, WebEngine>() {
            @Override
            public WebEngine call(PopupFeatures param) {
                // Open Link in new Window option
                return null;
            }
        });

        engine.getHistory().getEntries().addListener(new ListChangeListener<WebHistory.Entry>() {

            @Override
            public void onChanged(ListChangeListener.Change<? extends WebHistory.Entry> c) {
                if (c.next()) {
                    for (WebHistory.Entry entry : c.getAddedSubList()) {
                        parent.addHisotryEntry(entry);
                    }
                }

            }
        });

        return rootPane;
    }

    public void addChangeAction(WebEngineChangeAction action) {
        changeActions.add(action);
    }

    private BorderPane createNavigatorBar() {
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
        TextField searchText = new TextField();
        searchText.setPrefWidth(100);
        searchText.setOnAction((ActionEvent evt) -> {
            searchURL(searchText.getText());
        });

        topPaneRight.getChildren().addAll(goButton, searchText, menu);

        goButton.setOnAction(goButtonAction());
        textURL.setOnAction(goButtonAction());

        navigatorPane.setLeft(topPanelLeft);
        navigatorPane.setCenter(textURL);
        navigatorPane.setRight(topPaneRight);
        return navigatorPane;
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

        MenuItem swttingOption = new MenuItem("Settings");
        menu.getItems().add(swttingOption);
        swttingOption.setOnAction((ActionEvent evt) -> {
            parent.addSettingTab();
        });

        MenuItem closeOption = new MenuItem("Exit");
        menu.getItems().add(closeOption);
        closeOption.setOnAction((ActionEvent evt) -> {
            System.exit(0);
        });
    }

    public void createSearchWindow() {
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
            loadPage(textURL.getText());
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

    public void reloadPage() {
        engine.load(currentURL);
    }

    public void savePage() {
        Document doc = engine.getDocument();
        if (doc != null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Page File");
            if (parent.getConfig().getDefaultDownloadDirectory() == null) {
                fileChooser.setInitialDirectory(engine.getUserDataDirectory());
            } else {
                fileChooser.setInitialDirectory(new File(parent.getConfig().getDefaultDownloadDirectory()));
            }
            String fileExtension = "html";
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

                if (fileName.contains(".")) {
                    fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
                }

                fileChooser.setInitialFileName(fileName);
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
                fileChooser.setInitialFileName(engine.getTitle());
            }
            fileChooser.getExtensionFilters().add(new ExtensionFilter(fileExtension.toUpperCase() + " File", "*." + fileExtension.toLowerCase()));

            File file = fileChooser.showSaveDialog(webView.getScene().getWindow());
            if (file != null) {
                if (doc.getDoctype() != null) {
                    try (FileWriter fileWriter = new FileWriter(file)) {
                        fileWriter.write((String) engine.executeScript("document.documentElement.outerHTML"));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                } else {
                    downloadFile(file, currentURL);
                    //not an html file;
                }
            }
        }
    }

    private void downloadFile(File output, String url) {
        try (InputStream in = new URL(url).openStream()) {
            Files.copy(in, output.toPath(), StandardCopyOption.REPLACE_EXISTING);
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void searchURL(String searchText) {
        String url = parent.getConfig().getDefaultSearchEngine().getUrl();
        url = url.replaceAll("%s", "\"" + searchText + "\"");
        engine.load(url);
    }

    public void hideShowNavigationBar(boolean show) {
        if (show) {
            topPanel.getChildren().add(createNavigatorBar());
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
        try {
            topPanel.getChildren().stream().filter((topPanelChildren) -> (topPanelChildren.getId().equalsIgnoreCase("menuBar"))).forEach((Node topPanelChildren) -> {
                ((MenuBar) topPanelChildren).getMenus().stream().filter((menu) -> (menu.getId().equalsIgnoreCase("menuView"))).forEach((Menu menu) -> {
                    menu.getItems().stream().filter((item) -> (item instanceof CheckMenuItem && item.getId().equalsIgnoreCase("navigationBarOption"))).forEach((MenuItem item) -> {
                        ((CheckMenuItem) item).setSelected(show);
                    });
                });
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hideShowMenuBar(boolean show) {
        if (show) {
            topPanel.getChildren().add(0, menuHandler.getMenuBar());
        } else {
            Node menuNode = null;
            for (Node node : topPanel.getChildren()) {
                if (node.getId().equalsIgnoreCase("menuBar")) {
                    menuNode = node;
                }
            }
            if (menuNode != null) {
                topPanel.getChildren().remove(menuNode);
            }
        }
    }

    public void loadPage(String url) {
        try {
            new URL(url).openStream().close();
        } catch (MalformedURLException exception) {
            if (url.contains(" ")) {
                searchURL(textURL.getText());
                return;
            }
            url = "http://" + url + "/";
            try {
                new URL(url).openStream().close();
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
        engine.load(url);
    }

    public void showHistoryWindow() {
        HistoryFrame history = new HistoryFrame(this);
        VBox vbox = history.getFrame();
        rootPane.setRight(vbox);
        DragResizer.makeResizable(vbox);
    }

    public void hideHistoryWindw() {
        rootPane.setRight(null);
    }

    public JavaFxBrowser getParent() {
        return parent;
    }

}
