package com.example.games.model;

import com.example.games.GamesApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuModel {
    private static final int DIMENSIONS = 600;

    public void changeScene(ActionEvent event, String path, String title) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(GamesApplication.class.getResource("view/" + path)));
        Scene scene = new Scene(root, DIMENSIONS, DIMENSIONS);
        scene.setFill(Color.TRANSPARENT);

        scene.getStylesheets().add(Objects.requireNonNull(GamesApplication.class.getResource("css/style.css")).toExternalForm());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
   }

}
