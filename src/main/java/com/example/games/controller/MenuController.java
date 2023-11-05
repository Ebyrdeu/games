package com.example.games.controller;

import com.example.games.lib.utils.Log;
import com.example.games.lib.utils.Utils;
import javafx.fxml.FXML;

import java.io.IOException;

public class MenuController {

    @FXML
    void onSinglePlay() {
        try {
            Utils.changeScene("single-view.fxml", "Single player");
        } catch (IOException e) {
            Log.message("Error on single-view.fxml");
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onOnlinePlay() {
        try {
            Utils.changeScene("online-menu-view.fxml", "Multiplayer menu");
        } catch (IOException e) {
            Log.message("Error on online-menu-view.fxml");
            throw new RuntimeException(e);
        }
    }


}