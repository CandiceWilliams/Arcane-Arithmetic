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

public class TutorialController2 {
    private Stage stage;
    private Scene scene;
    @FXML private AnchorPane pane;
    @FXML private Button backSlide;
    @FXML private Button nextSlide;
    @FXML private Button nextImg = new Button();
    @FXML private Button prevImg = new Button();
    @FXML private ImageView imageView;
    @FXML private TextFlow textflow;
    @FXML private Circle circle1, circle2, circle3;
    @FXML private Label title, subtitle;

    Color focused = new Color(0.6471, 0.4706, 0.3333, 1.0);
    Color unfocused = new Color(0.9569, 0.7373, 0.549, 1.0);

    String css = this.getClass().getResource("css/tutorial.css").toExternalForm();

//    public void initialize(){
//        subtitle.setText("Multiple Choice");
//        title.setText("QuestionType");
//        nextImg.setOnAction(fillEvent);
//
//    }
    EventHandler<ActionEvent> fiftyEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            try {
            	switchToPowerUpTypeFiftyFifty(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    };

    EventHandler<ActionEvent> doubleEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            try {
            	switchToPowerUpTypeDoubleScore(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    };

    EventHandler<ActionEvent> timeEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            try {
            	switchToPowerUpTypeTime(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    };

    public void switchToPowerUpTypeDoubleScore(ActionEvent event) throws IOException {

        //change text
        subtitle.setText("Double Score");
        subtitle.setTextAlignment(TextAlignment.CENTER);
        Text text = new Text("Get double score for each question during a limited time.\n" +
                "\n" +
                "Gotta go fast!");
        textflow.getChildren().clear();
        textflow.getChildren().add(text);
        textflow.setTextAlignment(TextAlignment.CENTER);
        //set button behaviour
        nextImg.setDisable(false);
        nextImg.setOnAction(fiftyEvent);
        prevImg.setDisable(true);
        //change circle colors
        circle1.setFill(focused);
        circle2.setFill(unfocused);
        circle3.setFill(unfocused);
        //change image
        Image image = new Image(new FileInputStream("src/main/resources/com/arcane/arithmetic/assets/imgs/2x.png"));
        imageView.setImage(image);
        imageView.setFitHeight(136);
        imageView.setFitWidth(136);

    }
    public void switchToPowerUpTypeFiftyFifty(ActionEvent event) throws IOException{
        //change text
        subtitle.setText("Fifty Fifty");
        subtitle.setTextAlignment(TextAlignment.CENTER);
        Text text = new Text("Show only 2 potential answers for your current question.\n" +
                "\n" +
                "Only works for multiple choice!");
        textflow.getChildren().clear();
        textflow.getChildren().add(text);
        textflow.setTextAlignment(TextAlignment.CENTER);
        //set button behaviours
        nextImg.setDisable(false);
        prevImg.setDisable(false);
        nextImg.setOnAction(timeEvent);
        prevImg.setOnAction(doubleEvent);
        //change circle colors
        circle1.setFill(unfocused);
        circle2.setFill(focused);
        circle3.setFill(unfocused);
        //change image
        Image image = new Image(new FileInputStream("src/main/resources/com/arcane/arithmetic/assets/imgs/5050.png"));
        imageView.setImage(image);
        imageView.setFitHeight(170);
        imageView.setFitWidth(118);
        imageView.setPreserveRatio(true);
    }
    public void switchToPowerUpTypeTime(ActionEvent event) throws IOException{
        //change text
        subtitle.setText("Extra Time");
        subtitle.setTextAlignment(TextAlignment.CENTER);
        Text text = new Text("Add 30 seconds to the clock.\n" +
                "\n" +
                "More time, more points!");
        textflow.getChildren().clear();
        textflow.getChildren().add(text);
        textflow.setTextAlignment(TextAlignment.CENTER);
        //set button behaviours
        nextImg.setDisable(true);
        prevImg.setDisable(false);
        prevImg.setOnAction(fiftyEvent);
        //change circle colors
        circle1.setFill(unfocused);
        circle2.setFill(unfocused);
        circle3.setFill(focused);
        //change image
        Image image = new Image(new FileInputStream("src/main/resources/com/arcane/arithmetic/assets/imgs/clock.png"));
        imageView.setImage(image);
        imageView.setFitHeight(132);
        imageView.setFitWidth(126);
    }
    
    public void nextSlide(ActionEvent event) throws IOException{
    	SettingsController.settingsCon.loadSound();
		Parent root = FXMLLoader.load(getClass().getResource("view/Tutorial_3.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String tutorialcss = this.getClass().getResource("css/tutorial.css").toExternalForm();
		scene.getStylesheets().add(tutorialcss);
		stage.setScene(scene);
		stage.show();
    }
    public void backSlide(ActionEvent event) throws IOException{
    	SettingsController.settingsCon.loadSound();
		Parent root = FXMLLoader.load(getClass().getResource("view/Tutorial_1-1.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String tutorialcss = this.getClass().getResource("css/tutorial.css").toExternalForm();
		scene.getStylesheets().add(tutorialcss);
		stage.setScene(scene);
		stage.show();
    }



}
