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

/**
 * This is the Cheat Mode Password Prompt Controller, used for controls and events in the cheat mode passwrod prompt.
 * 
 * @author Justin Xu
 *
 */
public class CheatsModePasswordPromptController {

    public static CheatsModePasswordPromptController cheatsCon = new CheatsModePasswordPromptController();
    private static Stage window = new Stage();
    private Scene scene;
    @FXML private AnchorPane pane;
    @FXML private TextField authenticationKeyTextField;
    @FXML private Label invalidPasswordLabel, validPasswordLabel, deactivateCheatsLabel, cheatsOnStatusLabel, cheatsOffStatusLabel;
    private static final String authenticationPassword = "hamburger123";
    private static boolean cheatsOn = false;

    /**
     * Initialize Cheat Mode Password Prompt
     * @throws IOException if error initialising Stage variable
     */
    public void initCheats() throws IOException {
        window.initModality(Modality.APPLICATION_MODAL);
        window.resizableProperty().setValue(Boolean.FALSE);
        pane = (AnchorPane) FXMLLoader.load(getClass().getResource("view/CheatsModePasswordPrompt.fxml"));
        scene = new Scene(pane);
        window.setScene(scene);
    }
    /**
     * Show Cheat Mode Password Prompt pop up
     * @throws IOException if error initialising Stage variable
     */
    public void popUpWindow() throws IOException {
        window.show();
    }

    /**
     * Switch back to the settings menu
     * @param event back button is pressed
     */
    public void backToOptionsClick(ActionEvent event) {
        SettingsController.settingsCon.loadSound();
        window.close();
        SettingsController settingsCon = new SettingsController();
        settingsCon.startSettings(event);
    }

    /**
     * Check for the authentication password
     */
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

    /**
     * Deactivate cheats
     */
    public void deactivateCheatsButtonClick(){
        cheatsOn = false;
        displayCheatsStatus();
        deactivateCheatsLabel.setVisible(true);
        PauseTransition visiblePause = new PauseTransition(Duration.seconds(1));
        visiblePause.setOnFinished(event -> deactivateCheatsLabel.setVisible(false));
        visiblePause.play();
    }

    /**
     * Display cheats status
     */
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

    /**
     * @return cheatsON
     */
    public static boolean isCheatsOn(){
        return cheatsOn;
    }

}
