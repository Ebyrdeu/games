package com.example.games.controller.pvp;

import com.example.games.model.PVPGameModel;
import com.example.games.networking.NetworkUtils;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

public class PVPGameController {
    public Pane topBar;
    public VBox waitingBox;
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public Button btn5;
    public Button btn6;
    public Button btn7;
    public Button btn8;
    public Button btn9;
    public VBox restart;
    private Label gameStatus;
    private Label gameScore;
    private List<Button> btnList;

    private void onButtonClick(Button btn) {
        btn.setOnAction(e -> {
            // NOTE: only for testing later move to model
            if (NetworkUtils.getStatusOfOpponent()) {
                btn.setText("X");
                btn.setDisable(true);
            } else {
                btn.setText("O");
                btn.setDisable(true);
            }
        });
    }

    private void getLabels() {
        gameStatus = (Label) topBar.lookup("#gameStatus");
        gameScore = (Label) topBar.lookup("#gameScore");
    }

    @FXML
    void initialize() {
        btnList = List.of(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
        btnList.forEach(this::onButtonClick);

        Platform.runLater(() -> PVPGameModel.hideWaitingBox(waitingBox));
    }


    @FXML
    void onRestart() {
        btnList.forEach(btn -> {
            btn.setText("");
            btn.setDisable(false);
        });
        restart.setVisible(false);
        gameStatus.setText("");
    }
}
