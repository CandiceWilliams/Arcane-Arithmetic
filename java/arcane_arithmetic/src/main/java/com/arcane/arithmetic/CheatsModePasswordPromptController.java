package com.arcane.arithmetic;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class CheatsModePasswordPromptController {

    public static CheatsModePasswordPromptController cheatsCon = new CheatsModePasswordPromptController();
    private static Stage window = new Stage();
    private Scene scene;
    @FXML private AnchorPane pane;
    @FXML private TextField authenticationKeyTextField;
    @FXML private Label invalidPasswordLabel, validPasswordLabel, deactivateCheatsLabel, cheatsOnStatusLabel, cheatsOffStatusLabel;
    private static final String authenticationPassword = "hamburger123";
    private static boolean cheatsOn = false;

    public void initCheats() throws IOException {
        window.initModality(Modality.APPLICATION_MODAL);
        window.resizableProperty().setValue(Boolean.FALSE);
        pane = (AnchorPane) FXMLLoader.load(getClass().getResource("view/CheatsModePasswordPrompt.fxml"));
        scene = new Scene(pane);
        window.setScene(scene);
    }
    public void popUpWindow() throws IOException {
        window.show();
    }

    public void backToOptionsClick(ActionEvent event) {
        SettingsController.settingsCon.loadSound();
        window.close();
        SettingsController settingsCon = new SettingsController();
        settingsCon.startSettings(event);
    }

    public void checkPassword(){
        String txt = authenticationKeyTextField.getText();
        if (txt.equals(authenticationPassword)){
            invalidPasswordLabel.setVisible(false);
            validPasswordLabel.setVisible(true);
            PauseTransition visiblePause = new PauseTransition(Duration.seconds(1));
            visiblePause.setOnFinished(event -> validPasswordLabel.setVisible(false));
            visiblePause.play();
            cheatsOn = true;
        }
        else {
            validPasswordLabel.setVisible(false);
            invalidPasswordLabel.setVisible(true);
            PauseTransition visiblePause = new PauseTransition(Duration.seconds(1));
            visiblePause.setOnFinished(event -> invalidPasswordLabel.setVisible(false));
            visiblePause.play();
        }
        displayCheatsStatus();
    }

    public void deactivateCheatsButtonClick(){
        cheatsOn = false;
        displayCheatsStatus();
        deactivateCheatsLabel.setVisible(true);
        PauseTransition visiblePause = new PauseTransition(Duration.seconds(1));
        visiblePause.setOnFinished(event -> deactivateCheatsLabel.setVisible(false));
        visiblePause.play();
    }

    private void displayCheatsStatus(){
        if (cheatsOn) {
            cheatsOffStatusLabel.setVisible(false);
            cheatsOnStatusLabel.setVisible(true);
        }
        else {
            cheatsOnStatusLabel.setVisible(false);
            cheatsOffStatusLabel.setVisible(true);
        }
    }
}
