package com.example.games.controller;

import com.example.games.GamesApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LayoutController {
    public AnchorPane layout;
    public Button close;
    public Button minimize;
    private double xOffset = 0, yOffset = 0;

    @FXML
    void initialize() {
        layout.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        layout.setOnMouseDragged(event -> {
            GamesApplication.primaryStage.setX(event.getScreenX() - xOffset);
            GamesApplication.primaryStage.setY(event.getScreenY() - yOffset);
        });
    }



    @FXML
    void onApplicationClose(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onApplicationMinimize(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
}
