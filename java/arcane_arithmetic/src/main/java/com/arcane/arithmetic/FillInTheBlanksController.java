package com.arcane.arithmetic;

import javafx.event.EventHandler;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class FillInTheBlanksController{
	private int currQuestion;
	private int totalPts;
	private Scene scene;
	private Stage stage;
	@FXML private TextFlow question;
	@FXML private BorderPane pane;
	@FXML private Label questionNum, timeRemaining, points;
	@FXML private TextField ansText;
	@FXML private Button powerup1,powerup2,powerup3,submitButton;
	private String answer;
	private boolean isCorrect = false;
	GameLoop game = new GameLoop();
	private TimerCountdown timer = new TimerCountdown();
	private Parent root;
	//String css = this.getClass().getResource("css/fillintheblanks.css").toExternalForm();



	EventHandler<ActionEvent> submitButtonClick = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent e)
		{
			try {
				checkAnswer(e);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}
	};
	public void displayQuestion(String quest, String answer) throws IOException {
		question.getChildren().clear();
		Text text = new Text(quest);
		question.getChildren().add(text);
		question.setTextAlignment(TextAlignment.CENTER);
		currQuestion = game.getQuestionNum();
		questionNum.setText("Question "+currQuestion+"/20");
		totalPts = game.getTotalPts();
		points.setText("Total Points "+totalPts);
		//timeRemaining.setText(String.valueOf(timer.countdown(60)));

		this.answer = answer;
		submitButton.setOnAction(submitButtonClick);
	}


	private void checkAnswer(ActionEvent event) throws IOException{
		if (ansText.getText().equals(this.answer)){
			isCorrect = true;
			game.addPoints();
			points.setText("Total Points "+totalPts);
			game.correctAnswers();
		}
		else isCorrect = false;

		game.trackQuestionNum();

		if (currQuestion >= 20){

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/EndGame"));
			Stage endStage = new Stage();
			scene = new Scene(loader.load());
			endStage.setScene(scene);

			EndGameController endController = new EndGameController();
			endController = loader.getController();
			endStage.show();
			endController.displayEndGameScreen();

		}
		else{
			game.StartGameLoop(event);
		}

	}

	public Stage getStage(){
		return stage;
	}

	public void setStage(Stage stage){
		this.stage = stage;
	}


}