package com.arcane.arithmetic;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class SignInAndSignUpScreens extends Application {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
			Scene scene = new Scene(root);
			String css = this.getClass().getResource("SignIn.css").toExternalForm();
			scene.getStylesheets().add(css);
			stage.setScene(scene);
			stage.setTitle("Sign In");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void switchToSignInScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("SignIn.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.setTitle("Sign In");
		stage.show();
	}
	
	public void switchToSignUpScene(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("SignUp.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.setTitle("Sign Up");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
