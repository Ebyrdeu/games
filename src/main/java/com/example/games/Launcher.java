package com.example.games;

import com.example.games.lib.ui.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class Launcher extends Application {

    private static Stage primaryStage;

    private static Scene scene;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static Scene getScene() {
        return scene;
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view/menu-view.fxml")));

        Scene scene = getScene(root);
        getStage(stage, scene);
    }

    private static void getStage(Stage stage, Scene scene) {
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        primaryStage = stage;
        stage.show();
    }

    private Scene getScene(Parent root) {
        scene = new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        scene.setFill(Color.TRANSPARENT);

        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}