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
        String css = this.getClass().getResource("css/StartMenu.css").toExternalForm();
        String buttonCss = this.getClass().getResource("css/iconButton.css").toExternalForm();
        
        stage.setTitle("Arcane Arithmetic");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}