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



import java.io.FileInputStream;
import java.io.IOException;

/**
 * This is the Tutorial Controller, used for controls and events for the first tutorial scene.
 * 
 * @author Candice Williams
 *
 */
public class TutorialController {
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
    
    EventHandler<ActionEvent> fillEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            try {
                switchToQuestionTypeFill(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    };

    EventHandler<ActionEvent> mcEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            try {
                switchToQuestionTypeMC(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    };

    EventHandler<ActionEvent> matchEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
            try {
                switchToQuestionTypeMatching(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    };


    /**
     * Initialize the tutorial pop up
     * @param event the tutorial button is pressed
     * @throws IOException if error initialising Stage variable
     */
    public void startTutorial(ActionEvent event) throws IOException{
    	Stage window = new Stage();
    	window.initModality(Modality.APPLICATION_MODAL);
        window.resizableProperty().setValue(Boolean.FALSE);
        pane = (AnchorPane) FXMLLoader.load(getClass().getResource("view/Tutorial_1-1.fxml"));

        scene = new Scene(pane);
        scene.getStylesheets().add(css);
        window.setScene(scene);
        window.showAndWait();

        nextImg.setOnAction(fillEvent);

    }

    /**
     * Show Multiple Choice text and image tutorial
     * @param event mcEvent is initialized
     * @throws IOException if error initialising Stage variable
     */
    public void switchToQuestionTypeMC(ActionEvent event) throws IOException {

        //change text
        subtitle.setText("Multiple Choice");
        subtitle.setTextAlignment(TextAlignment.CENTER);
        Text text = new Text("Choose the best answer out of the options provided.\n" +
                "\n" +
                "Once you are confident with your answer, hit 'Submit'!");
        textflow.getChildren().clear();
        textflow.getChildren().add(text);
        textflow.setTextAlignment(TextAlignment.CENTER);
        //set button behaviour
        nextImg.setDisable(false);
        nextImg.setOnAction(fillEvent);
        prevImg.setDisable(true);
        //change circle colors
        circle1.setFill(focused);
        circle2.setFill(unfocused);
        circle3.setFill(unfocused);
        //change image
        Image image = new Image(new FileInputStream("src/main/resources/com/arcane/arithmetic/assets/imgs/MC_Color.png"));
        imageView.setImage(image);
        imageView.setFitHeight(136);
        imageView.setFitWidth(136);

    }
    /**
     * Show Fill in the blanks text and image tutorial
     * @param event fbEvent is initialized
     * @throws IOException if error initialising Stage variable
     */
    public void switchToQuestionTypeFill(ActionEvent event) throws IOException{
        //change text
        subtitle.setText("Fill-in-the-Blank");
        subtitle.setTextAlignment(TextAlignment.CENTER);
        Text text = new Text("Use your mouse and keyboard to type the correct answers in the blank spots provided.\n" +
                "\n" +
                "Once you are confident with your answer, hit 'Submit'!");
        textflow.getChildren().clear();
        textflow.getChildren().add(text);
        textflow.setTextAlignment(TextAlignment.CENTER);
        //set button behaviours
        nextImg.setDisable(false);
        prevImg.setDisable(false);
        nextImg.setOnAction(matchEvent);
        prevImg.setOnAction(mcEvent);
        //change circle colors
        circle1.setFill(unfocused);
        circle2.setFill(focused);
        circle3.setFill(unfocused);
        //change image
        Image image = new Image(new FileInputStream("src/main/resources/com/arcane/arithmetic/assets/imgs/fill-in-the-blank.png"));
        imageView.setImage(image);
        imageView.setFitHeight(170);
        imageView.setFitWidth(118);
        imageView.setPreserveRatio(true);
    }
    /**
     * Show Matching text and image tutorial
     * @param event matchEvent is initialized
     * @throws IOException if error initialising Stage variable
     */
    public void switchToQuestionTypeMatching(ActionEvent event) throws IOException{
        //change text
        subtitle.setText("Matching");
        subtitle.setTextAlignment(TextAlignment.CENTER);
        Text text = new Text("Use your mouse to drag each answer to its corresponding question.\n" +
                "\n" +
                "Once you are confident with your answer, hit 'Submit'!");
        textflow.getChildren().clear();
        textflow.getChildren().add(text);
        textflow.setTextAlignment(TextAlignment.CENTER);
        //set button behaviours
        nextImg.setDisable(true);
        prevImg.setDisable(false);
        prevImg.setOnAction(fillEvent);
        //change circle colors
        circle1.setFill(unfocused);
        circle2.setFill(unfocused);
        circle3.setFill(focused);
        //change image
        Image image = new Image(new FileInputStream("src/main/resources/com/arcane/arithmetic/assets/imgs/puzzle.png"));
        imageView.setImage(image);
        imageView.setFitHeight(132);
        imageView.setFitWidth(126);
    }
    
    /**
     * Switch to the next tutorial scene
     * @param event The next button is pressed
     * @throws IOException if error initialising Stage variable
     */
    public void nextSlide(ActionEvent event) throws IOException{
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
