package com.arcane.arithmetic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SignInController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	public Label signInLabel;
	public Label usernameLabel;
	public Label passwordLabel;
	public Label dontHaveAccountLabel;
	public Button loginButton;
	
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
	
	public void signInButtonClick(ActionEvent event) throws IOException {
		
	}
}
