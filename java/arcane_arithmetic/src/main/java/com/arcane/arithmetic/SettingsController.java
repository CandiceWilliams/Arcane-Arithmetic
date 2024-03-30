package com.arcane.arithmetic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.io.File;

public class SettingsController {
    public static SettingsController settingsCon = new SettingsController();
    private static Stage startMenuStage;
    private static Stage window = new Stage();
    private Scene scene;

    private static boolean soundOn = true, musicOn = true, fullScreenOn = false;

    @FXML private AnchorPane pane;
    @FXML private CheckBox soundCheckBox, musicCheckBox, fullScreenCheckBox;

    private final String css = SettingsController.class.getResource("css/settings.css").toExternalForm();

    private static final String backgroundMusicFilePath =
            SettingsController.class.getResource("assets/sounds/relaxed-vlog-night-street-131746.mp3").getPath();
    private static final Media backgroundMusicMedia = new Media(new File(backgroundMusicFilePath).toURI().toString());
    private static final MediaPlayer backgroundMediaPlayer = new MediaPlayer(backgroundMusicMedia);


    private static final String buttonClickSoundFilePath =
            SettingsController.class.getResource("assets/sounds/click-button-140881.mp3").getPath();
    private static final Media buttonClickSoundMedia = new Media(new File(buttonClickSoundFilePath).toURI().toString());
    private static final MediaPlayer buttonClickSoundMediaPlayer = new MediaPlayer(buttonClickSoundMedia);


    public void initSettings(Stage startMenuStage) throws IOException {
        storeStartMenuStage(startMenuStage);
        window.initModality(Modality.APPLICATION_MODAL);
        window.resizableProperty().setValue(Boolean.FALSE);
        pane = (AnchorPane) FXMLLoader.load(getClass().getResource("view/Settings.fxml"));
        scene = new Scene(pane);
        scene.getStylesheets().add(css);
        window.setScene(scene);
        playMusic();
    }

    public void startSettings(ActionEvent event) {
        window.showAndWait();
    }

    public void soundCheckBoxClick(){
        soundOn = soundCheckBox.isSelected();
        loadSound();
    }

    public void loadSound(){
        // call this method whenever a button is pressed from another class
        if (soundOn) {
            playSound();
        }
    }

    public void playSound(){
        boolean playing = buttonClickSoundMediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING);
        if (playing) buttonClickSoundMediaPlayer.stop();
        buttonClickSoundMediaPlayer.play();
        buttonClickSoundMediaPlayer.setOnEndOfMedia(buttonClickSoundMediaPlayer::stop);
    }


    public void musicCheckBoxClick(){
        loadSound();
        musicOn = musicCheckBox.isSelected();
        loadMusic();
    }

    public void loadMusic(){
        if (musicOn){
            playMusic();
        }
        else {
            backgroundMediaPlayer.stop();
        }
    }

    public void playMusic(){
        backgroundMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        backgroundMediaPlayer.play();
    }

    public void fullScreenCheckBoxClick(){
        loadSound();
        fullScreenOn = fullScreenCheckBox.isSelected();
        loadFullScreen();
    }

    public void loadFullScreen(){
        if(fullScreenOn) {
            if (startMenuStage.isMaximized()) startMenuStage.setMaximized(false);
            startMenuStage.setMaximized(true);
        } else {
            startMenuStage.setMaximized(false);
        }
    }

    public void back(ActionEvent event) {
        SettingsController.settingsCon.loadSound();
        window.close();
    }

    public static void storeStartMenuStage(Stage startMenuStage){
        SettingsController.startMenuStage = startMenuStage;
    }
}