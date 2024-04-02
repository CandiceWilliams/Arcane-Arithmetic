package com.arcane.arithmetic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.IOException;
import java.io.File;

/**
 * This class is used to control various user settings. Settings include:
 * <li>sound effects toggle,</li>
 * <li>music toggle and,</li>
 * <li>full screen toggle</li>
 *
 * @author JustinXu
 */
public class SettingsController {
    public static SettingsController settingsCon = new SettingsController();
    private static Stage startMenuStage;
    private static Stage window = new Stage();
    private Scene scene;

    private static boolean soundOn = true, musicOn = true, fullScreenOn = false;

    @FXML private AnchorPane pane;
    @FXML private CheckBox soundCheckBox, musicCheckBox, fullScreenCheckBox;

    private final String css = SettingsController.class.getResource("css/settings.css").toExternalForm();
    private static final String backgroundMusicFilePath = "assets/sounds/relaxed-vlog-night-street-131746.mp3";
    private static final Media backgroundMusicMedia = new Media(SettingsController.class.getResource(backgroundMusicFilePath).toString());
    private static final MediaPlayer backgroundMediaPlayer = new MediaPlayer(backgroundMusicMedia);


    private static final String buttonClickSoundFilePath = "assets/sounds/click-button-140881.mp3";
    private static final Media buttonClickSoundMedia = new Media(SettingsController.class.getResource(buttonClickSoundFilePath).toString());
    private static final MediaPlayer buttonClickSoundMediaPlayer = new MediaPlayer(buttonClickSoundMedia);


    /**
     * Initialize the Settings menu and set modality
     * @param startMenuStage stores start menu stage so user can navigate back to it once finished
     * @throws IOException if Stage variable is initialised incorrectly
     */
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

    /**
     * Listener for when the settings button is pressed
     * @param event settings button is pressed
     */
    public void startSettings(ActionEvent event) {
        window.showAndWait();
    }

    /**
     * UI checkbox that toggles sfx on and off
     * @see CheckBox
     */
    public void soundCheckBoxClick(){
        soundOn = soundCheckBox.isSelected();
        loadSound();
    }

    /**
     *UI checkbox that plays sound if true
     * @see CheckBox
     * @see #playSound()
     */
    public void loadSound(){
        // call this method whenever a button is pressed from another class
        if (soundOn) {
            playSound();
        }
    }

    /**
     * Starts and stops the UI sounds from being played
     * @see MediaPlayer
     */
    public void playSound(){
        boolean playing = buttonClickSoundMediaPlayer.getStatus().equals(MediaPlayer.Status.PLAYING);
        if (playing) buttonClickSoundMediaPlayer.stop();
        buttonClickSoundMediaPlayer.play();
        buttonClickSoundMediaPlayer.setOnEndOfMedia(buttonClickSoundMediaPlayer::stop);
    }


    /**
     * UI checkbox that toggles music on and off
     */
    public void musicCheckBoxClick(){
        loadSound();
        musicOn = musicCheckBox.isSelected();
        loadMusic();
    }
    /**
     * Plays music if music not on. If music is on, stops music
     * @see MediaPlayer
     */
    public void loadMusic(){
        if (musicOn){
            playMusic();
        }
        else {
            backgroundMediaPlayer.stop();
        }
    }
    
    /**
     *Loops music indefinitely
     * @see MediaPlayer
     */
    public void playMusic(){
        backgroundMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        backgroundMediaPlayer.play();
    }

    /**
     * UI checkbox that toggles full screen on and off
     * @see CheckBox;
     */
    public void fullScreenCheckBoxClick(){
        loadSound();
        fullScreenOn = fullScreenCheckBox.isSelected();
        loadFullScreen();
    }
    
    /**
     *Loads full screen preferences
     * @see #fullScreenCheckBoxClick()
     */
    public void loadFullScreen(){
        if(fullScreenOn) {
            if (startMenuStage.isMaximized()) startMenuStage.setMaximized(false);
            startMenuStage.setMaximized(true);
        } else {
            startMenuStage.setMaximized(false);
        }
    }

    /**
     * Close settings menu
     * @param event back button is pressed
     */
    public void back(ActionEvent event) {
        SettingsController.settingsCon.loadSound();
        window.close();
    }
    
    /**
     * Open Instructor Dashboard Password Prompt
     * @param event Instructor Dashboard button is pressed
     * @throws IOException if Stage variable not initialised correctly
     */
    public void switchToInstructorPasswordPrompt(ActionEvent event) throws IOException {
        SettingsController.settingsCon.loadSound();
        window.close();
        InstructorPasswordPromptController instructCon = new InstructorPasswordPromptController();
        instructCon.popUpWindow(startMenuStage);
    }

    /**
     * Open Cheats Mode Password Prompt
     * @param event Cheats Mode button is pressed
     * @throws IOException if Stage variable not initialised correctly
     */
    public void switchToCheatsModePasswordPrompt(ActionEvent event) throws IOException {
        SettingsController.settingsCon.loadSound();
        window.close();
        CheatsModePasswordPromptController cheatsCon = new CheatsModePasswordPromptController();
        cheatsCon.popUpWindow();
    }

    /**
     * Stores start menu stage
     * @param startMenuStage the start menu (main game window)
     */
    public static void storeStartMenuStage(Stage startMenuStage){
        SettingsController.startMenuStage = startMenuStage;
    }
}
