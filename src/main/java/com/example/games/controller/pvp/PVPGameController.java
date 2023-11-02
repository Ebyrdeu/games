package com.example.games.controller.pvp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

public class PVPGameController {
    public Pane topBar;
    public VBox waitingBox;
    private List<Button> btnList;
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


    @FXML
    void initialize() {
        btnList = List.of(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
    }


    @FXML
    void onRestart() {
    }
}
