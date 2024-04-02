package com.arcane.arithmetic;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

/**
 * This is the Fill in the blanks Controller, used for controls and events for the fills in the blanks question scene during the game
 * 
 * @author Ming Chun Chan
 * @author Candice Williams
 *
 */
public class FillInTheBlanksController{
	private int currQuestion;
	private int totalPts;
	private Scene scene;
	private Stage stage;
	@FXML private TextFlow question;
	@FXML private BorderPane pane;
	@FXML private Label questionNum, timeRemaining, points, cheatsOnLabel, cheatsOffLabel, cantSkipLabel;
	@FXML private TextField ansText;
	@FXML private Button powerup1,powerup2,powerup3,submitButton, skipQuestionButton;
	private String answer;
	private boolean isCorrect = false;
	private GameLoop game = new GameLoop();
	private Parent root;
	EndGameController endController = new EndGameController();
	
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
	/**
	 * @param quest Question text
	 * @param answer Answer text
	 * @throws IOException if error initialising Stage variable
	 */
	public void displayQuestion(String quest, String answer) throws IOException {
		initTime(); initCheats();
		timer.setFont(Font.font("Vinque Rg", 36));
		timer.setFill(Color.WHITE);
		question.getChildren().clear();
		Text text = new Text(quest);
		text.setFont(Font.font("Garamond", 30));
		question.getChildren().add(text);
		question.setTextAlignment(TextAlignment.CENTER);
		currQuestion = game.getQuestionNum();
		questionNum.setText("Question "+currQuestion+"/8");
		totalPts = game.getTotalPts();
		points.setText("Total Points "+totalPts);
		this.answer = answer;
		submitButton.setOnAction(submitButtonClick);
	}


	/**
	 * @param event Submit button is pressed
	 * @throws IOException if error initialising Stage variable
	 */
	private void checkAnswer(ActionEvent event) throws IOException{
		timeLine.stop();

		if (ansText.getText().equals(this.answer)){
			isCorrect = true;
			game.addPoints();
			points.setText("Total Points "+totalPts);
			game.correctAnswers();
		}
		else isCorrect = false;

		game.trackQuestionNum();

		if (currQuestion >= 8){
			Stage thisStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			thisStage.close();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/EndGame.fxml"));
			Stage endStage = new Stage();
			scene = new Scene(loader.load());
			endStage.setScene(scene);
			endController = loader.getController();
			endStage.show();
			endController.displayEndGameScreen(game);

		}
		else{
			game.StartGameLoop(event);
		}

	}

	//Getter for stage
	public Stage getStage(){
		return stage;
	}
	//Setter for stage
	public void setStage(Stage stage){
		this.stage = stage;
	}

	@FXML private Text timer;
	private Timeline timeLine;
	/**
	 * Timer label update
	 */
	public void initTime(){
		timeLine = new Timeline(
				new KeyFrame(Duration.seconds(1),
						event -> {
							if (TimerCountdown.getRemainingSeconds() == -1){
                                try {
                                    stopTimeLine();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
							else if (TimerCountdown.getRemainingSeconds() == 0){
								TimerCountdown.updateTime();
								timer.setText("Time's up!");
							}
							else {
								TimerCountdown.updateTime();
								timer.setText(TimerCountdown.getCurrentTime());
							}
						}
				));
		TimerCountdown.setCurrentTime(180);
		timer.setText(TimerCountdown.getCurrentTime());
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.play();
	}
	/**
	 * Stop timeline
	 */
	public void stopTimeLine() throws IOException {
		timeLine.stop();
		if (game.getQuestionNum() >= 8){
			Stage thisStage = getStage();
			thisStage.close();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/EndGame.fxml"));
			Stage endStage = new Stage();
			try {
				scene = new Scene(loader.load());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			endStage.setScene(scene);
			endController = loader.getController();
			endStage.show();
			endController.displayEndGameScreen(game);
		}
		else {
			game.trackQuestionNum();
			game.StartGameLoop(null);
		}
	}

	/**
	 * initializes the cheat labels
	 */
	private void initCheats(){
		if (CheatsModePasswordPromptController.isCheatsOn()) {
			cheatsOnLabel.setVisible(true);
			cheatsOffLabel.setVisible(false);
		}
		else {
			cheatsOnLabel.setVisible(false);
			cheatsOffLabel.setVisible(true);
		}
	}

	/**
	 * @param event skip button clicked
	 * @throws IOException because it calls the "checkAnswer" method
	 */
	public void skipQuestionClick(ActionEvent event) throws IOException {
		if (CheatsModePasswordPromptController.isCheatsOn()) {
			ansText.setText(this.answer);
			checkAnswer(event);
		}
		else {
			cantSkipLabel.setVisible(true);
			PauseTransition visiblePause = new PauseTransition(Duration.seconds(1));
			visiblePause.setOnFinished(e -> cantSkipLabel.setVisible(false));
			visiblePause.play();
		}
	}
}