package com.example.games.controller;


import com.example.games.LogLauncher;
import com.example.games.lib.utils.Log;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogController {
    public HBox logMenu;
    public Text text;

    private double xOffset = 0, yOffset = 0;

    private void onWindowDrag() {
        logMenu.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        logMenu.setOnMouseDragged(event -> {
            LogLauncher.getPrimaryStage().setX(event.getScreenX() - xOffset);
            LogLauncher.getPrimaryStage().setY(event.getScreenY() - yOffset);
        });
    }

    private void logs() {
        try (var inputStream = getClass().getResourceAsStream("/logs/logs.log")) {
            if (inputStream == null) return;

            var reader = new BufferedReader(new InputStreamReader(inputStream));
            var stringBuilder = new StringBuilder();

            for (String line; (line = reader.readLine()) != null; ) {
                stringBuilder.append(line).append('\n');
            }

            text.setText(stringBuilder.toString());
            reader.close();
        } catch (IOException e) {
            Log.message("Error on Log Load: " + e.getMessage());
        }
    }

    @FXML
    void initialize() {
        onWindowDrag();
        logs();
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

}
