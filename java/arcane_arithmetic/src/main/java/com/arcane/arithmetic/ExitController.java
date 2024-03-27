package com.arcane.arithmetic;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExitController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	public static Stage startMenuStage;
	@FXML
	private AnchorPane pane;
	@FXML
	private javafx.scene.control.Button YesButton,NoButton;
	
	public void popUpExitScene(ActionEvent event, Stage startMenuStage) throws IOException {
		ExitController.startMenuStage = startMenuStage;
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		pane = (AnchorPane) FXMLLoader.load(getClass().getResource("view/Exit.fxml"));
		scene = new Scene(pane);
		String Exitcss = this.getClass().getResource("css/exit.css").toExternalForm();
		scene.getStylesheets().add(Exitcss);
		window.setScene(scene);
		window.setResizable(false);
		window.setTitle("Alert!");
		window.centerOnScreen();
		window.showAndWait();
	}
	public void confirmExit(ActionEvent event) throws IOException{
		Stage stage = (Stage)YesButton.getScene().getWindow();
		stage.close();
		startMenuStage.close();
	}
	public void returnToMain(ActionEvent event) throws IOException{
		Stage stage = (Stage)NoButton.getScene().getWindow();
		stage.close();
	}
}