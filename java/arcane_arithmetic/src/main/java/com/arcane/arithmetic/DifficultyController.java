package com.arcane.arithmetic;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the Difficulty Controller, used for controls and events in the ChooseDifficulty scene.
 * 
 * @author Ming Chun Chan
 * @author Justin Xu
 * @author Candice Williams
 */
public class DifficultyController {
	private static String diff;

	
	/**
	 * Switch back to the previous scene, ChooseTopic scene
	 * @param event the back button is pressed
	 * @throws IOException if error initialising Stage variable
	 */
	public void switchToTopic(ActionEvent event) throws IOException {
		StartController SCCon = new StartController();
		SCCon.switchToTopicScene(event);
	}

	/**
	 * Save easy as the difficulty
	 * Start the game
	 * @param event the easy button is pressed
	 * @throws IOException if error initialising Stage variable
	 */
	public void easy(ActionEvent event) throws IOException {
		diff = "easy";
		startGame(event);

	}
	/**
	 * Save medium as the difficulty
	 * Start the game
	 * @param event the medium button is pressed
	 * @throws IOException if error initialising Stage variable
	 */
	public void medium(ActionEvent event) throws IOException {
		diff = "medium";
		startGame(event);
	}	
	/**
	 * Save hard as the difficulty
	 * Start the game
	 * @param event the hard button is pressed
	 * @throws IOException if error initialising Stage variable
	 */
	public void hard(ActionEvent event) throws IOException {
		diff = "difficult";
		startGame(event);
	}	
	/**
	 * @return the difficulty of the game
	 */
	public String getDiff() {
		return diff;
	}
	
	/**
	 * Start the game
	 * @param event any of the three difficulty buttons is pressed
	 * @throws IOException if error initialising Stage variable
	 */
	public void startGame(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
		GameLoop game = new GameLoop();
		game.StartGameLoop(event);
	}
}