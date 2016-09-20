package javafxbrowser.frame;

import java.io.File;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
import javafx.scene.layout.GridPane;
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

    private final JavaFxBrowser parent;

    private final Font titleFont = new Font("Arial", 20);

    public ConfigFrame(JavaFxBrowser parent) {
        this.parent = parent;
    }

    public TabPane getFrame() {
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
        updateOption.setContent(getAboutFrame());
        updateOption.setClosable(false);

        Options.getTabs().add(generalOption);
        Options.getTabs().add(searchOption);
        Options.getTabs().add(securityOption);
        Options.getTabs().add(contentOption);
        //Options.getTabs().add(applicationOption);
        Options.getTabs().add(privacyOption);
        Options.getTabs().add(customOption);
        Options.getTabs().add(networkOption);
        Options.getTabs().add(updateOption);
        Options.getSelectionModel().select(generalOption);
        return Options;
    }

    /**
     * General TODO Default Browser TODO Tabs options TODO Accesibility Options
     * TODO Check Spell
     *
     * @return
     */
    private Pane getGeneralFrame() {
        Label generalLabel = new Label("General Settings");
        generalLabel.setFont(titleFont);

        Label homePageLabel = new Label("Home Page : ");
        TextField homePage = new TextField();
        homePage.setText(parent.getConfig().getHomepage());
        homePage.textProperty().addListener((new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                parent.getConfig().setHomepage(homePage.getText());
            }
        }));

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
        downloadDirectory.setOnMouseClicked((MouseEvent event) -> {
            chooser.setInitialDirectory(new File(downloadDirectory.getText()));
            File directory = chooser.showDialog(parent.getScene().getWindow());
            if (directory != null) {
                parent.getConfig().setDefaultDownloadDirectory(directory.getAbsolutePath());
                downloadDirectory.setText(directory.getAbsolutePath());

            }
        });

        CheckBox defaultBrowser = new CheckBox("Set as System Default Browser");
        defaultBrowser.setSelected(false);
        defaultBrowser.setDisable(true);

        CheckBox newTabEmpty = new CheckBox("Open New Tab Empty");
        newTabEmpty.setSelected(parent.getConfig().isOpenNewTabEmpty());
        newTabEmpty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                parent.getConfig().setOpenNewTabEmpty(newTabEmpty.isSelected());
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(15);
        gridPane.setPadding(new Insets(0, 10, 0, 10));

        gridPane.add(generalLabel, 0, 0, 2, 1);
        GridPane.setHalignment(generalLabel, HPos.CENTER);
        gridPane.add(homePageLabel, 0, 1);
        gridPane.add(homePage, 1, 1);
        gridPane.add(downloadDirectoryLabel, 0, 2);
        gridPane.add(downloadDirectory, 1, 2);
        gridPane.add(defaultBrowser, 0, 3, 2, 1);
        gridPane.add(newTabEmpty, 0, 4, 2, 1);
        gridPane.setAlignment(Pos.TOP_CENTER);

        return gridPane;
    }

    /**
     * Search TODO delete
     *
     * @return
     */
    private Pane getSearchFrame() {
        Label titleLabel = new Label("Search Engine Settings");
        titleLabel.setFont(titleFont);
        List<SearchEngine> searchEngines = parent.getConfig().getSearchEngines();

        ComboBox<SearchEngine> defaultSearchEngine = new ComboBox();
        defaultSearchEngine.getItems().addAll(searchEngines);
        defaultSearchEngine.setValue(parent.getConfig().getDefaultSearchEngine());
        defaultSearchEngine.valueProperty().addListener((ObservableValue<? extends SearchEngine> observable, SearchEngine oldValue, SearchEngine newValue) -> {
            parent.getConfig().setDefaultSearchEngine(defaultSearchEngine.getSelectionModel().getSelectedItem());
        });
        final Label labelDefaultSearch = new Label("Default Search Engine");

        final HBox defaultSearchhbox = new HBox();
        defaultSearchhbox.setSpacing(5);

        defaultSearchhbox.getChildren().addAll(labelDefaultSearch, defaultSearchEngine);

        final Label labelsearchEngines = new Label("Search Engines List");
        labelsearchEngines.setFont(new Font("Arial", 16));

        TableView searchEnginesView = new TableView();
        searchEnginesView.setEditable(true);
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<SearchEngine, String>("name"));
        TableColumn urlCol = new TableColumn("URL");
        urlCol.setCellValueFactory(new PropertyValueFactory<SearchEngine, String>("url"));

        searchEnginesView.getColumns().addAll(nameCol, urlCol);
        ObservableList<SearchEngine> searchEnginesList = FXCollections.observableList(searchEngines);
        searchEnginesView.setItems(searchEnginesList);

        final Label labeladdSearchEngines = new Label("Add Search Engine");
        labeladdSearchEngines.setFont(new Font("Arial", 16));

        TextField addName = new TextField();
        TextField addURL = new TextField();
        Button addButton = new Button("Add new Search Engine");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (addName.getText() != null && addURL.getText() != null) {
                    SearchEngine newEngine = new SearchEngine(addName.getText(), addURL.getText());
                    defaultSearchEngine.getItems().add(newEngine);
                    searchEnginesList.add(newEngine);
                }
            }
        });

        final HBox editHbox = new HBox();

        editHbox.getChildren().addAll(addName, addURL, addButton);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().addAll(titleLabel, defaultSearchhbox, labelsearchEngines, searchEnginesView, labeladdSearchEngines, editHbox);
        vbox.setAlignment(Pos.TOP_CENTER);
        return vbox;
    }

    /**
     * Content TODO Popup window options TODO Languages TODO Font & Color
     *
     * @return
     */
    private Pane getContentFrame() {
        Label titleLabel = new Label("Content Settings");
        titleLabel.setFont(titleFont);
        VBox answer = new VBox();
        answer.setAlignment(Pos.TOP_CENTER);
        answer.getChildren().addAll(titleLabel);
        return answer;
    }

    /**
     * Applications TODO Contentt-type -> Action
     *
     * @return
     */
    private Pane getApplicationFrame() {
        Label titleLabel = new Label("Applications Settings");
        titleLabel.setFont(titleFont);
        VBox answer = new VBox();
        answer.setAlignment(Pos.TOP_CENTER);
        answer.getChildren().addAll(titleLabel);
        return answer;
    }

    /**
     * Privacy TODO UserData TODO Database options
     *
     * @return
     */
    private Pane getPrivacyFrame() {
        Label titleLabel = new Label("Privacy Settings");
        titleLabel.setFont(titleFont);

        CheckBox memoryOnlyData = new CheckBox();
        memoryOnlyData.setSelected(true);
        memoryOnlyData.setDisable(true);
        Label memoryOnlyDataLabel = new Label(" Memory Only");

        GridPane answer = new GridPane();
        answer.setAlignment(Pos.TOP_CENTER);
        answer.setHgap(5);
        answer.setVgap(15);
        answer.setPadding(new Insets(0, 10, 0, 10));
        answer.add(titleLabel, 0, 0, 2, 1);
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        answer.add(memoryOnlyDataLabel, 0, 1);
        answer.add(memoryOnlyData, 1, 1);
        return answer;
    }

    /**
     * Security -Block Sites -Login & Password -Certificates
     *
     * @return
     */
    private Pane getSecurityFrame() {
        Label titleLabel = new Label("Security Settings");
        titleLabel.setFont(titleFont);
        VBox answer = new VBox();
        answer.setAlignment(Pos.TOP_CENTER);
        answer.getChildren().addAll(titleLabel);
        return answer;
    }

    /**
     * Custom Menu Buton Enable Menu Bar TODO Enable disable buttons
     *
     * @return
     */
    private Pane getCustomFrame() {
        Label titleLabel = new Label("Custom Settings");
        titleLabel.setFont(titleFont);

        CheckBox menuBarEnable = new CheckBox("Menu Bar Enable");
        menuBarEnable.setSelected(parent.getConfig().isShowMenuBar());
        menuBarEnable.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                parent.showHideMenuBars(menuBarEnable.isSelected());
                parent.getConfig().setShowMenuBar(menuBarEnable.isSelected());
            }
        });
        CheckBox navigationBarEnable = new CheckBox(" Navigation Bar Enable");
        navigationBarEnable.setSelected(parent.getConfig().isShowNavigationBar());
        navigationBarEnable.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                parent.showHideNavigationBars(navigationBarEnable.isSelected());
                parent.getConfig().setShowNavigationBar(navigationBarEnable.isSelected());
            }
        });
        

        GridPane answer = new GridPane();
        answer.setAlignment(Pos.TOP_CENTER);
        answer.setHgap(5);
        answer.setVgap(15);
        answer.setPadding(new Insets(0, 10, 0, 10));
        answer.add(menuBarEnable, 0, 1);
        answer.add(navigationBarEnable, 0, 2);
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        return answer;
    }

    /**
     * Network -Proxy -Cache
     *
     * @return
     */
    private Pane getNetworkFrame() {
        Label titleLabel = new Label("Network Settings");
        titleLabel.setFont(titleFont);
        VBox answer = new VBox();
        answer.setAlignment(Pos.TOP_CENTER);
        answer.getChildren().addAll(titleLabel);
        return answer;
    }

    /**
     * About Version Update this WebBrowser
     *
     * @return
     */
    private Pane getAboutFrame() {
        Label titleLabel = new Label("About");
        titleLabel.setFont(titleFont);
        VBox answer = new VBox();
        answer.setAlignment(Pos.TOP_CENTER);
        answer.getChildren().addAll(titleLabel);
        return answer;
    }
}
