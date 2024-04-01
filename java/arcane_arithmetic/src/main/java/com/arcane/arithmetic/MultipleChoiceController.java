package com.arcane.arithmetic;

import javafx.event.EventHandler;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	private List<String> options = new ArrayList<>();
	private boolean isCorrect;
	private String answer;
	String css = this.getClass().getResource("css/multiplechoice.css").toExternalForm();


//	public void createQuestion(ActionEvent event) throws IOException{
//		//Set top bar stats (question number, points)
//		int num=0;
//		int pointsNum=0;
//		questionNum.setText("Question " + num);
//		points.setText("Points: " + pointsNum);
//		//Set question text
//		Text text = new Text("QUESTION QUESTION");
//		question.getChildren().clear();
//		question.getChildren().add(text);
//		//Set answer texts
//		ans1.setText("ans1");
//		ans2.setText("ans2");
//		ans3.setText("ans3");
//		ans4.setText("ans4");
//	}

	public boolean displayQuestion(String quest, String answer, List<String> options){
		this.options = options;
		this.answer = answer;
		question.getChildren().clear();
		question.getChildren().add(new Text(quest));

		ans1.setText(options.get(0));
		ans2.setText(options.get(1));
		ans3.setText(options.get(2));
		ans4.setText(options.get(3));

		while(!ans1.isDisabled() || !ans2.isDisabled() || !ans3.isDisabled() || !ans4.isDisabled()){
			System.out.println("waiting for user");
		}
		return isCorrect;
	}



	public void answerA(ActionEvent event){
		SettingsController.settingsCon.loadSound();
		if (ans1.getText().equals(answer)){
			isCorrect = true;
		}
		else {
			isCorrect = false;
			ans4.setDisable(true);
		}

	}
	public void answerB(ActionEvent event){
		SettingsController.settingsCon.loadSound();
		if (ans2.getText().equals(answer)){
			isCorrect = true;
		}
		else {
			isCorrect = false;
			ans2.setDisable(true);
		}
	}
	public void answerC(ActionEvent event){
		SettingsController.settingsCon.loadSound();
		if (ans3.getText().equals(answer)){
			isCorrect = true;
		}
		else {
			isCorrect = false;
			ans3.setDisable(true);
		}
	}
	public void answerD(ActionEvent event){
		SettingsController.settingsCon.loadSound();
		if (ans4.getText().equals(answer)){
			isCorrect = true;
		}
		else {
			isCorrect = false;
			ans4.setDisable(true);
		}
	}

}