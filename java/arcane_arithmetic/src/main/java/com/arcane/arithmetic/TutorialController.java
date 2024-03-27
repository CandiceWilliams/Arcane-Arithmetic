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
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Popup;
import javafx.stage.StageStyle;
import org.controlsfx.control.PopOver;


import java.io.IOException;

public class TutorialController {
    private Stage window = new Stage();
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane pane;
    @FXML
    private Button back;
    @FXML
    private Button next;

    String css = this.getClass().getResource("css/tutorial.css").toExternalForm();

    public void startTutorial(ActionEvent event) throws IOException{

    }

    public void switchToQuestionTypeMC(ActionEvent event) throws IOException {
        window.initModality(Modality.APPLICATION_MODAL);
        window.resizableProperty().setValue(Boolean.FALSE);
        pane = (AnchorPane) FXMLLoader.load(getClass().getResource("view/Tutorial_1-1.fxml"));
        //window.initStyle(StageStyle.UNDECORATED);

        scene = new Scene(pane);
        //scene.setFill(Color.TRANSPARENT);
        //window.initStyle(StageStyle.TRANSPARENT);
        scene.getStylesheets().add(css);
        window.setScene(scene);
        window.showAndWait();
    }
    public void switchToQuestionTypeFill(ActionEvent event) throws IOException{
        window.initModality(Modality.APPLICATION_MODAL);
        window.resizableProperty().setValue(Boolean.FALSE);
        pane = (AnchorPane) FXMLLoader.load(getClass().getResource("view/Tutorial_1-2.fxml"));

        scene = new Scene(pane);;
        scene.getStylesheets().add(css);
        window.setScene(scene);
        window.showAndWait();

    }
    public void switchToQuestionTypeMatching(ActionEvent event) throws IOException{
        window.initModality(Modality.APPLICATION_MODAL);
        window.resizableProperty().setValue(Boolean.FALSE);
        pane = (AnchorPane) FXMLLoader.load(getClass().getResource("view/Tutorial_1-3.fxml"));

        scene = new Scene(pane);;
        scene.getStylesheets().add(css);
        window.setScene(scene);
        window.showAndWait();
    }

    public void multipleChoiceExplanation(){

    }


}
