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
	public void easy(ActionEvent event) throws IOException {
		diff = "easy";
		StartController SCCon = new StartController();
		SCCon.switchToTopicScene(event);
	}	
	public void medium(ActionEvent event) throws IOException {
		diff = "medium";
		StartController SCCon = new StartController();
		SCCon.switchToTopicScene(event);
	}	
	public void hard(ActionEvent event) throws IOException {
		diff = "hard";
		StartController SCCon = new StartController();
		SCCon.switchToTopicScene(event);
	}	
	public String getDiff() {
		return diff;
	}
	public void startGame(ActionEvent event) throws IOException {
		
	}
}