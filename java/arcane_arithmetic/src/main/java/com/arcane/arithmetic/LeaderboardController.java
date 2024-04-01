package com.arcane.arithmetic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

/**
 * This is the Leaderboard Controller, used for controls and events for the leaderboard scene.
 *
 */
public class LeaderboardController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML private Label yourRanking;
	@FXML private TableView<RankingData> leaderboardTable;
	@FXML private TableColumn<RankingData, Integer> rankCol;
	@FXML private TableColumn<RankingData, String> usernameCol;
	@FXML private TableColumn<RankingData, Integer> pointsCol;
	private ObservableList<RankingData> list = FXCollections.observableArrayList();

	/**
	 * Update leaderboard
	 * @param event the load table button is pressed
	 * @throws IOException
	 */
	public void loadTable(ActionEvent event) throws IOException {
		leaderboardTable.setEditable(false);
		rankCol.setCellValueFactory(new PropertyValueFactory<RankingData, Integer>("Rank"));
		usernameCol.setCellValueFactory(new PropertyValueFactory<RankingData, String>("Username"));
		pointsCol.setCellValueFactory(new PropertyValueFactory<RankingData, Integer>("Points"));
		list.clear();
		ObservableList<UserRecord> tmp = UserRecord.fetchAllUserRecordsFromAPI();
		ArrayList<Pair> arr = new ArrayList<Pair>();
		for (UserRecord cur : tmp){
			arr.add(new Pair(cur.getUsername(), cur.getTotalPoints()));
		}
		Collections.sort(arr); int sz = arr.size();
		for (int i = 0; i < sz; i++){
			list.add(new RankingData(i+1, arr.get(i).username, arr.get(i).points));
		}
		leaderboardTable.setItems(list);
	}

	/**
	 * Switch to start menu
	 * @param event back button is pressed
	 * @throws IOException
	 */
	public void switchToStart(ActionEvent event) throws IOException {
		SettingsController.settingsCon.loadSound();
		Parent root = FXMLLoader.load(getClass().getResource("view/StartMenu.fxml"));
		stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		SettingsController.settingsCon.loadFullScreen();
	}

	private static class Pair implements Comparable<Pair>{
		String username; int points;
		Pair(String username, int points){
			this.username = username;
			this.points = points;
		}
		public int compareTo(Pair p){
			return -Integer.compare(points, p.points);
		}
	}
}