package com.arcane.arithmetic;

import javafx.fxml.FXML;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the Topic Controller, used for controls and events in the ChooseTopic scene.
 */
public class TopicController {
	private static String topic;
	/**
	 * Save calculus as the topic
	 * Switch to the ChooseDifficulty scene
	 * @param event the calculus button is pressed
	 * @throws IOException
	 */
	public void calculus(ActionEvent event) throws IOException {
		this.topic = "calculus";
		StartController SCCon = new StartController();
		SCCon.switchToDifficulty(event);
	}
	/**
	 * Save algebra as the topic
	 * Switch to the ChooseDifficulty scene
	 * @param event the algebra button is pressed
	 * @throws IOException
	 */
	public void algebra(ActionEvent event) throws IOException {
		topic = "algebra";
		StartController SCCon = new StartController();
		SCCon.switchToDifficulty(event);
	}
	/**
	 * Save stats as the topic
	 * Switch to the ChooseDifficulty scene
	 * @param event the stats button is pressed
	 * @throws IOException
	 */
	public void stats(ActionEvent event) throws IOException {
		topic = "statistics";
		StartController SCCon = new StartController();
		SCCon.switchToDifficulty(event);
	}
	/**
	 * @return the chosen topic for the game
	 */
	public String getTopic() {
		return topic;
	}
	/**
	 * Switch back to the start menu
	 * @param event
	 * @throws IOException
	 */
	public void switchToStart(ActionEvent event) throws IOException {
		StartController SCCon = new StartController();
		SCCon.switchToStartMenu(event);
	}
	/**
	 * Open a calculus tutorial link on your browser
	 * @param event calculus info button is pressed
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void calculusLink(ActionEvent event) throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=HfACrKJ_Y2w"));
	}
	/**
	 * Open an algebra tutorial link on your browser
	 * @param event calculus info button is pressed
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void algebraLink(ActionEvent event) throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URI("http://www.youtube.com/watch?v=JnTa9XtvmfI"));
	}
	/**
	 * Open an intro stats tutorial link on your browser
	 * @param event calculus info button is pressed
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void statsLink(ActionEvent event) throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=xxpc-HPKN28"));
	}
}