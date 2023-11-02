package com.example.games.controller;

import com.example.games.lib.utils.Log;
import com.example.games.lib.utils.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MenuController {
    public Button single;
    public Button online;

    @FXML
    void onSinglePlay() {
        try {
            Utils.changeScene("single-view.fxml");
        } catch (IOException e) {
            Log.error("Error on single-view.fxml");
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onOnlinePlay() {
        try {
            Utils.changeScene("online-menu-view.fxml");
        } catch (IOException e) {
            Log.error("Error on online-menu-view.fxml");
            throw new RuntimeException(e);
        }
    }


}