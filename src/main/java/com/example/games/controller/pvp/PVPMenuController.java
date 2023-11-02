package com.example.games.controller.pvp;

import com.example.games.lib.utils.Log;
import com.example.games.lib.utils.Utils;
import com.example.games.networking.Client;
import com.example.games.networking.Server;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PVPMenuController {
    public Button joinServer;
    public TextField joinText;


    private void gameScene() {
        try {
            if (Server.isServerRunning()) Utils.changeScene("online-game-view.fxml");
        } catch (IOException e) {
            Log.error("Failed to change online-game-view.fxml");
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onServerStart() {
        Server.start();
        gameScene();
    }

    @FXML
    void onServerJoin() {
        if (joinText.getText().isEmpty()) {
            joinText.setVisible(true);
            joinServer.setText("Join Game ");
            return;
        }
        Client.start(joinText.getText());
        gameScene();
    }
}
