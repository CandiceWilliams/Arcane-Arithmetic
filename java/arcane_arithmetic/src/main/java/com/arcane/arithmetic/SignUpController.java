package com.arcane.arithmetic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SignUpController {

    public Label signUpLabel;
    public Label usernameLabel;
    public Label passwordLabel;
    public Label passwordConfirmationLabel;
    public Button signUpButton, backToSignInScreenButton;

    public void switchToSignInScene(ActionEvent event) throws IOException {
        SignInScreen tmp = new SignInScreen();
        tmp.switchToSignInScene(event);
    }

    public void signUpButtonClick(ActionEvent event) throws IOException {

    }
}