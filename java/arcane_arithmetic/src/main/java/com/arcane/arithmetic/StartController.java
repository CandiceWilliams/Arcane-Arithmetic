package com.arcane.arithmetic;

//import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	TutorialController tutcon = new TutorialController();


	public void openTutorial(ActionEvent event) throws IOException {
		tutcon.switchToQuestionTypeMC(event);

	}

	public void switchToTopic(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/ChooseTopic.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchToLeaderboard(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/Leaderboard.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}