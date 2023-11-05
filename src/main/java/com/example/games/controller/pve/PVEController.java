package com.example.games.controller.pve;

import com.example.games.model.PVEModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.Random;

public class PVEController {
    public VBox restart;
    public Pane topBar;
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public Button btn5;
    public Button btn6;
    public Button btn7;
    public Button btn8;
    public Button btn9;
    private Label gameStatus;
    private Label gameScore;
    private List<Button> btnList;
    private int playerScore = 0;
    private int computerScore = 0;

    private void getLabels() {
        gameStatus = (Label) topBar.lookup("#gameStatus");
        gameScore = (Label) topBar.lookup("#gameScore");
    }

    private void setMove(Button btn, String symbol) {
        btn.setText(symbol);
        btn.setDisable(true);
        setGameOver();
    }

    private void setComputeMove(List<Button> btnList) {
        var availableBtns = btnList.stream().filter(btn -> !btn.isDisabled()).toList();

        if (availableBtns.isEmpty()) return;

        var ComputerBtn = availableBtns.get(new Random().nextInt(availableBtns.size()));

        setMove(ComputerBtn, "O");
    }

    private void setGameOver() {
        if (PVEModel.isGameOver(btnList, "X")) {
            playerScore++;
            gameOverStatuses("You Won!");
        } else if (PVEModel.isGameOver(btnList, "O")) {
            computerScore++;
            gameOverStatuses("You Lost!");
        } else if (PVEModel.isTie(btnList)) {
            gameOverStatuses("It's a Tie!");
        }

        gameScore.setText(playerScore + ":" + computerScore);
    }

    private void gameOverStatuses(String winner) {
        btnList.forEach(btn -> btn.setDisable(true));
        gameStatus.setText(winner);
        restart.setVisible(true);
    }

    @FXML
    void initialize() {
        btnList = List.of(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
        btnList.forEach(this::onBtnClick);
        getLabels();
    }

    @FXML
    void onBtnClick(Button btn) {
        btn.setOnAction(e -> {
            setMove(btn, "X");
            setComputeMove(btnList);
        });
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
