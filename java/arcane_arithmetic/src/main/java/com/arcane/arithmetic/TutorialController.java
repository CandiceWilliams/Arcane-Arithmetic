package com.arcane.arithmetic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Popup;
import org.controlsfx.control.PopOver;


import java.io.IOException;

public class TutorialController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane pane;
    @FXML
    private Button back;
    @FXML
    private Button next;

    String css = this.getClass().getResource("css/ui.css").toExternalForm();
    public void switchToPage1(ActionEvent event) throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        pane = (AnchorPane) FXMLLoader.load(getClass().getResource("view/tutorial-view.fxml"));

        scene = new Scene(pane);
        scene.getStylesheets().add(css);
        window.setScene(scene);
        window.showAndWait();
        
    }
    public void switchToPage2(ActionEvent event){

    }
    public void switchToPage3(ActionEvent event){

    }
}
