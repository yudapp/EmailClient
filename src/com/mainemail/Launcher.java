package com.mainemail;

import com.mainemail.view.ViewFactory;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Launcher  extends Application {

    public static void main(String [] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
//        Button button = new Button("Click");
//        button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("clicked+++");
//            }
//        });
//
//        StackPane stackPane = new StackPane();
//        stackPane.getChildren().add(button);

//        Parent parent = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));
//        Scene scene = new Scene(parent);
//        stage.setScene(scene);
//        stage.show();

        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.showOptionsWindow();
        viewFactory.updateStyles();
        //viewFactory.showLoginWindow();
    }
}
