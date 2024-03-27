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
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToTopic(ActionEvent event) throws IOException {
		StartController SCCon = new StartController();
		SCCon.switchToTopicScene(event);
	}	
}