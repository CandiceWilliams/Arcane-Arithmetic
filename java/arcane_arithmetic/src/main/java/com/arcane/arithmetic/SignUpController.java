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
        StartController SUCon = new StartController();
        SUCon.switchToSignInScene(event);
    }
    public void switchToTopic(ActionEvent event) throws IOException {
    	StartController startCon = new StartController();
    	startCon.switchToTopicScene(event);
	}
}