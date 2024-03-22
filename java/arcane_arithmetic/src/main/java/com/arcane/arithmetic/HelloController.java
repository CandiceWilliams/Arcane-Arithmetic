package com.arcane.arithmetic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;
import com.arcane.arithmetic.TutorialController;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button tutButton;
    private Parent root;
    private Stage stage;
    private Scene scene;
    TutorialController tutcon = new TutorialController();


    public void switchToTutorial(ActionEvent event) throws IOException {
        tutcon.switchToPage1(event);
    }
}