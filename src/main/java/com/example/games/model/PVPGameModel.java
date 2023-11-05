package com.example.games.model;

import com.example.games.networking.Server;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.VBox;

public class PVPGameModel {

    private static final BooleanProperty booleanProperty = new SimpleBooleanProperty();

    public static void hideWaitingBox(VBox waitingBox) {
        booleanProperty.set(Server.getActiveConnectionsValues() != 2);
        waitingBox.visibleProperty().bind(booleanProperty);
    }
}
