package com.arcane.arithmetic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignInController {

	public Stage stage;
	public Scene scene;
	public Parent root;
	@FXML
	private BorderPane pane;
	@FXML
	private javafx.scene.control.Button backButton, loginButton;

	public void switchToSignUpScene(ActionEvent event) throws IOException {
		StartController SUCon = new StartController();
		SUCon.switchToSignUpScene(event);
	}

    public void switchToTopic(ActionEvent event) throws IOException {
    	StartController SCCon = new StartController();
		SCCon.switchToTopicScene(event);
	}
    public void back(ActionEvent event) throws IOException {
		StartController SCCon = new StartController();
		SCCon.switchToStartMenu(event);
    }
}