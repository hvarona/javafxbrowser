/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxbrowser;

import Ice.Current;
import Ice.ObjectAdapter;
import javafxbrowser.cfg.BrowserConfigurator;
import javafxbrowser.rpc._InterCommDisp;
import javafxbrowser.rpc.config;
import javafxbrowser.rpc.configPrx;
import javafxbrowser.rpc.configPrxHelper;

/**
 *
 * @author henry
 */
public class InterCommI extends _InterCommDisp {

    BrowserConfigurator configurator = new BrowserConfigurator();
    ObjectAdapter adapter;

    public InterCommI(ObjectAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void printString(String s, Current __current) {
        System.out.println(s);
    }


    @Override
    public config getConfig(Current __current) {
        System.out.println("Se pidio la configuracion con homepage " + configurator.getHomepage());
        return configurator;
    }
    @Override
    public void setConfig(config conf, Current __current) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Se setea una configuracion");
        this.configurator.setHomepage(conf.homepage);
        this.configurator.setDefaultDownloadDirectory(conf.defaultDownloadDirectory);
    }

}
