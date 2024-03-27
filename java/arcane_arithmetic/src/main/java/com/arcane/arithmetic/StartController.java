package com.arcane.arithmetic;

//import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StartController {
	private Stage stage;
	private Scene scene;
	private Parent root;

	
	public void openTutorial(ActionEvent event) throws IOException {
		TutorialController tutcon = new TutorialController();
		tutcon.switchToPage1(event);

	}

	public void switchToSignInScene(ActionEvent event) throws IOException {
		SignInController SUCon = new SignInController();
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		SUCon.popUpSignInScene(event, stage);

	}

	public void switchToStartMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/StartMenu.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToTopicScene(ActionEvent event) throws IOException{
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

	public void switchToDifficulty(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/ChooseDifficulty.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}