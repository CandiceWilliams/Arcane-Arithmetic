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
	
	public Label signInLabel;
	public Label usernameLabel;
	public Label passwordLabel;
	public Label dontHaveAccountLabel;
	public Button loginButton;
	
	public void switchToSignUpScene(ActionEvent event) throws IOException {
		SignInAndSignUpScreens tmp = new SignInAndSignUpScreens();
		tmp.switchToSignUpScene(event);
	}
	
	public void signInButtonClick(ActionEvent event) throws IOException {
		
	}
}
