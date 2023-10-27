package com.example.games.model;

import com.example.games.lib.ui.Constants;
import com.example.games.lib.ui.GameStatus;
import javafx.scene.control.Button;

import java.util.List;


public class PVEModel {

    public static boolean isTie(List<Button> btnList) {
        for (Button btn : btnList) {
            if (!btn.isDisabled() && btn.getText().isEmpty()) return false;
        }
        return true;
    }

    public static boolean isGameOver(List<Button> btnList, String playerSymbol) {
        return getWinningConditions(btnList, playerSymbol) == GameStatus.OVER;
    }

    private static boolean isConditionMatched(String btnText, Button btn1, Button btn2, Button btn3) {
        return btn1.getText().equals(btnText) && btn2.getText().equals(btnText) && btn3.getText().equals(btnText);
    }

    private static GameStatus getWinningConditions(List<Button> btnList, String btnText) {
        for (int[] winCon : Constants.WIN_CONDITIONS) {
            int winByRows = winCon[0];
            int winByColumns = winCon[1];
            int winByDiagonals = winCon[2];

            var btn1 = btnList.get(winByRows);
            var btn2 = btnList.get(winByColumns);
            var btn3 = btnList.get(winByDiagonals);

            if (isConditionMatched(btnText, btn1, btn2, btn3)) return GameStatus.OVER;
        }

        return GameStatus.RUNNING;
    }
}
