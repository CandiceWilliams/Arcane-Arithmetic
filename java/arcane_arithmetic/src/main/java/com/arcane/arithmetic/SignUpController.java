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

public class SignUpController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	public Label signUpLabel;
	public Label usernameLabel;
	public Label passwordLabel;
	public Label passwordConfirmationLabel;
	public Button signUpButton, backToSignInScreenButton;
	
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
	
	public void signUpButtonClick(ActionEvent event) throws IOException {
		
	}
}
