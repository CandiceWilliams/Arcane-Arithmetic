package com.arcane.arithmetic;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class LeaderboardController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private Label yourRanking;
	@FXML
	private TableView leaderboardTable;
	@FXML
	private TableColumn rankCol, usernameCol, pointsCol;
	
	
	public void updateLeaderboard(ActionEvent event) throws IOException {
		leaderboardTable.setEditable(false);
//		rankCol.setCellValueFactory(new PropertyValueFactory<>("rank"));
//		usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
//		pointsCol.setCellValueFactory(new PropertyValueFactory<>("points"));
//		leaderboardTable.getColumns().addAll(rankCol,usernameCol,pointsCol);
		//Data data = new data(rank, username, points);
		//leaderboardTable.getItems().add(data);
		leaderboardTable.refresh();
	}
	public void switchToStart(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
		Parent root = FXMLLoader.load(getClass().getResource("view/StartMenu.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}