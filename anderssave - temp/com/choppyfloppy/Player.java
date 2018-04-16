package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Player extends GameObject {

    private Rectangle screenBounds;
    private double velocityX = 0;
    private double velocityY = 0;

    public Player(ImageView imageView, Vector2D position, Rectangle bounds, Rectangle screenBounds){
        super(imageView, position, bounds);
        this.screenBounds = screenBounds;
    }

    public double getVelocityX(){return velocityX;}
    public double getVelocityY(){return velocityY;}
    public void setVelocityX(double velocityX){this.velocityX = velocityX;}
    public void setVelocityY(double velocityY){this.velocityY = velocityY;}
    public void setVelocity(double velocityX, double velocityY){this.velocityX = velocityX; this.velocityY = velocityY;}

    public void update(){

        //checking x-axis bounds
        if(getPosition().getX() < 0){
            getPosition().setX(0);
        }else if(getPosition().getX() > screenBounds.getWidth() - getBounds().getWidth()){
            getPosition().setX(screenBounds.getWidth() - getBounds().getWidth());
        }

        //checking y-axis bounds
        if(getPosition().getY() < 0){
            getPosition().setY(0);
        }else if(getPosition().getY() > screenBounds.getHeight() - getBounds().getHeight()){
            getPosition().setY(screenBounds.getHeight() - getBounds().getHeight());
        }

        getPosition().setX(getPosition().getX() + velocityX);
        getPosition().setY(getPosition().getY() + velocityY);
    }

    @Override
    public void draw(GraphicsContext gc){
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}
