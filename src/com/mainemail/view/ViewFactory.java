package com.mainemail.view;

import com.mainemail.EmailManager;
import com.mainemail.controller.BaseController;
import com.mainemail.controller.LoginWindowController;
import com.mainemail.controller.MainWindowController;
import com.mainemail.controller.OptionsWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private EmailManager emailManager;
    private ArrayList<Stage> activeStages;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
        activeStages = new ArrayList<Stage>();
    }

    //Handle different themes and views
    private ColorTheme colorTheme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public void showLoginWindow() {
        System.out.println("log window factory");
        BaseController controller = new LoginWindowController(emailManager, this, "LoginWindow.fxml");
        initialiseStage(controller);

    }

    public void showMainWindow() {
        System.out.println("main window factory");
        BaseController controller = new MainWindowController(emailManager, this, "MainWindow.fxml");
        initialiseStage(controller);
    }

    public void showOptionsWindow() {
        System.out.println("options window factory");
        BaseController controller = new OptionsWindowController(emailManager, this, "OptionsWindow.fxml");
        initialiseStage(controller);

    }

    private void initialiseStage(BaseController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activeStages.add(stage);
    }

    public void closeStage(Stage stageToClose) {
        stageToClose.close();
        activeStages.remove(stageToClose);
    }


    public void updateStyles() {
        for(Stage stage: activeStages){
            Scene scene = stage.getScene();
            //handle css here
            scene.getStylesheets().clear(); //clear style first before applying new ones
            scene.getStylesheets().add(getClass().getResource(ColorTheme.getCssPath(colorTheme)).toExternalForm());
            scene.getStylesheets().add(getClass().getResource(FontSize.getCssPath(fontSize)).toExternalForm());

        }

    }
}
