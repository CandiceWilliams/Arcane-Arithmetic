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

import com.fasterxml.jackson.databind.ObjectMapper;

public class SignInController {	

	public Stage stage;
	public Scene scene;
	public Parent root;
	private static Stage startMenuStage;

	@FXML private BorderPane pane;
	@FXML private Button backButton, loginButton;
	@FXML private Label errorLabel;
	@FXML private TextField username,password;
	
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
		if(content.toString()=="{\"Error\":\"User Not Found\"}") {
			errorLabel.setVisible(true);
		} else if(content.toString()=="{\"Error\":\"No field specified\"}") {
			errorLabel.setVisible(true);
		} else {
			ObjectMapper objectMapper = new ObjectMapper();
			User user = objectMapper.readValue(content.toString(), User.class);
			if(user.getPassword().equals(password.getText())) {
				Stage stage = (Stage)loginButton.getScene().getWindow();
				stage.close();
				Parent root = FXMLLoader.load(getClass().getResource("view/ChooseTopic.fxml"));
				scene = new Scene(root);
				startMenuStage.setScene(scene);
				SettingsController.settingsCon.loadFullScreen();
				errorLabel.setVisible(false);
			} else {
				errorLabel.setVisible(true);
			}
		}
	}

    public void back(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
		Stage stage = (Stage)backButton.getScene().getWindow();
		stage.close();
    }

	public static void storeStartMenuStage(Stage startMenuStage){
		SignInController.startMenuStage = startMenuStage;
	}
}