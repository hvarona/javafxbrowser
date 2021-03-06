package javafxbrowser.cfg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henry
 */
public class BrowserConfigurator {

    private String homepage = "http://www.google.com/";
    private String defaultDownloadDirectory = System.getProperty("user.home");

    private List<SearchEngine> searchEngines = new ArrayList();
    private SearchEngine defaultSearchEngine;

    private boolean openNewTabEmpty = false;

    private boolean showMenuBar = true;
    private boolean showNavigationBar = true;

    public BrowserConfigurator() {
        createSampleSearchEngines();
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getDefaultDownloadDirectory() {
        return defaultDownloadDirectory;
    }

    public void setDefaultDownloadDirectory(String defaultDownloadDirectory) {
        this.defaultDownloadDirectory = defaultDownloadDirectory;
    }

    private void createSampleSearchEngines() {
        SearchEngine google = new SearchEngine("Google", "https://www.google.com/search?q=%s");
        SearchEngine yahoo = new SearchEngine("Yahoo", "https://search.yahoo.com/search?p=%s");
        searchEngines.add(google);
        searchEngines.add(yahoo);
        defaultSearchEngine = google;
    }

    public List<SearchEngine> getSearchEngines() {
        return searchEngines;
    }

    public void setSearchEngines(List<SearchEngine> searchEngines) {
        this.searchEngines = searchEngines;
    }

    public SearchEngine getDefaultSearchEngine() {
        return defaultSearchEngine;
    }

    public void setDefaultSearchEngine(SearchEngine defaultSearchEngine) {
        this.defaultSearchEngine = defaultSearchEngine;
    }

    public boolean isOpenNewTabEmpty() {
        return openNewTabEmpty;
    }

    public void setOpenNewTabEmpty(boolean openNewTabEmpty) {
        this.openNewTabEmpty = openNewTabEmpty;
    }

    public boolean isShowMenuBar() {
        return showMenuBar;
    }

    public void setShowMenuBar(boolean showMenuBar) {
        this.showMenuBar = showMenuBar;
    }

    public boolean isShowNavigationBar() {
        return showNavigationBar;
    }

    public void setShowNavigationBar(boolean showNavigationBar) {
        this.showNavigationBar = showNavigationBar;
    }

}
