package com.example.games.controller;

import com.example.games.GamesApplication;
import com.example.games.model.MenuModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuController {
    public Button single;
    public Button online;

    private static final int DIMENSIONS = 600;

    public void changeScene(ActionEvent event, String path, String title) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GamesApplication.class.getResource("view/" + path)));
        Scene scene = new Scene(root, DIMENSIONS, DIMENSIONS);
        scene.setFill(Color.TRANSPARENT);

        scene.getStylesheets().add(Objects.requireNonNull(GamesApplication.class.getResource("css/style.css")).toExternalForm());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onSinglePlay(ActionEvent event) {
        try {
            changeScene(event, "single-view.fxml", "Single Tic-Tact-Toe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onOnlinePlay(ActionEvent event) {
        try {
            changeScene(event, "online-view.fxml", "Online Tic-Tact-Toe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}