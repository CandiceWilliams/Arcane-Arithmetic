package com.arcane.arithmetic;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This is the Start Controller, used for controls and events for the start menu, including other common functions.
 *
 * @author Candice Williams
 * @author Ming Chun Chan
 * @author Justin Xu
 *
 */
public class StartController {
	private Stage stage;
	private Scene scene;
	@FXML private Button startButton, settingButton;
	private String difficulty, topic;
	
	TutorialController tutcon = new TutorialController();
	SignInController SIcon = new SignInController();
	ExitController Exitcon = new ExitController();
	
	/**
	 * Open the tutorial pop up
	 * @param event the tutorial button is pressed
	 * @throws IOException
	 */
	public void openTutorial(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
		tutcon.startTutorial(event);

	}

	/**
	 * Open the settings menu
	 * @param event the settings button is pressed
	 */
	public void openSettings(ActionEvent event) {
		SettingsController.settingsCon.loadSound();
		SettingsController.settingsCon.startSettings(event);
	}

	/**
	 * Open the sign in pop up
	 * @param event start button is pressed
	 * @throws IOException if error initialising Stage variable
	 */
	public void openSignIn(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
		Stage thisStage = (Stage)startButton.getScene().getWindow();
		SIcon.popUpSignInScene(event, thisStage);
	}
	
	/**
	 * Open the exit pop up
	 * @param event exit button is pressed
	 * @throws IOException if error initialising Stage variable
	 */
	public void openExit(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
		Stage thisStage = (Stage) startButton.getScene().getWindow();
		Exitcon.popUpExitScene(event, thisStage);
	}

	/**
	 * Switch to start menu
	 * @param event any back to start menu button is pressed
	 * @throws IOException
	 */
	public void switchToStartMenu(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
		Parent root = FXMLLoader.load(getClass().getResource("view/StartMenu.fxml"));


		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		SettingsController.settingsCon.loadFullScreen();
	}
	
	/**
	 * Switch to choose topic scene
	 * @param event switch to topic button is pressed
	 * @throws IOException if error initialising Stage variable
	 */
	public void switchToTopicScene(ActionEvent event) throws IOException{
		SettingsController.settingsCon.loadSound();
		Parent root = FXMLLoader.load(getClass().getResource("view/ChooseTopic.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		SettingsController.settingsCon.loadFullScreen();
	}
	
	/**
	 * Switch to the leaderboard scene
	 * @param event leaderboard button is pressed
	 * @throws IOException if error initialising Stage variable
	 */
	public void switchToLeaderboard(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
		Parent root = FXMLLoader.load(getClass().getResource("view/Leaderboard.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		SettingsController.settingsCon.loadFullScreen();
	}

	/**
	 * Switch to the choose difficulty scene
	 * @param event switch to difficulty button is pressed
	 * @throws IOException if error initialising Stage variable
	 */
	public void switchToDifficulty(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
		Parent root = FXMLLoader.load(getClass().getResource("view/ChooseDifficulty.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		SettingsController.settingsCon.loadFullScreen();
	}
}