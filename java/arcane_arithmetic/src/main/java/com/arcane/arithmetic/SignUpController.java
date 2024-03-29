package com.arcane.arithmetic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SignUpController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	private static Stage startMenuStage;

	@FXML
    private javafx.scene.control.Button signUpButton;
	@FXML
	private Label existedUsername,usernameTooLong,pwSpecial,pwDiff;

    public void switchToSignInScene(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
        SignInController SICon = new SignInController();
        SICon.switchToSignInScene(event);
    }
    public void switchToTopic(ActionEvent event) throws IOException {
    	//if no error
    	SettingsController.settingsCon.loadSound();
		Stage stage = (Stage)signUpButton.getScene().getWindow();
		stage.close();
		Parent root = FXMLLoader.load(getClass().getResource("view/ChooseTopic.fxml"));
		scene = new Scene(root);
		startMenuStage.setScene(scene);
//		//username already exists
//		existedUsername.setVisible(true);
//		//username too long
//		usernameTooLong.setVisible(true);
//		//password has special characters
//		pwSpecial.setVisible(true);
//		//password and confirm password are different
//		pwDiff.setVisible(true);
	}

	public static void storeStartMenuStage(Stage startMenuStage){
		SignUpController.startMenuStage = startMenuStage;
	}
}