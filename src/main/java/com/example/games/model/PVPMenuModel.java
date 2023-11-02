package com.example.games.model;

import com.example.games.lib.utils.Log;
import com.example.games.lib.utils.Utils;
import com.example.games.networking.Client;
import com.example.games.networking.Server;

import java.io.IOException;

public class PVPMenuModel {

    public void hostServer() {
        Server.start();
        try {
            if (Server.isServerRunning()) Utils.changeScene("online-game-view.fxml");
        } catch (IOException e) {
            Log.error("Failed to change online-game-view.fxml");
            throw new RuntimeException(e);
        }
    }

    public void joinServer() {
        Client.start();
    }
}
