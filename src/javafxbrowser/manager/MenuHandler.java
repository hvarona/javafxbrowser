package javafxbrowser.manager;

import com.sun.webkit.dom.HTMLAnchorElementImpl;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
        ContextMenu menu = new ContextMenu();
        MenuItem reloadOption = new MenuItem("Reload Page");
        reloadOption.setOnAction((ActionEvent evt) -> {
            browser.reloadPage();
        });
        menu.getItems().add(reloadOption);

        if (element instanceof HTMLAnchorElementImpl) {
            MenuItem openOption = new MenuItem("Open Link");
            openOption.setOnAction((ActionEvent evt) -> {
                browser.loadPage(((HTMLAnchorElementImpl) element).getHref());
            });
            MenuItem openTabOption = new MenuItem("Open Link in new Tab");
            openTabOption.setOnAction((ActionEvent evt) -> {
                parent.addTab(((HTMLAnchorElementImpl) element).getHref());

            });
            MenuItem saveOption = new MenuItem("Save Link as...");

            saveOption.setOnAction((ActionEvent evt) -> {
            });
            menu.getItems().add(openOption);
            menu.getItems().add(openTabOption);
            menu.getItems().add(saveOption);
        }

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

        CheckMenuItem viewNavigationOption = new CheckMenuItem("NavigationBar");
        viewNavigationOption.setSelected(true);
        viewNavigationOption.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            browser.hideShowNavigationBar(new_val);
        });

        menuView.getItems().add(viewNavigationOption);

        return menuBar;
    }

}