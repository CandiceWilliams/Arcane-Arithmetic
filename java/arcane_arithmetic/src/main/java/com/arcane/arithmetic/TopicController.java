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

public class TopicController {
	private static String topic;
	public void calculus(ActionEvent event) throws IOException {
		this.topic = "calculus";
		StartController SCCon = new StartController();
		SCCon.switchToDifficulty(event);
	}
	public void algebra(ActionEvent event) throws IOException {
		topic = "algebra";
		StartController SCCon = new StartController();
		SCCon.switchToDifficulty(event);
	}
	public void stats(ActionEvent event) throws IOException {
		topic = "statistics";
		StartController SCCon = new StartController();
		SCCon.switchToDifficulty(event);
	}
	public String getTopic() {
		return topic;
	}
	public void switchToStart(ActionEvent event) throws IOException {
		StartController SCCon = new StartController();
		SCCon.switchToStartMenu(event);
	}
	public void calculusLink(ActionEvent event) throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=HfACrKJ_Y2w"));
	}
	public void algebraLink(ActionEvent event) throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URI("http://www.youtube.com/watch?v=JnTa9XtvmfI"));
	}
	public void statsLink(ActionEvent event) throws IOException, URISyntaxException {
		Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=xxpc-HPKN28"));
	}
}