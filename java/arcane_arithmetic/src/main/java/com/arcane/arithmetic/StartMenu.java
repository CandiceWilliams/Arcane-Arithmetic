package com.arcane.arithmetic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

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

     * @param args argument from cmd
     */
    public static void main(String[] args) {
    	
    	// Create and start a new thread for api server
        Thread thread = new Thread(() -> {
            try {
            	Path currRelativePath = Paths.get("");
            	String currAbsolutePathString = currRelativePath.toAbsolutePath().toString();
            	System.out.println(currAbsolutePathString);
                String[] cmd = {
                        "cmd",
                        "/c",
                        "cd /d " + currAbsolutePathString + " && " +
                        "cd ../.. && " +
                        "cd python && " +
                        "python API.py"
                    };
            	// Execute command
            	ProcessBuilder pb= new ProcessBuilder(cmd);
            	pb.redirectErrorStream(true);
            	Process process = pb.start();
            	BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            	String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            	// Wait for the process to finish
                process.waitFor();
                
                // Get exit status
                int exitStatus = process.exitValue();
                System.out.println("Exit status: " + exitStatus);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        // Create and start another thread for gui launch
        Thread thread2 = new Thread(() -> {
        	launch();
        });

        thread.start();
        thread2.start();

        // Wait for the thread to finish
        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}