package com.arcane.arithmetic;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TopicController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void switchToDifficulty(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/ChooseDifficulty.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToStart(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/StartMenu.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}