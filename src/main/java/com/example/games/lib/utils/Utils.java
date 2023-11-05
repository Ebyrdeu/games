package com.example.games.lib.utils;

import com.example.games.Launcher;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class Utils {
    private Utils() {
    }

    public static void changeScene(String path, String title) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Launcher.class.getResource("view/" + path)));
        Launcher.getScene().setRoot(root);
        Launcher.getPrimaryStage().setTitle(title);
    }
}
