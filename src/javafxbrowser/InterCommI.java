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

    /**
     * Example only for test
     * @param s
     * @param __current 
     */
    @Override
    public void printString(String s, Current __current) {
        System.out.println(s);
    }

    @Override
    public BrowserConfigurator getConfig(Current __current) {
        return configurator;
    }

    @Override
    public void setConfig(BrowserConfigurator conf, Current __current) {
        this.configurator = conf;
    }

}
