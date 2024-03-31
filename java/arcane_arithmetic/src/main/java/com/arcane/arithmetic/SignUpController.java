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

public class SignUpController {
	private Scene scene;
	private static Stage startMenuStage;
	@FXML private javafx.scene.control.Button signUpButton;
	@FXML private Label existedUsername,usernameTooLong,pwSpecial,pwDiff;
	@FXML private TextField username,password,confirmPassword; 
	
    public void switchToSignInScene(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
        SignInController SICon = new SignInController();
        SICon.switchToSignInScene(event);
    }
    public void switchToTopic(ActionEvent event) throws IOException {
    	SettingsController.settingsCon.loadSound();
//    	if(!password.getText().equals(confirmPassword.getText())) {
//    		pwDiff.setVisible(true);	
//    	} else if(username.getText().length()<3 || username.getText().length()>12) {
//    		usernameTooLong.setVisible(true);
//    	} else {
//	    	String newUser = "{\"username\": \"" + username.getText() + "\", \"password\": \""+ password.getText()+
//	    			"\", \"name\": \""+username.getText() + "\", \"privilege\": \"user\"}";
//    		String encodedUser = URLEncoder.encode(newUser, "UTF-8");
//	    	try {
//	    		String urlString = "http://127.0.0.1:5000/database/users/insert?data=";
//	    		urlString += encodedUser;
//	    		
//	    		URL url = new URL(urlString);
//	    		HttpURLConnection con = (HttpURLConnection) url.openConnection();
//	    		con.setRequestMethod("GET");
//	    		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//	    		
//	    		String inputLine;
//	    		StringBuilder content = new StringBuilder();
//	    		
//	    		while ((inputLine = in.readLine()) != null) {
//	    			content.append(inputLine);
//	    		}
//	    		in.close();
//	    		con.disconnect();
//	    		System.out.print(content.toString());
//	    		if(content.toString()=="{\"Error\":\"Invalid Input\"}") {
//	    			pwSpecial.setVisible(true);
//	    		} else if(content.toString()=="{\"Error\":\"User already exists\"}") {
//	    			existedUsername.setVisible(true);
//	    		} else if(content.toString()=="{\"Error\":\"No field specified\"}"){
//	    			
//	    		} else {
//	    			ObjectMapper objectMapper = new ObjectMapper();
//	    			JsonNode json = objectMapper.readTree(content.toString());
//	    			Stage stage = (Stage)signUpButton.getScene().getWindow();
//	    			stage.close();
//	    			Parent root = FXMLLoader.load(getClass().getResource("view/ChooseTopic.fxml"));
//	    			scene = new Scene(root);
//	    			startMenuStage.setScene(scene);
//	    			SettingsController.settingsCon.loadFullScreen();
//	    			existedUsername.setVisible(false);
//	    			pwSpecial.setVisible(false);
//	    			pwDiff.setVisible(false);	
//	    			usernameTooLong.setVisible(false);
//	    		}
//	    	} catch (Exception e) {
//	    		e.printStackTrace();
//	    	}
//    	}
    	
    	//temporary without api
    	Stage stage = (Stage)signUpButton.getScene().getWindow();
		stage.close();
		Parent root = FXMLLoader.load(getClass().getResource("view/ChooseTopic.fxml"));
		scene = new Scene(root);
		startMenuStage.setScene(scene);
		SettingsController.settingsCon.loadFullScreen();
	}

	public static void storeStartMenuStage(Stage startMenuStage){
		SignUpController.startMenuStage = startMenuStage;
	}
}