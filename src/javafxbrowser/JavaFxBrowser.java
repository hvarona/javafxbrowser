package javafxbrowser;

import insidefx.undecorator.Undecorator;
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
import javafxbrowser.frame.BroswerFXFrame;
import javafxbrowser.listener.BasicWebEngineChangeAction;

/**
 *
 * @author henry
 */
public class JavaFxBrowser extends Application {

    private final TabPane tabs = new TabPane();
    private BrowserConfigurator defaultConfig;

    @Override
    public void start(Stage primaryStage) throws Exception {
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
        Scene scene = new Scene(undecorator);
        scene.setFill(Color.TRANSPARENT);

        //Scene scene = new Scene(tabs);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(400);
        primaryStage.setTitle("No title bar");
        primaryStage.setScene(scene);
        primaryStage.show();
        addTab("http://www.google.com/"); //homePage
    }

    private void addTab() {
        BroswerFXFrame newFrame = new BroswerFXFrame();
        Tab tab = tabs.getTabs().get(tabs.getTabs().size() - 1);
        tab.setText("New Window");
        tab.setContent(newFrame.getRootPane(defaultConfig));
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
    }

    private void addTab(String url) {
        BroswerFXFrame newFrame = new BroswerFXFrame();
        Tab tab = tabs.getTabs().get(tabs.getTabs().size() - 1);
        tab.setText("New Window");
        tab.setContent(newFrame.getRootPane(defaultConfig));
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
        newFrame.getEngine().load(url);
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
