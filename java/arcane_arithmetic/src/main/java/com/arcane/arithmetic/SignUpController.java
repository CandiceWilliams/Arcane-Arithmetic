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
	
	public Label signUpLabel;
	public Label usernameLabel;
	public Label passwordLabel;
	public Label passwordConfirmationLabel;
	public Button signUpButton, backToSignInScreenButton;
	
	public void switchToSignInScene(ActionEvent event) throws IOException {
		SignInAndSignUpScreens tmp = new SignInAndSignUpScreens();
		tmp.switchToSignInScene(event);
	}
	
	public void signUpButtonClick(ActionEvent event) throws IOException {
		
	}
}
