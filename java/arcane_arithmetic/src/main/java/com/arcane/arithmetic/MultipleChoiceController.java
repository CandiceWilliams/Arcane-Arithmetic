package com.arcane.arithmetic;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

public class MultipleChoiceController {
	@FXML private Button ans1,ans2,ans3,ans4;
	@FXML private TextFlow question;
	@FXML private Label questionNum, timeRemaining, points;
	@FXML private Button powerup1,powerup2,powerup3;
	private List<String> options = new ArrayList<>();
	private boolean isCorrect;
	private String answer;
	private GameLoop game = new GameLoop();
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

	@FXML private Text timer;
	private Timeline timeLine;
	public void initTime(){
		timeLine = new Timeline(
				new KeyFrame(Duration.seconds(1),
						event -> {
							if (TimerCountdown.getRemainingSeconds() == 0){
								timer.setText("Time's up!");
								SequentialTransition seqTransition = new SequentialTransition (
										new PauseTransition(Duration.millis(1000)) // wait a second
								);
								seqTransition.play();
								game.trackQuestionNum();
								try {
									game.StartGameLoop(event);
								} catch (IOException e) {
									throw new RuntimeException(e);
								}
							}
							TimerCountdown.updateTime();
							timer.setText(TimerCountdown.getCurrentTime());
						}
				));
		TimerCountdown.setCurrentTime(180);
		timer.setText(TimerCountdown.getCurrentTime());
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.play();
	}
	public void stopTimeLine(){
		timeLine.stop();
	}
}