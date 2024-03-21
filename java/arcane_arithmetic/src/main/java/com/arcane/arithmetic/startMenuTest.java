package com.arcane.arithmetic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

<<<<<<<< Updated upstream:java/arcane_arithmetic/src/main/java/com/arcane/arithmetic/StartMenu.java
public class StartMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartMenu.class.getResource("view/StartMenu.fxml"));
========
public class startMenuTest extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(startMenuTest.class.getResource("view/StartMenu.fxml"));
>>>>>>>> Stashed changes:java/arcane_arithmetic/src/main/java/com/arcane/arithmetic/startMenuTest.java
        Scene scene = new Scene(fxmlLoader.load());
        String css = this.getClass().getResource("view/StartMenu.css").toExternalForm();
        stage.setTitle("Arcane Arithmetic");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}