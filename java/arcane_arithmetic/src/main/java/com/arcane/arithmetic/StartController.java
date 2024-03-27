package com.arcane.arithmetic;

//import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
		tutcon.switchToPage1(event);

	}

	public void switchToStartMenu(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/StartMenu.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}

	public void switchToSignInScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/SignIn.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		String SIcss = this.getClass().getResource("css/SignUp.css").toExternalForm();
		scene.getStylesheets().add(SIcss);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
    }

	public void switchToSignUpScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("view/SignUp.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String SUcss = this.getClass().getResource("css/SignUp.css").toExternalForm();
		scene.getStylesheets().add(SUcss);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}
	
	public void switchToTopicScene(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("view/ChooseTopic.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}
	
	public void switchToLeaderboard(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("view/Leaderboard.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.centerOnScreen();
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