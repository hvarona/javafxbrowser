package javafxbrowser.manager;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 *
 * @author hvarona
 */
public class CacheHandler extends URLStreamHandler implements URLStreamHandlerFactory {

    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
        System.out.println("protocol " + protocol);
        if ("http".equals(protocol)) {
            return this;
        }
        //Only caching the http protocol
        return null;
    }

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        System.out.println(u.toString());
        return new HttpURLConnection(u, Proxy.NO_PROXY);
    }

}
