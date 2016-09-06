package javafxbrowser.manager;

import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hvarona
 */
public class CookieHandler {

    private CookieManager manager;

    public CookieHandler() {
        manager = new CookieManager();
    }

    public CookieManager getCookieManager() {
        return manager;
    }

    public void deleteCookies() {
        manager.getCookieStore().removeAll();
    }

    public Map<URI, List<HttpCookie>> getStoredCookies() {
        Map<URI, List<HttpCookie>> answer = new HashMap();
        manager.getCookieStore().getURIs().stream().forEach((uri) -> {
            answer.put(uri, manager.getCookieStore().get(uri));
        });
        return answer;
    }

    public void setStoredCookies(Map<URI, List<HttpCookie>> cookies) {
        cookies.keySet().forEach((uri) -> {
            cookies.get(uri).forEach(((cook) -> {
                manager.getCookieStore().add(uri, cook);
            }));
        });
    }

}
