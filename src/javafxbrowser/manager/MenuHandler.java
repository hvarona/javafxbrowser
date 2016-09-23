package javafxbrowser.manager;

import com.sun.webkit.dom.HTMLAnchorElementImpl;
import com.sun.webkit.dom.HTMLImageElementImpl;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafxbrowser.JavaFxBrowser;
import javafxbrowser.frame.BrowserFXFrame;
import netscape.javascript.JSObject;

/**
 *
 * @author henry
 */
public class MenuHandler {

    JavaFxBrowser parent;
    BrowserFXFrame browser;

    public MenuHandler(JavaFxBrowser parent, BrowserFXFrame browser) {
        this.parent = parent;
        this.browser = browser;
    }

    public ContextMenu getContextMenu(JSObject element) {
        System.out.println("Class " + element.getClass());
        ContextMenu menu = new ContextMenu();
        MenuItem reloadOption = new MenuItem("Reload Page");
        reloadOption.setOnAction((ActionEvent evt) -> {
            browser.reloadPage();
        });
        menu.getItems().add(reloadOption);

        if (element instanceof HTMLAnchorElementImpl) {
            String href = ((HTMLAnchorElementImpl) element).getHref();
            MenuItem openOption = new MenuItem("Open Link");
            openOption.setOnAction((ActionEvent evt) -> {
                browser.loadPage(href);
            });
            MenuItem openTabOption = new MenuItem("Open Link in new Tab");
            openTabOption.setOnAction((ActionEvent evt) -> {
                parent.addTab(href);

            });
            MenuItem saveOption = new MenuItem("Save Link as...");

            saveOption.setOnAction((ActionEvent evt) -> {
            });
            menu.getItems().addAll(new SeparatorMenuItem(), openOption, openTabOption, saveOption);
        } else if (element instanceof HTMLImageElementImpl) {
            HTMLImageElementImpl div = (HTMLImageElementImpl) element;
            MenuItem saveOption = new MenuItem("Save Image as...");

            saveOption.setOnAction((ActionEvent evt) -> {
            });
            menu.getItems().addAll(new SeparatorMenuItem(), saveOption);
        }
        MenuItem settingOption = new MenuItem("Open Setting Tab");

        settingOption.setOnAction((ActionEvent evt) -> {
            parent.addSettingTab();
        });
        menu.getItems().addAll(new SeparatorMenuItem(), settingOption);

        return menu;
    }

    public MenuBar getMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.setId("menuBar");
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);

        MenuItem newTabOption = new MenuItem("New Tab");
        menuFile.getItems().add(newTabOption);
        newTabOption.setOnAction((ActionEvent evt) -> {
            parent.addTab();
        });

        MenuItem saveOption = new MenuItem("Save Page");
        menuFile.getItems().add(saveOption);
        saveOption.setOnAction((ActionEvent evt) -> {
            browser.savePage();
        });
        MenuItem printOption = new MenuItem("Print page");
        menuFile.getItems().add(printOption);
        printOption.setOnAction((ActionEvent evt) -> {
            browser.printPage();
        });

        MenuItem closeOption = new MenuItem("Exit");
        menuFile.getItems().add(closeOption);
        closeOption.setOnAction((ActionEvent evt) -> {
            System.exit(0);
        });
        MenuItem searchOption = new MenuItem("Search");
        menuEdit.getItems().add(searchOption);
        searchOption.setOnAction((ActionEvent evt) -> {
            browser.createSearchWindow();
        });

        CheckMenuItem viewNavigationOption = new CheckMenuItem("Navigation Bar");
        viewNavigationOption.setSelected(parent.getConfig().isShowNavigationBar());
        viewNavigationOption.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            parent.showHideNavigationBars(new_val);
        });

        CheckMenuItem showHistory = new CheckMenuItem("History");
        showHistory.setSelected(false);
        showHistory.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            if (new_val) {
                browser.showHistoryWindow();
            } else {
                browser.hideHistoryWindw();
            }
        }
        );

        MenuItem settingOption = new MenuItem("Settings");
        settingOption.setOnAction((ActionEvent evt) -> {
            parent.addSettingTab();
        });

        menuView.getItems().addAll(viewNavigationOption, showHistory, settingOption);

        return menuBar;
    }

}
