package javafxbrowser.util;

/**
 *
 * @author hvarona
 */
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
