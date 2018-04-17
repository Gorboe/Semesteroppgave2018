package com.choppyfloppy;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public abstract class GameEngine {

    private Canvas canvas;
    private AnimationTimer gameLoop;
    private int highscore;
    private int currentLevel;

    public GameEngine(GridPane parent, int width, int height){
        canvas = new Canvas(width, height);
        parent.getChildren().add(canvas);
        buildAndSetGameLoop();
    }

    public int getWidth(){return (int)canvas.getWidth();}
    public int getHeight(){return (int)canvas.getHeight();}

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getHighscore() {
        return highscore;
    }

    public AnimationTimer getGameLoop(){return gameLoop;}
    public Canvas getCanvas(){return canvas;}
    protected GraphicsContext getGraphicsContext() {
        return canvas.getGraphicsContext2D();
    }


    //AnimationTimer runs 60 times per second calls update() and draw()
    private void buildAndSetGameLoop(){
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                OnUpdate();
                draw();
            }
        };
        gameLoop.start();
    }

    protected abstract void OnUpdate();
    protected abstract void draw();
}
