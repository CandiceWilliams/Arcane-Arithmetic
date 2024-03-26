package com.arcane.arithmetic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SignInController {

    public Label signInLabel;
    public Label usernameLabel;
    public Label passwordLabel;
    public Label dontHaveAccountLabel;
    public Button loginButton;

    public void switchToSignUpScene(ActionEvent event) throws IOException {
        SignUpScreen tmp = new SignUpScreen();
        tmp.switchToSignUpScene(event);
    }

    public void signInButtonClick(ActionEvent event) throws IOException {

    }
}