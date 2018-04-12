package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Player extends GameObject {

    private Rectangle screenBounds;
    private double velocityX;
    private double velocityY;

    public Player(Sprite sprite, Vector2D position, Rectangle screenBounds){
        super(sprite, position);
        this.screenBounds = screenBounds;
        velocityX = 0;
        velocityY = 0;
    }

    public double getVelocityX(){return velocityX;}
    public double getVelocityY(){return velocityY;}
    public void setVelocityX(double velocityX){this.velocityX = velocityX;}
    public void setVelocityY(double velocityY){this.velocityY = velocityY;}

    public void update(){

        //checking x-axis bounds
        if(position.getX() < 0){
            position.setX(0);
        }else if(position.getX() > screenBounds.getWidth() - sprite.getBounds().getWidth()){
            position.setX(screenBounds.getWidth() - sprite.getBounds().getWidth());
        }

        //checking y-axis bounds
        if(position.getY() < 0){
            position.setY(0);
        }else if(position.getY() > screenBounds.getHeight() - sprite.getBounds().getHeight()){
            position.setY(screenBounds.getHeight() - sprite.getBounds().getHeight());
        }

        position.setX(position.getX() + velocityX);
        position.setY(position.getY() + velocityY);
    }

    @Override
    public void draw(GraphicsContext gc){
        gc.drawImage(sprite.getImage(), position.getX(), position.getY());
    }
}
