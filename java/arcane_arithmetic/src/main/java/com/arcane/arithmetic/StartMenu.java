package com.arcane.arithmetic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class StartMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(StartMenu.class.getResource("view/StartMenu.fxml"));
        Scene scene = new Scene(root);
        String css = this.getClass().getResource("css/StartMenu.css").toExternalForm();
        String buttonCss = this.getClass().getResource("css/iconButton.css").toExternalForm();

        scene.getStylesheets().add(css);
        scene.getStylesheets().add(buttonCss);
        stage.setTitle("Arcane Arithmetic");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}