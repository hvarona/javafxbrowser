package javafxbrowser;

import insidefx.undecorator.Undecorator;
import java.net.CookieManager;
import java.net.URL;
import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafxbrowser.cfg.BrowserConfigurator;
import javafxbrowser.frame.BrowserFXFrame;
import javafxbrowser.frame.ConfigFrame;
import javafxbrowser.listener.BasicWebEngineChangeAction;
import javafxbrowser.manager.CacheHandler;
import javafxbrowser.manager.CookieHandler;

/**
 *
 * @author henry
 */
public class JavaFxBrowser extends Application {

    private final TabPane tabs = new TabPane();
    private BrowserConfigurator defaultConfig;

    private CacheHandler cacheHandler;
    private CookieHandler cookieHandler;

    private Scene scene;

    private Tab settingTab;

    @Override
    public void start(Stage primaryStage) throws Exception {
        cacheHandler = new CacheHandler();
        URL.setURLStreamHandlerFactory(cacheHandler);
        cookieHandler = new CookieHandler();
        CookieManager.setDefault(cookieHandler.getCookieManager());
        defaultConfig = new BrowserConfigurator();
        tabs.setTabMinHeight(30);
        tabs.setTabMaxWidth(40);
        tabs.setMinHeight(600);
        tabs.setMinWidth(800);
        Tab buttonTab = new Tab();
        buttonTab.setText("+");
        buttonTab.setClosable(false);
        tabs.getTabs().add(buttonTab);
        buttonTab.setOnSelectionChanged((Event event) -> {
            addTab();
        });

        Undecorator undecorator = new Undecorator(primaryStage, tabs);
        undecorator.getStylesheets().add("skin/undecorator.css");
        Node menu = undecorator.lookup("#StageMenu");
        menu.setVisible(false);
        scene = new Scene(undecorator);
        scene.setFill(Color.TRANSPARENT);

        //Scene scene = new Scene(tabs);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(400);
        primaryStage.setTitle("No title bar");
        primaryStage.setScene(scene);
        primaryStage.show();
        addTab();
    }

    public void addTab() {
        BrowserFXFrame newFrame = new BrowserFXFrame();
        Tab tab = tabs.getTabs().get(tabs.getTabs().size() - 1);
        tab.setText("New Window");
        tab.setContent(newFrame.getRootPane(this));
        newFrame.addChangeAction(new BasicWebEngineChangeAction((String newValue) -> {
            tab.setText(newValue);
        }));
        tab.setOnSelectionChanged((Event event) -> {
        });
        tab.setOnClosed((Event event) -> {
            if (tabs.getTabs().size() > 2) {
                tabs.getTabs().stream().forEach((tb) -> {
                    tb.setClosable(true);
                });
            } else {
                tabs.getTabs().stream().forEach((tb) -> {
                    tb.setClosable(false);
                });
            }
        });
        tabs.getSelectionModel().select(tab);
        if (tabs.getTabs().size() > 1) {
            tabs.getTabs().stream().forEach((tb) -> {
                tb.setClosable(true);
            });
        } else {
            tabs.getTabs().stream().forEach((tb) -> {
                tb.setClosable(false);
            });
        }
        Tab buttonTab = new Tab();
        buttonTab.setText("+");
        buttonTab.setClosable(false);
        buttonTab.setOnSelectionChanged((Event event) -> {
            addTab();
        });
        tabs.getTabs().add(buttonTab);
        if (!defaultConfig.isOpenNewTabEmpty()) {
            newFrame.loadPage(defaultConfig.getHomepage());
        }
    }

    public void addTab(String url) {
        BrowserFXFrame newFrame = new BrowserFXFrame();
        Tab tab = tabs.getTabs().get(tabs.getTabs().size() - 1);
        tab.setText("New Window");
        tab.setContent(newFrame.getRootPane(this));
        newFrame.addChangeAction(new BasicWebEngineChangeAction((String newValue) -> {
            tab.setText(newValue);
        }));
        tab.setOnSelectionChanged((Event event) -> {
        });
        tab.setOnClosed((Event event) -> {
            if (tabs.getTabs().size() > 2) {
                tabs.getTabs().stream().forEach((tb) -> {
                    tb.setClosable(true);
                });
            } else {
                tabs.getTabs().stream().forEach((tb) -> {
                    tb.setClosable(false);
                });
            }
        });
        tabs.getSelectionModel().select(tab);
        if (tabs.getTabs().size() > 1) {
            tabs.getTabs().stream().forEach((tb) -> {
                tb.setClosable(true);
            });
        } else {
            tabs.getTabs().stream().forEach((tb) -> {
                tb.setClosable(false);
            });
        }
        Tab buttonTab = new Tab();
        buttonTab.setText("+");
        buttonTab.setClosable(false);
        buttonTab.setOnSelectionChanged((Event event) -> {
            addTab();
        });
        tabs.getTabs().add(buttonTab);
        newFrame.getEngine().load(defaultConfig.getHomepage());
    }

    public void addSettingTab() {
        if (settingTab != null) {
            tabs.getSelectionModel().select(settingTab);
            return;
        }
        ConfigFrame configFrame = new ConfigFrame(this);
        settingTab = tabs.getTabs().get(tabs.getTabs().size() - 1);
        settingTab.setText("Settings");
        settingTab.setContent(configFrame.getFrame());
        settingTab.setOnSelectionChanged((Event event) -> {
        });
        settingTab.setOnClosed((Event event) -> {
            if (tabs.getTabs().size() > 2) {
                tabs.getTabs().stream().forEach((tb) -> {
                    tb.setClosable(true);
                });
            } else {
                tabs.getTabs().stream().forEach((tb) -> {
                    tb.setClosable(false);
                });
            }
            settingTab = null;
        });
        tabs.getSelectionModel().select(settingTab);
        if (tabs.getTabs().size() > 1) {
            tabs.getTabs().stream().forEach((tb) -> {
                tb.setClosable(true);
            });
        } else {
            tabs.getTabs().stream().forEach((tb) -> {
                tb.setClosable(false);
            });
        }
        Tab buttonTab = new Tab();
        buttonTab.setText("+");
        buttonTab.setClosable(false);
        buttonTab.setOnSelectionChanged((Event event) -> {
            addTab();
        });
        tabs.getTabs().add(buttonTab);
    }

    public BrowserConfigurator getConfig() {
        return defaultConfig;
    }

    public Scene getScene() {
        return scene;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*SwingUtilities.invokeLater(new Runnable() {

         @Override
         public void run() {
         try {
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
         } catch (Exception e) {
         }

         BrowserFrame main = new BrowserFrame();
         main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         main.setVisible(true);
         main.loadURL("http://www.google.com/"); //Home Page
         }
         });*/
        launch(args);
    }

}
