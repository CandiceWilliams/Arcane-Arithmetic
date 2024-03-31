package com.arcane.arithmetic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Popup;
import javafx.stage.StageStyle;
import org.controlsfx.control.PopOver;


import java.io.FileInputStream;
import java.io.IOException;

public class TutorialController3 {
    private Stage stage;
    private Scene scene;
    @FXML private AnchorPane pane;
    @FXML private Button backSlide;
    @FXML private Button nextSlide;
    @FXML private Button nextImg = new Button();
    @FXML private Button prevImg = new Button();
    @FXML private ImageView imageView;
    @FXML private TextFlow textflow;
    @FXML private Label title, subtitle;

    String css = this.getClass().getResource("css/tutorial.css").toExternalForm();
    
    public void nextSlide(ActionEvent event) throws IOException{
    	SettingsController.settingsCon.loadSound();
		Stage stage = (Stage)backSlide.getScene().getWindow();
		stage.close();
    }
    public void backSlide(ActionEvent event) throws IOException{
    	SettingsController.settingsCon.loadSound();
		Parent root = FXMLLoader.load(getClass().getResource("view/Tutorial_2.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String tutorialcss = this.getClass().getResource("css/tutorial.css").toExternalForm();
		scene.getStylesheets().add(tutorialcss);
		stage.setScene(scene);
		stage.show();
    }



}
