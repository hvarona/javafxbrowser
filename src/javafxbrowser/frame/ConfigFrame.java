package javafxbrowser.frame;

import java.io.File;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafxbrowser.JavaFxBrowser;
import javafxbrowser.cfg.SearchEngine;

/**
 *
 * @author henry
 */
public class ConfigFrame {

    /*
     General
     -HomePage
     -Download Directory
     -Default Browser
     -Tabs options
     -Accesibility Options
     -Check Spell
     Search
     -Default Search Motor
     -List Search Mtor (add/Edit(delete)
     Content
     -Popup window options
     -Languages
     -Font & Color
     Applications
     -Contentt-type -> Action
     Privacy
     -UserData (memory Database)
     Security
     -Block Sites
     -Login & Password
     -Certificates
     Custom Menu
     -Enable Menu Buton
     -Enable /Disbale Menu Options
     Network
     -Proxy
     -Cache
     Update
     -Update this WebBrowser
    
     */
    private JavaFxBrowser parent;

    private boolean isSelectingDirectory = false;

    public ConfigFrame(JavaFxBrowser parent) {
        this.parent = parent;
    }

    public Pane getFrame() {
        Pane answer = new Pane();
        TabPane Options = new TabPane();
        Tab generalOption = new Tab("General");
        generalOption.setContent(getGeneralFrame());
        generalOption.setClosable(false);

        Tab searchOption = new Tab("Search");
        searchOption.setContent(getSearchFrame());
        searchOption.setClosable(false);

        Tab securityOption = new Tab("Security");
        securityOption.setContent(getSecurityFrame());
        securityOption.setClosable(false);

        Tab contentOption = new Tab("Content");
        contentOption.setContent(getContentFrame());
        contentOption.setClosable(false);

        Tab applicationOption = new Tab("Application");
        applicationOption.setContent(getApplicationFrame());
        applicationOption.setClosable(false);

        Tab privacyOption = new Tab("Privacy");
        privacyOption.setContent(getPrivacyFrame());
        privacyOption.setClosable(false);

        Tab customOption = new Tab("Custom");
        customOption.setContent(getCustomFrame());
        customOption.setClosable(false);

        Tab networkOption = new Tab("Network");
        networkOption.setContent(getNetworkFrame());
        networkOption.setClosable(false);

        Tab updateOption = new Tab("Update");
        updateOption.setContent(getUpdateFrame());
        updateOption.setClosable(false);

        Options.getTabs().addAll(generalOption, searchOption, securityOption, contentOption, applicationOption, privacyOption, customOption, networkOption, updateOption);
        Options.getSelectionModel().select(generalOption);
        answer.getChildren().add(Options);
        return answer;
    }

    private Pane getGeneralFrame() {
        VBox answer = new VBox();
        Label homePageLabel = new Label("Home Page : ");
        TextField homePage = new TextField();
        homePage.setText(parent.getConfig().getHomepage());
        homePage.textProperty().addListener((new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                parent.getConfig().setHomepage(homePage.getText());
            }
        }));
        HBox homePageHbox = new HBox();
        homePageHbox.getChildren().addAll(homePageLabel, homePage);

        Label downloadDirectoryLabel = new Label("Download Directory : ");
        TextField downloadDirectory = new TextField();
        downloadDirectory.setText(parent.getConfig().getDefaultDownloadDirectory());
        downloadDirectory.setEditable(false);
        downloadDirectory.textProperty().addListener((new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                parent.getConfig().setDefaultDownloadDirectory(downloadDirectory.getText());
            }
        }));
        DirectoryChooser chooser = new DirectoryChooser();
        if (parent.getConfig().getDefaultDownloadDirectory() == null) {
            chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        } else {
            chooser.setInitialDirectory(new File(parent.getConfig().getDefaultDownloadDirectory()));
        }
        downloadDirectory.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                File directory = chooser.showDialog(parent.getScene().getWindow());
                if (directory != null) {
                    parent.getConfig().setDefaultDownloadDirectory(directory.getAbsolutePath());
                    downloadDirectory.setText(directory.getAbsolutePath());

                }
            }
        });
        HBox defaultDownloadDirectoryHbox = new HBox();
        defaultDownloadDirectoryHbox.getChildren().addAll(downloadDirectoryLabel, downloadDirectory);

        CheckBox defaultBrowser = new CheckBox();
        defaultBrowser.setSelected(false);
        defaultBrowser.setDisable(true);

        answer.getChildren().addAll(homePageHbox, defaultDownloadDirectoryHbox);
        return answer;
    }

    private Pane getSearchFrame() {
        Pane answer = new Pane();
        List<SearchEngine> searchEngines = parent.getConfig().getSearchEngines();

        ComboBox<SearchEngine> defaultSearchEngine = new ComboBox();
        defaultSearchEngine.getItems().addAll(searchEngines);
        defaultSearchEngine.setValue(parent.getConfig().getDefaultSearchEngine());
        defaultSearchEngine.valueProperty().addListener((ObservableValue<? extends SearchEngine> observable, SearchEngine oldValue, SearchEngine newValue) -> {
            parent.getConfig().setDefaultSearchEngine(defaultSearchEngine.getSelectionModel().getSelectedItem());
        });
        final Label labelDefaultSearch = new Label("Default Search Engine");
        final HBox hbox = new HBox();
        hbox.setSpacing(5);
        //hbox.setPadding(new Insets(10, 0, 0, 10));

        hbox.getChildren().addAll(labelDefaultSearch, defaultSearchEngine);

        TableView searchEnginesView = new TableView();
        searchEnginesView.setEditable(true);
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<SearchEngine, String>("name"));
        TableColumn urlCol = new TableColumn("URL");
        urlCol.setCellValueFactory(new PropertyValueFactory<SearchEngine, String>("url"));

        searchEnginesView.getColumns().addAll(nameCol, urlCol);
        searchEnginesView.setItems(FXCollections.observableList(searchEngines));

        final Label labelsearchEngines = new Label("Search Engines ");
        labelsearchEngines.setFont(new Font("Arial", 20));
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        //vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(hbox, labelsearchEngines, searchEnginesView);

        answer.getChildren().addAll(vbox);

        return answer;
    }

    private Pane getContentFrame() {
        Pane answer = new Pane();
        return answer;
    }

    private Pane getApplicationFrame() {
        Pane answer = new Pane();
        return answer;
    }

    private Pane getPrivacyFrame() {
        Pane answer = new Pane();
        return answer;
    }

    private Pane getSecurityFrame() {
        Pane answer = new Pane();
        return answer;
    }

    private Pane getCustomFrame() {
        Pane answer = new Pane();
        return answer;
    }

    private Pane getNetworkFrame() {
        Pane answer = new Pane();
        return answer;
    }

    private Pane getUpdateFrame() {
        Pane answer = new Pane();
        return answer;
    }
}
