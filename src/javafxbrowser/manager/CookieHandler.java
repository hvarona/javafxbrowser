package javafxbrowser.manager;

import java.net.CookieManager;

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

}
