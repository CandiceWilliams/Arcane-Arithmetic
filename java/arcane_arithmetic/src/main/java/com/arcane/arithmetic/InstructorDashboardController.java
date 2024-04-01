package com.arcane.arithmetic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This is the Instructor Dashboard Controller, used for controls and events for the instructor dashboard.
 *
 */
public class InstructorDashboardController {
    public static InstructorDashboardController instructDashCon = new InstructorDashboardController();
    private Stage window = new Stage();
    private Scene scene;
    private ObservableList<UserRecord> list = FXCollections.observableArrayList();

    @FXML private Button loadTableButton;
    @FXML private TableView<UserRecord> table;
    @FXML private TableColumn<UserRecord, String> userID;
    @FXML private TableColumn<UserRecord, String> username;
    @FXML private TableColumn<UserRecord, Integer> points;
    @FXML private TableColumn<UserRecord, Double> averageWinRate;
    @FXML private TableColumn<UserRecord, Double> averageRightAnswers;
    @FXML private TableColumn<UserRecord, Double> averageWrongAnswers;

    /**
     * Return to start menu
     * @param event back button is pressed
     * @throws IOException
     */
    public void backToMainMenuClick(ActionEvent event) throws IOException {
        StartController SCCon = new StartController();
        SCCon.switchToStartMenu(event);
    }

    /**
     * Update table with UserID, Username, Total points, Average win rate, average right answers and average wrong answers
     */
    public void loadTable(){
        userID.setCellValueFactory(new PropertyValueFactory<UserRecord,String>("UserID"));
        username.setCellValueFactory(new PropertyValueFactory<UserRecord,String>("Username"));
        points.setCellValueFactory(new PropertyValueFactory<UserRecord,Integer>("TotalPoints"));
        averageWinRate.setCellValueFactory(new PropertyValueFactory<UserRecord,Double>("AverageWinRate"));
        averageRightAnswers.setCellValueFactory(new PropertyValueFactory<UserRecord,Double>("AverageRight"));
        averageWrongAnswers.setCellValueFactory(new PropertyValueFactory<UserRecord,Double>("AverageWrong"));
        list.clear();
        ObservableList<UserRecord> tmp = UserRecord.fetchAllUserRecordsFromAPI();
        list.addAll(tmp); // tmp is never null because it is impossible for "UserRecord.fetchAllUserRecordsFromAPI()" to encounter errors
        table.setItems(list);
    }
}
