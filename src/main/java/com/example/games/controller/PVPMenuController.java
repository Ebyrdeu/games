package com.example.games.controller;

import com.example.games.model.PVPMenuModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PVPMenuController {
    private final PVPMenuModel pvpMenuModel = new PVPMenuModel();
    public TextField text;


    @FXML
    void onServerStart() {
        pvpMenuModel.hostServer();
    }

    @FXML
    void onServerJoin() {
        pvpMenuModel.joinServer();
    }
}
