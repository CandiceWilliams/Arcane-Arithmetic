package com.arcane.arithmetic;

import com.almasb.fxgl.time.TimerAction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameTimer;

public class GameLoop {

    TimerCountdown timer = new TimerCountdown();
    DifficultyController diffCon = new DifficultyController();
    TopicController topicCon = new TopicController();
    private int questionsAnswered = 0, type_int = 1;
    private static final int TOTAL_QUESTIONS = 5;
    private String difficulty, topic, type;
    ObjectMapper objMapper = new ObjectMapper();
    Fill_Question fillQuestion = new Fill_Question();
    MultipleChoice_Question multQuestion = new MultipleChoice_Question();
    private int totalPts = 0;
    private Stage stage;
    private Scene scene;


    public void StartGameLoop(ActionEvent event) throws IOException {
        topic = topicCon.getTopic();
        difficulty = diffCon.getDiff();
        System.out.println(difficulty);

        while(questionsAnswered != TOTAL_QUESTIONS){

            //picks random number from 1-2 (inclusive) representing the type of question. 1 = fill in the blank 2 = multiple choice
            type_int  = (int)Math.floor(Math.random() * (2 - 1 + 1) + 1);
            if (type_int == 1){type = "fb";}
            if(type_int == 2){type = "mc";}

            boolean isCorrect = false;

            //calls to API to store random question based on given parameters
            String urlString = "http://127.0.0.1:5000/database/questions/get?difficulty="+difficulty+"&type="+type+"&subject="+topic;


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
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder responseStrBuilder = new StringBuilder();

                    String inputStr;
                    //Scanner scanner = new Scanner(url.openStream());

                    //Write all JSON data into a string using a scanner
                    while((inputStr = reader.readLine()) != null){
                        responseStrBuilder.append((inputStr));
                    }

                    createQuestion(responseStrBuilder, type_int);

                    reader.close();
                    connection.disconnect();
                }
            }catch (IOException e) {
                System.out.println("Unable to establish valid connection to API");
                throw new RuntimeException(e);
            }

            if (type_int == 1){
                Parent root = FXMLLoader.load(getClass().getResource("view/FillInTheBlanks.fxml"));
                stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                System.out.println(fillQuestion.getQuestion());

                FillInTheBlanksController fbController = new FillInTheBlanksController();
                isCorrect = fbController.displayQuestion(fillQuestion.getQuestion(), fillQuestion.getAnswer());
                if (isCorrect){
                    totalPts += 10;
                }
            }

            if (type_int == 2){
                Parent root = FXMLLoader.load(getClass().getResource("view/MultipleChoice.fxml"));
                stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                System.out.println(multQuestion.getQuestion());

                MultipleChoiceController mcController = new MultipleChoiceController();
                isCorrect = mcController.displayQuestion(multQuestion.getQuestion(), multQuestion.getAnswer(), multQuestion.getOptions());
                if (isCorrect){
                    totalPts += 10;
                }
            }

            questionsAnswered++;
        }
    }

    public void createQuestion(StringBuilder strBuilder, int type) throws JsonProcessingException {
        if (type == 1){  //fill in the blank question format
            JsonNode json = objMapper.readTree(strBuilder.toString());
            String question = json.at("/question").toString();
            String answer = json.at("/answer").toString();
            String id = json.at("/question_id").toString();

            question = question.substring(1, question.length() - 1);
            answer = answer.substring(1, answer.length() - 1);

            fillQuestion.setQuestion(question);
            fillQuestion.setAnswer(answer);
            fillQuestion.setQuestion_id(Integer.parseInt(id));
        }

        if (type == 2){  //multiple choice question format
            JsonNode json = objMapper.readTree(strBuilder.toString());
            String question = json.at("/question").toString();
            String answer = json.at("/answer").toString();
            String id = json.at("/question_id").toString();
            String options = json.at("/options").toString();

            question = question.substring(1, question.length() - 1);
            answer = answer.substring(1, answer.length() - 1);

            multQuestion.setQuestion(question);
            multQuestion.setAnswer(answer);
            multQuestion.setQuestion_id(Integer.parseInt(id));
            multQuestion.setOptions(options);

        }
    }



}

