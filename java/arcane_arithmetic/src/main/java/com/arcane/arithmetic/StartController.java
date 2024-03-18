package com.arcane.arithmetic;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.*;


public class StartController {
    @FXML
    
    ImageView background;
    
    Image backgroundImage = new Image(getClass().getResourceAsStream("arcane_arithmetic_startmenu_bg"));
    
    public void displayImage(){
    	background.setImage(backgroundImage);
    	}
}