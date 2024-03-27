package com.arcane.arithmetic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsController {
    private static Stage window = new Stage();
    private Scene scene;
    private static boolean isCreated = false;
    private static Stage startMenuStage;
    @FXML private AnchorPane pane;
    @FXML private Label optionsLabel, soundEffectsLabel, musicLabel, fullScreenLabel;
    @FXML private Button backButton;
    @FXML private CheckBox soundCheckBox, musicCheckBox, fullScreenCheckBox;

    private String css = this.getClass().getResource("css/settings.css").toExternalForm();

    public void startSettings(ActionEvent event, Stage startMenuStage) throws IOException {
        if (!isCreated) {
            isCreated = true;
            storeStartMenuStage(startMenuStage);
            window.initModality(Modality.APPLICATION_MODAL);
            window.resizableProperty().setValue(Boolean.FALSE);
            pane = (AnchorPane) FXMLLoader.load(getClass().getResource("view/Settings.fxml"));
            scene = new Scene(pane);
            scene.getStylesheets().add(css);
            window.setScene(scene);
            window.showAndWait();
        }
        else {
            window.showAndWait();
        }
    }

    public void soundCheckBoxClick(ActionEvent event){
        if (soundCheckBox.isSelected()){

        }
        else {

        }
    }

    public void musicCheckBoxClick(ActionEvent event) {
        if (musicCheckBox.isSelected()){

        }
        else {

        }
    }

    public void fullScreenCheckBoxClick(ActionEvent event) throws IOException {
        if (fullScreenCheckBox.isSelected()){

        }
        else {

        }
    }

    public void back(ActionEvent event) {
        window.close();
    }

    public static void storeStartMenuStage(Stage startMenuStage){
        SettingsController.startMenuStage = startMenuStage;
    }
}
