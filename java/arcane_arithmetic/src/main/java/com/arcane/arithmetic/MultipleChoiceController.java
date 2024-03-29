package com.arcane.arithmetic;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class MultipleChoiceController {
	@FXML private Button ans1,ans2,ans3,ans4;
	@FXML private TextFlow question;
	@FXML private Label questionNum, timeRemaining, points;
	@FXML private Button powerup1,powerup2,powerup3;
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
		//Set answer texts
		ans1.setText("ans1");
		ans2.setText("ans2");
		ans3.setText("ans3");
		ans4.setText("ans4");
	}
	public void answerA(ActionEvent event){
		SettingsController.settingsCon.loadSound();
	}
	public void answerB(ActionEvent event){
		SettingsController.settingsCon.loadSound();
	}
	public void answerC(ActionEvent event){
		SettingsController.settingsCon.loadSound();
	}
	public void answerD(ActionEvent event){
		SettingsController.settingsCon.loadSound();
	}

}