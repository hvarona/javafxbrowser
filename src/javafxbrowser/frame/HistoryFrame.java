package javafxbrowser.frame;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebHistory;

/**
 *
 * @author henry
 */
public class HistoryFrame {

    /**
     * Search tab Date Title URL
     */
    private final TableView table = new TableView();

    Map<Date, String[]> dateURLMap = new HashMap();

    public HistoryFrame(WebHistory history) {
        history.getEntries().stream().forEach((entry) -> {
            dateURLMap.put(entry.getLastVisitedDate(), new String[]{entry.getTitle(), entry.getUrl()});
        });
    }

    public void addHistory(Date date, String title, String url) {
        dateURLMap.put(date, new String[]{title, url});
    }

    public VBox getFrame() {
        final Label label = new Label("History");
        label.setFont(new Font("Arial", 20));
        table.setEditable(false);

        TableColumn dateCol = new TableColumn("Date");
        TableColumn titleCol = new TableColumn("Title");
        TableColumn urlCol = new TableColumn("URL");

        table.getColumns().addAll(dateCol, titleCol, urlCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        return vbox;
    }

}
