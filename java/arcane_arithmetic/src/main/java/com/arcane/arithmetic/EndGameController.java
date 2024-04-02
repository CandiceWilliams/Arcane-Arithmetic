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
	private static String currentPlayerUserID = "";
	@FXML private Label pointsWon, rightAnswers, overallScore;
	@FXML private Button nextButton;
	
	public void initialize(ActionEvent event) throws IOException {
		pointsWon.setText("");
		rightAnswers.setText("");
		overallScore.setText("");
	}

	public void displayEndGameScreen(GameLoop game){
		pointsWon.setText(String.valueOf(game.getTotalPts()));
		rightAnswers.setText(game.getCorrectAnswers() + "/20");
		overallScore.setText(String.valueOf(game.getTotalPts()));

		// fetching old user record in API
		UserRecord oldRecord = UserRecord.fetchUserRecordHelper(currentPlayerUserID);
		String userID = oldRecord.getUserID();
		String username = oldRecord.getUsername();
		int totalPoints = oldRecord.getTotalPoints();
		int totalPass = oldRecord.getTotalGamesWon();
		int totalGamesPlayed = oldRecord.getTotalGamesPlayed();
		int totalCorrect = game.getCorrectAnswers();
		int totalIncorrect = 20 - game.getCorrectAnswers();
//		System.out.println(userID + " " + username + " " + totalPoints + " " + totalPass + " " + totalGamesPlayed + " " + totalCorrect + " " + totalIncorrect);
//		System.out.println(game.getTotalPts() + " " + game.getCorrectAnswers());

		// creating new user record for this specific user in API
		totalPoints += game.getTotalPts();
		totalPass += game.getCorrectAnswers() >= 10 ? 1 : 0;
		totalGamesPlayed++;
		totalCorrect += game.getCorrectAnswers();
		totalIncorrect += 20 - game.getCorrectAnswers();
//		System.out.println(userID + " " + username + " " + totalPoints + " " + totalPass + " " + totalGamesPlayed + " " + totalCorrect + " " + totalIncorrect);
		UserRecord newRecord = new UserRecord(userID, username, totalPoints, totalPass, totalGamesPlayed, totalCorrect, totalIncorrect);

		// updating user record in API
		UserRecord.updateUserRecordInAPI(userID, newRecord);
	}
	
	public void next(ActionEvent event) throws IOException {
		Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		thisStage.close();
	}

	public static void setCurrentPlayerUserID(String userID){
		currentPlayerUserID = userID;
	}
}