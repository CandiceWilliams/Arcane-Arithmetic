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
//	GameLoop game = new GameLoop();
	
	public void initialize(ActionEvent event) throws IOException {
		pointsWon.setText("");
		rightAnswers.setText("");
		overallScore.setText("");
	}

	public void displayEndGameScreen(GameLoop game){
		pointsWon.setText(String.valueOf(game.getTotalPts()));
		rightAnswers.setText(game.getCorrectAnswers() + "/20");
		overallScore.setText(String.valueOf(game.getTotalPts()));
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