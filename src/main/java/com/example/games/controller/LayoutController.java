package com.example.games.controller;

import com.example.games.Launcher;
import com.example.games.LogLauncher;
import com.example.games.lib.utils.Log;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LayoutController {
    public Button close;
    public Button minimize;
    public Pane menu;
    public Button logWindow;

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
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void onApplicationMinimize(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    void onLogWindowOpen() {
        LogLauncher logLauncher = new LogLauncher();
        try {
            logLauncher.openNewWindow();
        } catch (IOException e) {
            Log.error("onLogWindowOpen error: " + e.getMessage());
        }
    }
}
