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
	private String diff;

	public void switchToTopic(ActionEvent event) throws IOException {
		StartController SCCon = new StartController();
		SCCon.switchToTopicScene(event);
	}

	public void easy(ActionEvent event) throws IOException {
		diff = "easy";

	}	
	public void medium(ActionEvent event) throws IOException {
		diff = "medium";

	}	
	public void hard(ActionEvent event) throws IOException {
		diff = "hard";

	}	
	public String getDiff() {
		return diff;
	}
	public void startGame(ActionEvent event) throws IOException {
		
	}
}