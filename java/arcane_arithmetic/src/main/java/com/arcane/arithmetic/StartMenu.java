package com.arcane.arithmetic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartMenu extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartMenu.class.getResource("view/StartMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Arcane Arithmetic");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        SettingsController.settingsCon.initSettings(stage);
        CheatsModePasswordPromptController.cheatsCon.initCheats();
    }

    public static void main(String[] args) {
        launch();
    }
}