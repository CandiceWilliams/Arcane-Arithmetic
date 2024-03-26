package com.arcane.arithmetic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignUpController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
    private javafx.scene.control.Button signUpButton;
	
    public void switchToSignInScene(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("view/SignIn.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("css/SignIn.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Sign Up");
        stage.show();
    }
    public void switchToTopic(ActionEvent event) throws IOException {
    	StartController startCon = new StartController();
    	Stage stage = (Stage) signUpButton.getScene().getWindow();
    	stage.close();
    	startCon.switchToTopicScene(event);
	}
    public void signUpButtonClick(ActionEvent event) throws IOException {

    }
}