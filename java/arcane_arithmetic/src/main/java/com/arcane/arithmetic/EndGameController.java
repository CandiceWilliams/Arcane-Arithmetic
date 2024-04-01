package com.arcane.arithmetic;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EndGameController {
	private Stage stage;
	private Scene scene;
	@FXML private Label pointsWon, rightAnswers, overallScore;
	@FXML private Button nextButton;
	
	public void initialize(ActionEvent event) throws IOException {
		pointsWon.setText("");
		rightAnswers.setText("");
		overallScore.setText("");
	}
	
	public void next(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/StartMenu.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		//save data on leaderboard
		
	}
}