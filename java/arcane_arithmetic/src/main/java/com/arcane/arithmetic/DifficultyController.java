package com.arcane.arithmetic;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DifficultyController {
	private static String diff;

	public void switchToTopic(ActionEvent event) throws IOException {
		StartController SCCon = new StartController();
		SCCon.switchToTopicScene(event);
	}

	public void easy(ActionEvent event) throws IOException {
		diff = "easy";
		startGame(event);

	}	
	public void medium(ActionEvent event) throws IOException {
		diff = "medium";
		startGame(event);
	}	
	public void hard(ActionEvent event) throws IOException {
		diff = "hard";
		startGame(event);
	}	
	public String getDiff() {
		return diff;
	}
	public void startGame(ActionEvent event) throws IOException {
		GameLoop game = new GameLoop();
		game.StartGameLoop(event);
	}
}