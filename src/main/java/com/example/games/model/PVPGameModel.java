package com.example.games.model;

import com.example.games.networking.NetworkUtils;
import javafx.scene.layout.VBox;

public class PVPGameModel {



    public static void hideWaitingBox(VBox waitingBox) {

        waitingBox.visibleProperty().bind(NetworkUtils.isBooleanProperty());
    }
}
