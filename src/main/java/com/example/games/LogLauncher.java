package com.example.games;

import com.example.games.lib.utils.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class LogLauncher extends Application {
    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        openNewWindow();
    }

    public void openNewWindow() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view/log-view.fxml")));

        var scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        scene.setFill(Color.TRANSPARENT);

        var stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.setTitle("Log menu");
        primaryStage = stage;
        stage.show();
    }
}
