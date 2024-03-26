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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignInController {

	public Stage stage;
	public Scene scene;
	public Parent root;
	@FXML
	private BorderPane pane;
	@FXML
	private javafx.scene.control.Button backButton, loginButton;
	
	String css = this.getClass().getResource("css/SignIn.css").toExternalForm();
	
	public void switchToSignInScene(ActionEvent event) throws IOException {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		pane = (BorderPane) FXMLLoader.load(getClass().getResource("view/SignIn.fxml"));
		scene = new Scene(pane);
		scene.getStylesheets().add(css);
		window.setScene(scene);
		window.showAndWait();
	}
    public void switchToSignUpScene(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("view/SignUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        String SUcss = this.getClass().getResource("css/SignUp.css").toExternalForm();
        scene = new Scene(root);
        scene.getStylesheets().add(SUcss);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToTopic(ActionEvent event) throws IOException {
    	StartController startCon = new StartController();
    	Stage stage = (Stage) loginButton.getScene().getWindow();
    	stage.close();
    	startCon.switchToTopicScene(event);
	}
    public void back(ActionEvent event) throws IOException {
    	Stage stage = (Stage) backButton.getScene().getWindow();
    	stage.close();
    }
    public void signInButtonClick(ActionEvent event) throws IOException {

    }
}