package javafxbrowser.cfg;

/**
 *
 * @author henry
 */
public class SearchEngine {

    private String name;
    private String url;

    public SearchEngine(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return name;
    }
    
    

}
