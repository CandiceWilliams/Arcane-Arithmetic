package com.arcane.arithmetic;

import com.almasb.fxgl.time.TimerAction;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameTimer;

public class GameLoop {

    TimerCountdown timer = new TimerCountdown();
    DifficultyController diffCon = new DifficultyController();
    TopicController topicCon = new TopicController();
    private int questionsAnswered = 0, type = 1;
    private static final int TOTAL_QUESTIONS = 5;
    private String difficulty, topic;
    ObjectMapper objMapper = new ObjectMapper();
    Fill_Question fillQuestion = new Fill_Question();
    private int totalPts = 0;
    private Stage stage;
    private Scene scene;

    public void StartGameLoop(ActionEvent event) throws IOException {
        topic = topicCon.getTopic();
        difficulty = diffCon.getDiff();

        while(questionsAnswered != TOTAL_QUESTIONS){

            boolean isCorrect = false;
            String urlString = "http://127.0.0.1:5000/database/questions/get?subject="+topic+"&type=fb";
            //String urlString = "http://127.0.0.1:5000/database/questions/get?difficulty="+difficulty+"&type=mc&subject="+topic; proper api call
            //since we can't not have the type, we should instead have a random int type variable. It will cycle throw 3
            //random numbers 1, 2, 3. The number it lands on will be the type (assume 1 = mc, 2 = fill, 3 = match)
            //establish connection with database
            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                //get response code
                int responseCode = connection.getResponseCode();
                if (responseCode != 200){
                    throw new RuntimeException("HttpResponseCode: " + responseCode);
                }
                else{
                    String inline = "";
                    Scanner scanner = new Scanner(url.openStream());

                    //Write all JSON data into a string using a scanner
                    while(scanner.hasNext()){
                        inline += scanner.nextLine();
                    }

                    scanner.close();

                    fillQuestion = objMapper.readValue(url, Fill_Question.class);
                }
            }catch (IOException e) {
                System.out.println("Unable to establish valid connection to API");
                throw new RuntimeException(e);
            }

            if (type == 1){
                Parent root = FXMLLoader.load(getClass().getResource("view/FillInTheBlanks.fxml"));
                stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
                scene = new Scene(root);
                stage.show();

                FillInTheBlanksController fbController = new FillInTheBlanksController();
                isCorrect = fbController.displayQuestion(fillQuestion.getQuestion(), fillQuestion.getAnswer());
                if (isCorrect){
                    totalPts += 10;
                }
            }

            questionsAnswered++;



        }
    }



}

