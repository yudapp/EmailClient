package com.mainemail.controller;

import com.mainemail.EmailManager;
import com.mainemail.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends BaseController {

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    private TextField emailAddressField;

    @FXML
    private PasswordField passwordFIeld;

    @FXML
    private Label errorLabel;

    @FXML
    void loginButtonAction() {
        System.out.println("login");
        viewFactory.showMainWindow();

        //get the window of the login stage and call the close method on it.
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

}

