package com.arcane.arithmetic;

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
import java.io.IOException;
import javafx.scene.control.cell.PropertyValueFactory;

public class InstructorDashboardController {
    private static Stage window = new Stage();
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

    public void insertUserIntoTable(UserRecord userRecord){
        if (hasUserID(list, userRecord.getUserID())) return; // don't insert user if they already exist (determined using userID)
        list.add(userRecord);
    }

    public void loadTable(){
        userID.setCellValueFactory(new PropertyValueFactory<UserRecord,String>("UserID"));
        username.setCellValueFactory(new PropertyValueFactory<UserRecord,String>("Username"));
        points.setCellValueFactory(new PropertyValueFactory<UserRecord,Integer>("TotalPoints"));
        averageWinRate.setCellValueFactory(new PropertyValueFactory<UserRecord,Double>("AverageWinRate"));
        averageRightAnswers.setCellValueFactory(new PropertyValueFactory<UserRecord,Double>("AverageRight"));
        averageWrongAnswers.setCellValueFactory(new PropertyValueFactory<UserRecord,Double>("AverageWrong"));
        // ----- code for testing -------------------
        UserRecord scottRecord = new UserRecord("stLv123", "scott", 77, 2, 5, 3, 7);
        UserRecord bobRecord = new UserRecord("bggUxV954", "bob", 4, 5, 8, 200, 5);
        UserRecord billyRecord = new UserRecord("bHe4p33i", "billy", 1, 1, 1, 1, 0);
        insertUserIntoTable(scottRecord); insertUserIntoTable(bobRecord); insertUserIntoTable(billyRecord);
        // ----- code for testing -------------------
        // TODO: Load API data into cells
        table.setItems(list);
    }

    private boolean hasUserID(ObservableList<UserRecord> list, String cmp){
        for (UserRecord cur : list){
            if (cur.getUserID().equals(cmp)){
                return true;
            }
        }
        return false;
    }
}
