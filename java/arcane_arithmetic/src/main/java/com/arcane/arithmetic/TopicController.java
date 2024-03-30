package com.arcane.arithmetic;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TopicController {
	private String topic;
	public void calculus(ActionEvent event) throws IOException {
		topic = "calculus";
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

}