package com.example.games.controller;

import com.example.games.model.MenuModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MenuController {

    private final MenuModel menu = new MenuModel();
    public Button single;
    public Button online;

    @FXML
    void onSinglePlay(ActionEvent event) {
        try {
            menu.changeScene(event, "single-view.fxml", "Single Tic-Tact-Toe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onOnlinePlay(ActionEvent event) {
        try {
            menu.changeScene(event, "online-view.fxml", "Online Tic-Tact-Toe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}