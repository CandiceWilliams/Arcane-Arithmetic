package com.arcane.arithmetic;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.arcane.arithmetic.TutorialController;

import java.io.IOException;

public class StartController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	TutorialController tutcon = new TutorialController();
	public void openTutorial(ActionEvent event) throws IOException {
		tutcon.switchToPage1(event);

	}


}