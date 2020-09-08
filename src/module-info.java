module EmailClientJJavaFX {

    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;

    opens com.mainemail;
    opens com.mainemail.view;
    opens com.mainemail.controller;

}