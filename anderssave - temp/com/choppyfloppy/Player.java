package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Player extends GameObject {

    private Rectangle screenBounds;
    private double velocity;

    public Player(Sprite sprite, Vector2D position, Rectangle screenBounds){
        super(sprite, position);
        this.screenBounds = screenBounds;
        velocity = 1;
    }

    public void update(){
        /*
        view.setTranslateX(view.getTranslateX() + velocity.getX());
        view.setTranslateY(view.getTranslateY() + velocity.getY());
        */
        position.addX(velocity);
    }

    @Override
    public void draw(GraphicsContext gc){
        gc.drawImage(sprite.getImage(), position.getX(), position.getY());
    }
}
