package com.arcane.arithmetic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpScreen {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToSignUpScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/SignUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("css/SignUp.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Sign Up");
        stage.show();
    }
}
