package com.example.games.controller;

import com.example.games.Launcher;
import com.example.games.lib.utils.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    void onLogWindowOpen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("view/log-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}
