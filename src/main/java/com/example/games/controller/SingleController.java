package com.example.games.controller;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SingleController implements Renderer {
    public Canvas canvas;

    public void initialize() {
        render();
    }


    @Override
    public void render() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setStroke(Color.web("#a4cbb4"));

    }
}
