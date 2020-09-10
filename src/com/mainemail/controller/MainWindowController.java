package com.mainemail.controller;

import com.mainemail.EmailManager;
import com.mainemail.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    public MainWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    private TreeView<String> emailTreeView;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUpEmailsTreeView();
    }

    private void setUpEmailsTreeView() {
        emailTreeView.setRoot(emailManager.getFoldersRoot());
        //hide root as it is empty
        emailTreeView.setShowRoot(false);
    }
}
