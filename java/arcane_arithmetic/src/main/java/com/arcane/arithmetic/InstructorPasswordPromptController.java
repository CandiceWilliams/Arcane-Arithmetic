package com.arcane.arithmetic;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class InstructorPasswordPromptController {

    private Stage stage;
    private Scene scene;
    private static Stage startMenuStage;
    @FXML private AnchorPane pane;

    @FXML private Button backToOptionsButton, nextButton;
    @FXML private TextField authenticationKeyTextField;
    @FXML private Label invalidPasswordLabel;
    private static final String authenticationPassword = "xyz369";

    public void popUpWindow(Stage startMenuStage) throws IOException {
        storeStartMenuStage(startMenuStage);
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.resizableProperty().setValue(Boolean.FALSE);
        pane = (AnchorPane) FXMLLoader.load(getClass().getResource("view/InstructorPasswordPrompt.fxml"));
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

    public void switchToInstructorDashboard() throws IOException {
        String txt = authenticationKeyTextField.getText();
        if (txt.equals(authenticationPassword)) {
            SettingsController.settingsCon.loadSound();
            Stage stage = (Stage) nextButton.getScene().getWindow();
            stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("view/InstructorDashboard.fxml"));
            scene = new Scene(root);
            startMenuStage.setScene(scene);
            SettingsController.settingsCon.loadFullScreen();
        }
        else {
            invalidPasswordLabel.setVisible(true);
            PauseTransition visiblePause = new PauseTransition(Duration.seconds(1));
            visiblePause.setOnFinished(event -> invalidPasswordLabel.setVisible(false));
            visiblePause.play();
        }
    }

    public static void storeStartMenuStage(Stage startMenuStage){
        InstructorPasswordPromptController.startMenuStage = startMenuStage;
    }
}
