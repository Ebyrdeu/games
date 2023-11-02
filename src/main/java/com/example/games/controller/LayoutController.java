package com.example.games.controller;

import com.example.games.Launcher;
import com.example.games.LogLauncher;
import com.example.games.lib.utils.Log;
import com.example.games.lib.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LayoutController {
    public Pane menu;
    private double xOffset = 0, yOffset = 0;

    private void onWindowDrag() {
        menu.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        menu.setOnMouseDragged(event -> {
            Launcher.getPrimaryStage().setX(event.getScreenX() - xOffset);
            Launcher.getPrimaryStage().setY(event.getScreenY() - yOffset);
        });
    }

    @FXML
    void initialize() {
        onWindowDrag();
    }


    @FXML
    void onApplicationClose(ActionEvent event) {
        var stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onApplicationMinimize(ActionEvent event) {
        var stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void onLogWindowOpen() {
        var logLauncher = new LogLauncher();
        try {
            logLauncher.openNewWindow();
        } catch (IOException e) {
            Log.error("onLogWindowOpen error: " + e.getMessage());
        }
    }

    @FXML
    void onBackToMainMenu() {
        try {
            Utils.changeScene("menu-view.fxml");
        } catch (IOException e) {
            Log.error("Error on menu-view.fxml");
            throw new RuntimeException(e);
        }
    }
}
