package com.arcane.arithmetic;

import javafx.event.EventHandler;
import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class FillInTheBlanksController{
	public int num=0;
	public int pointsNum=0;
	private Scene scene;
	@FXML private TextFlow question;
	@FXML private Label questionNum, timeRemaining, points;
	@FXML private TextField ansText;
	@FXML private Button powerup1,powerup2,powerup3,submitButton;
	private String answer;
	private boolean isCorrect = false;
	String css = this.getClass().getResource("css/fillintheblanks.css").toExternalForm();

	EventHandler<ActionEvent> submitAnswer = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e)
		{
			try {
				checkAnswer(e);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}
	};


	public boolean displayQuestion(String quest, String answer){
		question.getChildren().clear();
		Text text = new Text(quest);
		question.getChildren().add(text);
		this.answer = answer;
		submitButton.setOnAction(submitAnswer);
		return isCorrect;
	}


//	public void createQuestion(ActionEvent event) throws IOException{
//		//Set top bar stats (question number, points)
//		questionNum.setText("Question " + num);
//		points.setText("Points: " + pointsNum);
//		//Set question text
//		Text text = new Text("QUESTION QUESTION");
//		question.getChildren().clear();
//		question.getChildren().add(text);
//	}
//	public void submitAnswer(ActionEvent event){
//		SettingsController.settingsCon.loadSound();
//		if(ansText.getText()==answer) {
//
//		}
//	}

	private boolean checkAnswer(ActionEvent event) throws IOException{
		if (ansText.getText().equals(this.answer)){
			isCorrect = true;
		}
		else isCorrect = false;

		return isCorrect;
	}

}