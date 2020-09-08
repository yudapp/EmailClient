package com.mainemail.controller;

import com.mainemail.EmailManager;
import com.mainemail.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

public class MainWindowController extends BaseController {

    public MainWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    private TreeView<?> emailTreeView;

    @FXML
    private TableView<?> emailTableView;

    @FXML
    private WebView emailWebView;

    @FXML
    void addAccountAction() {
        viewFactory.showLoginWindow();
    }


    @FXML
    void optionsAction() {
        viewFactory.showOptionsWindow();
    }

}
