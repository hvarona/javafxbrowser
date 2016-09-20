package javafxbrowser.frame;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafxbrowser.util.HistoryEntry;

/**
 *
 * @author henry
 */
public class HistoryFrame {

    /**
     * Search tab Date Title URL
     */
    private final TableView table = new TableView();

    BrowserFXFrame browser;

    public HistoryFrame(BrowserFXFrame browser) {
        this.browser = browser;
    }

    public VBox getFrame() {
        final Label label = new Label("History");
        label.setFont(new Font("Arial", 20));
        table.setEditable(false);

        TableColumn dateCol = new TableColumn("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory<HistoryEntry, String>("date"));
        TableColumn titleCol = new TableColumn("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<HistoryEntry, String>("title"));
        TableColumn urlCol = new TableColumn("URL");
        urlCol.setCellValueFactory(new PropertyValueFactory<HistoryEntry, String>("url"));


        table.getColumns().addAll(dateCol, titleCol, urlCol);
        table.setItems(browser.getParent().getWebHistory());
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                browser.loadPage(((HistoryEntry) newSelection).getUrl());
            }
        });

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        return vbox;
    }

}
