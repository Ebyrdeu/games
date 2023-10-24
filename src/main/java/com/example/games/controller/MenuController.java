package com.example.games.controller;

import com.example.games.Launcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Objects;

public class MenuController {
    public Button single;
    public Button online;

    private void changeScene(String path) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Launcher.class.getResource("view/" + path)));
        Launcher.getScene().setRoot(root);
    }

    @FXML
    void onSinglePlay() {
        try {
            changeScene("single-view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onOnlinePlay() {
        try {
            changeScene("online-view.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}