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

    public void backToMainMenuClick(ActionEvent event) throws IOException {
        StartController SCCon = new StartController();
        SCCon.switchToStartMenu(event);
    }

    public void loadTable(){
        userID.setCellValueFactory(new PropertyValueFactory<UserRecord,String>("UserID"));
        username.setCellValueFactory(new PropertyValueFactory<UserRecord,String>("Username"));
        points.setCellValueFactory(new PropertyValueFactory<UserRecord,Integer>("TotalPoints"));
        averageWinRate.setCellValueFactory(new PropertyValueFactory<UserRecord,Double>("AverageWinRate"));
        averageRightAnswers.setCellValueFactory(new PropertyValueFactory<UserRecord,Double>("AverageRight"));
        averageWrongAnswers.setCellValueFactory(new PropertyValueFactory<UserRecord,Double>("AverageWrong"));
        list.clear();
        updateTableWithUserRecordsFromRanksAPI();
        table.setItems(list);
    }

    public void updateTableWithUserRecordsFromRanksAPI() {
        try {
            String urlString = "http://127.0.0.1:5000/database/ranks/getall";
            // Send the request to the server
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Close the connection
            in.close();
            con.disconnect();
            // Print the response
            JsonNode arrNode = new ObjectMapper().readTree(content.toString());
            System.out.println("List of all user records: ");
            System.out.println(arrNode.toPrettyString());
            for (final JsonNode node : arrNode) {
                int totalPoints = Integer.parseInt(node.get("totalPoints").toString());
                int totalWon = Integer.parseInt(node.get("totalWon").toString());
                int totalPlayed = Integer.parseInt(node.get("totalPlayed").toString());
                int totalCorrect = Integer.parseInt(node.get("totalCorrect").toString());
                int totalIncorrect = Integer.parseInt(node.get("totalIncorrect").toString());
                String userID = node.get("ownerID").toString();
                userID = userID.substring(1, userID.length()-1);
                String username = UserRecord.getUsernameFromUserID(userID);
                if (username == null) continue;
                UserRecord toAdd = new UserRecord(userID, username, totalPoints, totalWon, totalPlayed, totalCorrect, totalIncorrect);
                list.add(toAdd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
