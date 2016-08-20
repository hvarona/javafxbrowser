package javafxbrowser.cfg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henry
 */
public class BrowserConfigurator {

    private List<SearchEngine> searchEngines = new ArrayList();
    private SearchEngine defaultSearchEngine;

    public BrowserConfigurator() {
        createSampleSearchEngines();
    }
    
    private void createSampleSearchEngines(){
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

}