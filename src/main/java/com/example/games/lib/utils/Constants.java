package com.example.games.lib.utils;

public class Constants {

    public static final int WINDOW_HEIGHT = 635;

    public static final int WINDOW_WIDTH = 600;
    public static final int[][] WIN_CONDITIONS = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6},
    };

    private Constants() {
    }
}
