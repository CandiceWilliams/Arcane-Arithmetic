package com.arcane.arithmetic;

//import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

public class StartController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML private Button startButton, settingButton;
	
	TutorialController tutcon = new TutorialController();
	SettingsController settingsCon = new SettingsController();
	SignInController SIcon = new SignInController();
	ExitController Exitcon = new ExitController();
	
	public void openTutorial(ActionEvent event) throws IOException {
		tutcon.startTutorial(event);

	}

	public void openSettings(ActionEvent event) throws IOException {
		Stage thisStage = (Stage)settingButton.getScene().getWindow();
		settingsCon.startSettings(event, thisStage);

	}

	public void openSignIn(ActionEvent event) throws IOException {
		Stage thisStage = (Stage)startButton.getScene().getWindow();
		SIcon.popUpSignInScene(event, thisStage);
	}
	public void openExit(ActionEvent event) throws IOException {
		Stage thisStage = (Stage) startButton.getScene().getWindow();
		Exitcon.popUpExitScene(event, thisStage);
	}

	public void switchToStartMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/StartMenu.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}
	
	public void switchToTopicScene(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("view/ChooseTopic.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}
	
	public void switchToLeaderboard(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/Leaderboard.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}

	public void switchToDifficulty(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/ChooseDifficulty.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}