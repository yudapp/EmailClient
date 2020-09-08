module EmailClientJJavaFX {

    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires activation;
    requires java.mail;

    opens com.mainemail;
    opens com.mainemail.view;
    opens com.mainemail.controller;

}