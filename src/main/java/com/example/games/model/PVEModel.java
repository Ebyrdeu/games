package com.example.games.model;

import com.example.games.lib.utils.Constants;
import javafx.scene.control.Button;

import java.util.List;
import java.util.Objects;


public class PVEModel {
    private PVEModel() {
    }

    public static boolean isTie(List<Button> btnList) {
        for (Button btn : btnList) {
            if (!btn.isDisabled() && btn.getText().isEmpty()) return false;
        }
        return true;
    }

    public static boolean isGameOver(List<Button> btnList, String playerSymbol) {
        return getWinningConditions(btnList, playerSymbol);
    }

    private static boolean isConditionMatched(String btnText, Button btn1, Button btn2, Button btn3) {
        return Objects.equals(btn1.getText(), btnText) &&
                Objects.equals(btn2.getText(), btnText) &&
                Objects.equals(btn3.getText(), btnText);
    }

    private static boolean getWinningConditions(List<Button> btnList, String btnText) {
        for (int[] winCon : Constants.WIN_CONDITIONS) {
            var btn1 = btnList.get(winCon[0]);
            var btn2 = btnList.get(winCon[1]);
            var btn3 = btnList.get(winCon[2]);

            if (isConditionMatched(btnText, btn1, btn2, btn3)) return true;
        }

        return false;
    }
}
