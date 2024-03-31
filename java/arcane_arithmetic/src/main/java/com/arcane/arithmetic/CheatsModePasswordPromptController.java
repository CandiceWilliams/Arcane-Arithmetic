package com.arcane.arithmetic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class CheatsModePasswordPromptController {

    private Stage stage;
    private Scene scene;
    private static Stage startMenuStage;
    @FXML private AnchorPane pane;
    @FXML Button backToOptionsButton, nextButton;

    public void popUpWindow() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.resizableProperty().setValue(Boolean.FALSE);
        pane = (AnchorPane) FXMLLoader.load(getClass().getResource("view/CheatsModePasswordPrompt.fxml"));
        scene = new Scene(pane);
        window.setScene(scene);
        window.show();
    }

    public void backToOptionsClick(ActionEvent event) {
        SettingsController.settingsCon.loadSound();
        stage = (Stage)backToOptionsButton.getScene().getWindow();
        stage.close();
        SettingsController settingsCon = new SettingsController();
        settingsCon.startSettings(event);
    }

    public void checkPassword(ActionEvent event){

    }
}
