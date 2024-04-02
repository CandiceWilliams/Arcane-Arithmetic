package com.arcane.arithmetic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This is the main game window that the user will see when first starting the game.
 * It extends the <a href="#{@Application}">{@link Application}</a> class.
 * <br></br>
 * <br></br>
 * @author Candice Williams
 * @author Justin Xu
 * @author Ming Chun Chan
 * @version 1.1.0
 * @see Application
 */
public class StartMenu extends Application {

    /**
     * Start loads the start menu which functions as the main game window. User will have access to:
     * <li>the tutorial,</li>
     * <li>the options menu,</li>
     * <li>the sign-in/sign-up popup</li>
     * <li>the exit button and,</li>
     * <li>the start game button</li>
     *
     * @author Ming Chun Chan
     * @author Candice Williams
     * @author Justin Xu
     * @param stage the primary stage used to display main game window
     * @throws IOException If error occured when loading FXML file.
     * @see javafx.fxml.FXML
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartMenu.class.getResource("view/StartMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Arcane Arithmetic");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        SettingsController.settingsCon.initSettings(stage);
        CheatsModePasswordPromptController.cheatsCon.initCheats();
    }

    /**
     * Main menu that launches the JavaFX game
     * @author Ming Chun Chan
     * @param args argument from cmd
     */
    public static void main(String[] args) {
        launch();
    }
}