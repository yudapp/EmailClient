package com.mainemail.controller;

import com.mainemail.EmailManager;
import com.mainemail.controller.services.LoginService;
import com.mainemail.model.EmailAccount;
import com.mainemail.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;

public class LoginWindowController extends BaseController {

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    private TextField emailAddressField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    void loginButtonAction() {
        System.out.println("Login BUTON CLICKED");
        //check first if email and password fields are not empty
        if(fieldsAreValid()) {
            EmailAccount emailAccount = new EmailAccount(emailAddressField.getText(), passwordField.getText());
            LoginService loginService = new LoginService(emailAccount, emailManager);
            EmailLoginResult emailLoginResult = loginService.login();
            switch(emailLoginResult){
                case SUCCESS:
                    System.out.println("Login success "+ emailAccount);
                    return;
            }
//            System.out.println("login");
//            viewFactory.showMainWindow();
//
//            //get the window of the login stage and call the close method on it.
//            Stage stage = (Stage) errorLabel.getScene().getWindow();
//            viewFactory.closeStage(stage);
        }
    }

    private boolean fieldsAreValid() {
         if(emailAddressField.getText().isEmpty()){
            errorLabel.setText("Please fill email");
            return false;
        }
        if(passwordField.getText().isEmpty()){
            errorLabel.setText("Please fill password");
            return false;
        }
        return true;
    }

}

