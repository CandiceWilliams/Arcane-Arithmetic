package com.arcane.arithmetic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is the Sign In Controller, used for controls and events in the Sign-in pop up.
 * 
 * @author Justin Xu
 * @author Ming Chun Chan
 * 
 */
public class SignInController {	

	public Stage stage;
	public Scene scene;
	public Parent root;
	private static Stage startMenuStage;

	@FXML private BorderPane pane;
	@FXML private Button backButton, loginButton;
	@FXML private Label errorLabel;
	@FXML private TextField username,password;
	
	
	/**
	 * Initialize the sign-in pop up
	 * @param event the start button is pressed in the start menu
	 * @param startMenuStage the original start menu stage
	 * @throws IOException if error initialising Stage variable
	 */
	public void popUpSignInScene(ActionEvent event, Stage startMenuStage) throws IOException {
		storeStartMenuStage(startMenuStage); SignUpController.storeStartMenuStage(startMenuStage);
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		pane = (BorderPane) FXMLLoader.load(getClass().getResource("view/SignIn.fxml"));
		scene = new Scene(pane);
		String SIcss = this.getClass().getResource("css/signIn.css").toExternalForm();
		scene.getStylesheets().add(SIcss);
		window.setScene(scene);
		window.setResizable(false);
		window.showAndWait();
	}
	
	/** 
	 * Switch to sign-in scene
	 * @param event switch to sign-in button is pressed
	 * @throws IOException if error initialising Stage variable
	 */
	public void switchToSignInScene(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
		root = FXMLLoader.load(getClass().getResource("view/SignIn.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		String SIcss = this.getClass().getResource("css/signIn.css").toExternalForm();
		scene.getStylesheets().add(SIcss);
		stage.setScene(scene);
		stage.show();
	}
	/** 
	 * Switch to sign-up scene
	 * @param event switch to sign-up button is pressed
	 * @throws IOException if error initialising Stage variable
	 */
	public void switchToSignUpScene(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
		root = FXMLLoader.load(getClass().getResource("view/SignUp.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String SUcss = this.getClass().getResource("css/signUp.css").toExternalForm();
		scene.getStylesheets().add(SUcss);
		stage.setScene(scene);
		stage.show();
	}

	/** 
	 * Switch to ChooseTopic scene
	 * Check for sign-in data
	 * @param event sign-in button is pressed
	 * @throws IOException if error initialising Stage variable
	 */
    public void switchToTopic(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
		
		String urlString= "http://127.0.0.1:5000/database/users/get?username="+username.getText();
		
		URL url = new URL(urlString);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		String inputLine;
		StringBuilder content = new StringBuilder();
		
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		con.disconnect();
		if(content.toString().equals("{\"Error\": \"User Not Found\"}")) {
			errorLabel.setVisible(true);
		} else if(content.toString().equals("{\"Error\": \"No field specified\"}")) {
			errorLabel.setVisible(true);
		} else {
			JsonNode json =new ObjectMapper().readTree(content.toString());
			JsonNode tmpNode = json.get("password");
			if (tmpNode == null){
				errorLabel.setVisible(true);
				return;
			}
			String str = tmpNode.toString();
			str = str.substring(1, str.length() - 1);
			if((str.equals(password.getText()))) {
				Stage stage = (Stage)loginButton.getScene().getWindow();
				stage.close();
				Parent root = FXMLLoader.load(getClass().getResource("view/ChooseTopic.fxml"));
				scene = new Scene(root);
				startMenuStage.setScene(scene);
				SettingsController.settingsCon.loadFullScreen();
				errorLabel.setVisible(false);
				// updating the user id of the current player in EndGameController
				String tmpStr = json.get("id").toString();
				String userID = tmpStr.substring(1, tmpStr.length()-1);
				EndGameController.setCurrentPlayerUserID(userID);
			} else {
				errorLabel.setVisible(true);
			}
		}
	}

    /**
     * Close the sign-in pop up
     * @param event back button is pressed
     * @throws IOException if error initialising Stage variable
     */
    public void back(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
		Stage stage = (Stage)backButton.getScene().getWindow();
		stage.close();
    }
    
	/**
	 * Store the start menu stage
	 * @param startMenuStage the original start menu stage
	 */
	public static void storeStartMenuStage(Stage startMenuStage){
		SignInController.startMenuStage = startMenuStage;
	}
}