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
	public static Stage startMenuStage;

	@FXML
	private BorderPane pane;
	@FXML
	private javafx.scene.control.Button backButton, loginButton;

	public void popUpSignInScene(ActionEvent event, Stage startMenuStage) throws IOException {
		SignInController.startMenuStage = startMenuStage; SignUpController.startMenuStage = startMenuStage;
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		pane = (BorderPane) FXMLLoader.load(getClass().getResource("view/SignIn.fxml"));
		scene = new Scene(pane);
		String SIcss = this.getClass().getResource("css/SignIn.css").toExternalForm();
		scene.getStylesheets().add(SIcss);
		window.setScene(scene);
		window.showAndWait();
	}

	public void switchToSignInScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("view/SignIn.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		String SIcss = this.getClass().getResource("css/SignIn.css").toExternalForm();
		scene.getStylesheets().add(SIcss);
		stage.setScene(scene);
		stage.show();
	}

	public void switchToSignUpScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("view/SignUp.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String SUcss = this.getClass().getResource("css/SignUp.css").toExternalForm();
		scene.getStylesheets().add(SUcss);
		stage.setScene(scene);
		stage.show();
	}

    public void switchToTopic(ActionEvent event) throws IOException {
		Stage stage = (Stage)loginButton.getScene().getWindow();
		stage.close();
		Parent root = FXMLLoader.load(getClass().getResource("view/ChooseTopic.fxml"));
		scene = new Scene(root);
		startMenuStage.setScene(scene);
	}

    public void back(ActionEvent event) throws IOException {
		Stage stage = (Stage)backButton.getScene().getWindow();
		stage.close();
    }
}