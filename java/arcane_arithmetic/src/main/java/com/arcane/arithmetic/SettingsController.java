package com.arcane.arithmetic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsController {
    private Stage window = new Stage();
    private Scene scene;
    @FXML
    private AnchorPane pane;

    private String css = this.getClass().getResource("css/settings.css").toExternalForm();

    public void startSettings(ActionEvent event) throws IOException {
        window.initModality(Modality.APPLICATION_MODAL);
        window.resizableProperty().setValue(Boolean.FALSE);
        pane = (AnchorPane) FXMLLoader.load(getClass().getResource("view/Settings.fxml"));
        scene = new Scene(pane);
        scene.getStylesheets().add(css);
        window.setScene(scene);
        window.showAndWait();

    }
}
