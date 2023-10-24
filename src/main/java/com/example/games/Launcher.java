package com.example.games;

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

    public static final int WINDOW_SIZE = 600;
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
        Parent root = getRoot();
        Scene scene = getScene(root);
        getStage(stage, scene);
    }

    private Parent getRoot() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view/menu-view.fxml")));
        root.getStylesheets().add(Objects.requireNonNull(getClass().getResource("css/style.css")).toExternalForm());
        return root;
    }

    private static void getStage(Stage stage, Scene scene) {
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        primaryStage = stage;
        stage.show();
    }

    private Scene getScene(Parent root) {
        scene = new Scene(root, WINDOW_SIZE, WINDOW_SIZE);
        scene.setFill(Color.TRANSPARENT);

        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}