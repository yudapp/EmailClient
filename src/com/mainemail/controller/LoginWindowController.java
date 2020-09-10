package com.mainemail.controller;

import com.mainemail.EmailManager;
import com.mainemail.controller.services.LoginService;
import com.mainemail.model.EmailAccount;
import com.mainemail.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    private TextField emailAddressField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    /**
     * Uses LoginService.java to check credentials -> It implements the service class for background thread
     */
    @FXML
    void loginButtonAction() {
        System.out.println("Login BUTTON CLICKED");
        //check first if email and password fields are not empty
        if(fieldsAreValid()) {
            EmailAccount emailAccount = new EmailAccount(emailAddressField.getText(), passwordField.getText());
            //use a different thread to login
            LoginService loginService = new LoginService(emailAccount, emailManager);
            loginService.start();
            loginService.setOnSucceeded(workerStateEvent -> {
                EmailLoginResult emailLoginResult = loginService.getValue();
                switch(emailLoginResult){
                    case SUCCESS:
                        System.out.println("Login success "+ emailAccount);
                        viewFactory.showMainWindow();
                        //get the window of the login stage and call the close method on it.
                        Stage stage = (Stage) errorLabel.getScene().getWindow();
                        viewFactory.closeStage(stage);
                        break;
                    case FAILED_BY_CREDENTIALS:
                        errorLabel.setText("Invalid Credentials");
                        return;
                    case FAILED_BY_UNEXPECTED_ERROR:
                        errorLabel.setText("Unexpected error..");
                }
            });



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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

