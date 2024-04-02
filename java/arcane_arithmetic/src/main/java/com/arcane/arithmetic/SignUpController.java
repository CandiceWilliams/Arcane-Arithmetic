package com.arcane.arithmetic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is the Sign Up Controller, used for controls and events in the sign up pop up.
 *
 * @author Justin Xu
 * @author Ming Chun Chan
 * 
 */
public class SignUpController {
	private Scene scene;
	private static Stage startMenuStage;
	@FXML private javafx.scene.control.Button signUpButton;
	@FXML private Label existedUsername,usernameTooLong,pwSpecial,pwDiff;
	@FXML private TextField username,password,confirmPassword; 
	
    /**
     * Switch to sign-in scene
     * @param event switch to sign in button is pressed
     * @throws IOException if error initialising Stage variable
     */
    public void switchToSignInScene(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
        SignInController SICon = new SignInController();
        SICon.switchToSignInScene(event);
    }
    /**
     * Switch to ChooseTopic scene
     * Save sign-up data to the database
     * @param event sign-up button is pressed
     * @throws IOException if error initialising Stage variable
     */
    public void switchToTopic(ActionEvent event) throws IOException {
    	SettingsController.settingsCon.loadSound();
    	if(!password.getText().equals(confirmPassword.getText())) {
    		pwDiff.setVisible(true);	
    	} else if(username.getText().length()<3 || username.getText().length()>12) {
    		usernameTooLong.setVisible(true);
    	} else {
	    	String newUser = "{\"username\": \"" + username.getText() + "\", \"password\": \""+ password.getText()+
	    			"\", \"name\": \""+username.getText() + "\", \"privilege\": \"user\"}";
    		String encodedUser = URLEncoder.encode(newUser, "UTF-8");
	    	try {
	    		String urlString = "http://127.0.0.1:5000/database/users/insert?data=";
	    		urlString += encodedUser;
	    		
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
	    		if(content.toString().equals("{\"Error\": \"Invalid Input\"}")) {
	    			pwSpecial.setVisible(true);
	    		} else if(content.toString().equals("{\"Error\": \"User already exists\"}")) {
	    			existedUsername.setVisible(true);
	    		} else if(content.toString().equals("{\"Error\": \"No field specified\"}")){
	    			
	    		} else {
	    			ObjectMapper objectMapper = new ObjectMapper();
	    			JsonNode json = objectMapper.readTree(content.toString());
	    			Stage stage = (Stage)signUpButton.getScene().getWindow();
	    			stage.close();
	    			Parent root = FXMLLoader.load(getClass().getResource("view/ChooseTopic.fxml"));
	    			scene = new Scene(root);
	    			startMenuStage.setScene(scene);
	    			SettingsController.settingsCon.loadFullScreen();
	    			existedUsername.setVisible(false);
	    			pwSpecial.setVisible(false);
	    			pwDiff.setVisible(false);	
	    			usernameTooLong.setVisible(false);

					String userID = json.get("id").toString();
					userID = userID.substring(1,userID.length()-1);
					String userName = username.getText();
					int totalPoints = 0;
					int totalWon = 0;
					int totalPlayed = 0;
					int totalCorrect = 0;
					int totalIncorrect = 0;
					UserRecord toAdd = new UserRecord(userID, userName, totalPoints, totalWon, totalPlayed, totalCorrect, totalIncorrect);
					UserRecord.insertUserRecordIntoAPI(toAdd);

					// updating the user id of the current player in EndGameController
					String tmpStr = json.get("id").toString();
					String tmpUserID = tmpStr.substring(1, tmpStr.length()-1);
					EndGameController.setCurrentPlayerUserID(tmpUserID);
	    		}
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
    	}
	}

	/**
	 * Store start menu stage
	 * @param startMenuStage the original start menu stage
	 */
	public static void storeStartMenuStage(Stage startMenuStage){
		SignUpController.startMenuStage = startMenuStage;
	}
}