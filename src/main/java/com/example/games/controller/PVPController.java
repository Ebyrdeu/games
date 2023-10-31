package com.example.games.controller;

import com.example.games.networking.Server;
import javafx.scene.control.TextField;

public class PVPController {
    public TextField text;

    public void onServerStart() {
        Server.start("8000");
    }


    public void onServerJoin() {
    }
}
