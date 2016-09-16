package javafxbrowser.frame;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafxbrowser.cfg.BrowserConfigurator;
import javafxbrowser.cfg.SearchEngine;

/**
 *
 * @author henry
 */
public class ConfigFrame {

    /*
     General
     HomePage
     Download Directory
     Default Browser
     Tabs options
     Accesibility Options
     Check Spell
     Search
     Default Search Motor
     List Search Mtor (add/Edit(delete)
     Content
     Popup window options
     Languages
     Font & Color
     Applications
     Contentt-type -> Action
     Privacy
     UserData (memory Database)
     Security
     Block Sites
     Login & Password
     Certificates
     Custom Menu
     Enable Menu Buton
     Enable /Disbale Menu Options
     Network
     Proxy
     Cache
     Update
     Update this WebBrowser
    
     */
    private BrowserConfigurator config;

    public ConfigFrame(BrowserConfigurator config) {
        this.config = config;
    }

    public Pane getFrame() {
        Pane answer = new Pane();
        TabPane Options = new TabPane();
        Tab generalOption = new Tab("General");
        generalOption.setContent(getGeneralFrame());

        Tab searchOption = new Tab("Search");
        searchOption.setContent(getSearchFrame());

        Tab securityOption = new Tab("Security");
        securityOption.setContent(getSecurityFrame());

        Tab contentOption = new Tab("Content");
        contentOption.setContent(getContentFrame());

        Tab applicationOption = new Tab("Application");
        applicationOption.setContent(getApplicationFrame());

        Tab privacyOption = new Tab("Privacy");
        privacyOption.setContent(getPrivacyFrame());

        Tab customOption = new Tab("Custom");
        customOption.setContent(getCustomFrame());

        Tab networkOption = new Tab("Network");
        networkOption.setContent(getNetworkFrame());

        Tab updateOption = new Tab("Update");
        updateOption.setContent(getUpdateFrame());

        Options.getTabs().addAll(generalOption, searchOption, securityOption, contentOption, applicationOption, privacyOption, customOption, networkOption, updateOption);

        return answer;
    }

    private Pane getGeneralFrame() {
        Pane answer = new Pane();
        TextField homePage = new TextField();
        TextField downloadDirectory = new TextField();
        CheckBox defaultBrowser = new CheckBox();
        return answer;
    }

    private Pane getSearchFrame() {
        Pane answer = new Pane();
        List<SearchEngine> searchEngines = config.getSearchEngines();

        ComboBox<SearchEngine> defaultSearchEngine = new ComboBox();
        defaultSearchEngine.getItems().addAll(searchEngines);
        defaultSearchEngine.setValue(config.getDefaultSearchEngine());
        final Label labelDefaultSearch = new Label("Default Search Engine");
        final HBox hbox = new HBox();
        hbox.setSpacing(5);
        hbox.setPadding(new Insets(10, 0, 0, 10));

        hbox.getChildren().addAll(labelDefaultSearch, defaultSearchEngine);

        TableView searchEnginesView = new TableView();
        searchEnginesView.setEditable(true);
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<SearchEngine, String>("Name"));
        TableColumn urlCol = new TableColumn("URL");
        nameCol.setCellValueFactory(new PropertyValueFactory<SearchEngine, String>("URL"));

        searchEnginesView.getColumns().addAll(nameCol, urlCol);
        searchEnginesView.setItems(FXCollections.observableList(searchEngines));

        final Label labelsearchEngines = new Label("Search Engines ");
        labelsearchEngines.setFont(new Font("Arial", 20));
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(hbox, labelsearchEngines, searchEnginesView);

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
