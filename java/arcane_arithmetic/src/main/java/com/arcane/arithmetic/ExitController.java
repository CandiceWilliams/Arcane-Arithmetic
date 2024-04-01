package com.arcane.arithmetic;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This is the Exit Controller, used for controls and events for the exit pop up.
 *
 */
public class ExitController {
	private Scene scene;
	public static Stage startMenuStage;
	@FXML private AnchorPane pane;
	@FXML private javafx.scene.control.Button YesButton,NoButton;
	
	/**
	 * Initialize the exit pop up
	 * @param event the exit button is pressed
	 * @param startMenuStage the original start menu stage
	 * @throws IOException
	 */
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
	/**
	 * Confirm exit
	 * @param event "yes" button is pressed
	 * @throws IOException
	 */
	public void confirmExit(ActionEvent event) throws IOException{
		SettingsController.settingsCon.loadSound();
		Stage stage = (Stage)YesButton.getScene().getWindow();
		stage.close();
		startMenuStage.close();
	}
	/**
	 * Back to the main menu
	 * @param event "no" button is pressed
	 * @throws IOException
	 */
	public void returnToMain(ActionEvent event) throws IOException{
		SettingsController.settingsCon.loadSound();
		Stage stage = (Stage)NoButton.getScene().getWindow();
		stage.close();
	}
}