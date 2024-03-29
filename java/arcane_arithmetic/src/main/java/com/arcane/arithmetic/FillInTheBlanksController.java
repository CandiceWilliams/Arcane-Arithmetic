package com.arcane.arithmetic;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class FillInTheBlanksController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TextFlow question;
	@FXML
	private Label questionNum, timeRemaining, points;
	@FXML 
	private TextField ansText;
	String css = this.getClass().getResource("css/multiplechoice.css").toExternalForm();
	public void createQuestion(ActionEvent event) throws IOException{
		//Set top bar stats (question number, points)
		int num=0;
		int pointsNum=0;
		questionNum.setText("Question " + num);
		points.setText("Points: " + pointsNum);
		//Set question text
		Text text = new Text("QUESTION QUESTION");
		question.getChildren().clear();
		question.getChildren().add(text);
	}
	public void submitAnswer(ActionEvent event){
		if(ansText.getText()=="") {
			
		}
	}

}