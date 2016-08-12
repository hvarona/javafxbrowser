/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxbrowser;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafxbrowser.frame.BroswerFXFrame;
import javafxbrowser.listener.BasicWebEngineChangeAction;

/**
 *
 * @author henry
 */
public class JavaFxBrowser extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BroswerFXFrame mainFrame = new BroswerFXFrame();
        BorderPane basePane = new BorderPane();
        basePane.setCenter(mainFrame.getRootPane(new BasicWebEngineChangeAction((String newValue) -> {
            primaryStage.setTitle(newValue);
        })));

        Scene scene = new Scene(basePane);
        primaryStage.setScene(scene);
        primaryStage.show();
        mainFrame.getEngine().load("http://www.google.com/");
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
