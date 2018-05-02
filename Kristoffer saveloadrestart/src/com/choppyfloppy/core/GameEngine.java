package com.choppyfloppy.core;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;

/**
 * This is where the canvas is added to the window.
 * The gameLoop is started when we create a
 * new instance of game.
 * The abstract methods OnUpdate and draw are created
 * so that we can use them in Game.
 */
public abstract class GameEngine {

    private Canvas canvas;
    private AnimationTimer gameLoop;

    /**
     * Constructor of the GameEngine class
     * @param parent used to add the canvas to the window
     * @param width used to set the width of the canvas
     * @param height used to set the height of the canvas
     */
    public GameEngine(GridPane parent, int width, int height){
        canvas = new Canvas(width, height);
        parent.getChildren().add(canvas);
        buildAndSetGameLoop();
    }

    /**
     * Is used to access the canvas width
     */
    public int getWidth(){
        return (int)canvas.getWidth();
    }

    /**
     * Is used to access the canvas height
     */
    public int getHeight(){
        return (int)canvas.getHeight();
    }

    /**
     * Is used to access the gameLoop
     */
    public AnimationTimer getGameLoop(){
        return gameLoop;
    }

    /**
     * Is used to access the canvas
     */
    public Canvas getCanvas(){
        return canvas;
    }

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
