package com.arcane.arithmetic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class InstructorDashboardController {

    private Stage stage;
    private Scene scene;

    public void backToMainMenuClick(ActionEvent event) throws IOException {
        StartController SCCon = new StartController();
        SCCon.switchToStartMenu(event);
    }
}
