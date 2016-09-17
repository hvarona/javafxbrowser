package javafxbrowser.frame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebHistory;
import javafxbrowser.util.DragResizer;

/**
 *
 * @author henry
 */
public class HistoryFrame {

    /**
     * Search tab Date Title URL
     */
    private final TableView table = new TableView();

    Map<Date, HistoryEntry> dateURLMap = new HashMap();

    BrowserFXFrame browser;

    public HistoryFrame(WebHistory history, BrowserFXFrame browser) {
        history.getEntries().stream().forEach((entry) -> {
            dateURLMap.put(entry.getLastVisitedDate(), new HistoryEntry(entry.getLastVisitedDate().toString(), "", entry.getTitle(), entry.getUrl()));
        });

        this.browser = browser;
    }

    public void addHistory(Date date, String title, String url) {
        dateURLMap.put(date, new HistoryEntry(date.toString(), "", title, url));
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

        List<HistoryEntry> entries = new ArrayList();
        List<Date> dates = new ArrayList(dateURLMap.keySet());
        Collections.sort(dates);
        for (Date date : dates) {
            entries.add(dateURLMap.get(date));
        }

        table.getColumns().addAll(dateCol, titleCol, urlCol);
        table.setItems(FXCollections.observableList(entries));
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

    public class HistoryEntry {

        String date;
        String icon;
        String title;
        String url;

        public HistoryEntry(String date, String icon, String title, String url) {
            this.date = date;
            this.icon = icon;
            this.title = title;
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

    }

}
