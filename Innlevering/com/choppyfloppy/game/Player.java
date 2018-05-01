package com.choppyfloppy.game;

import com.choppyfloppy.core.GameObject;
import com.choppyfloppy.core.Vector2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;


public class Player extends GameObject {

    private Rectangle screenBounds;
    private double velocity = 5;
    private boolean rightActive, leftActive, upActive, downActive = false;

    public Player(ImageView imageView, Vector2D position, Rectangle bounds, Rectangle screenBounds){
        super(imageView, position, bounds);
        this.screenBounds = screenBounds;
    }

    public void keyPressedEvent(KeyEvent e){
        if(e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D){
            rightActive = true;
        }else if(e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.A){
            leftActive = true;
        }

        if(e.getCode() == KeyCode.UP || e.getCode() == KeyCode.W){
            upActive = true;
        }else if(e.getCode() == KeyCode.DOWN || e.getCode() == KeyCode.S){
            downActive = true;
        }
    }

    public void keyReleasedEvent(KeyEvent e){
        if(e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D){
            rightActive = false;
        }else if(e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.A){
            leftActive = false;
        }

        if(e.getCode() == KeyCode.UP || e.getCode() == KeyCode.W){
            upActive = false;
        }else if(e.getCode() == KeyCode.DOWN || e.getCode() == KeyCode.S){
            downActive = false;
        }
    }

    public void update(Scene scene){

        scene.setOnKeyPressed(this::keyPressedEvent);
        scene.setOnKeyReleased(this::keyReleasedEvent);

        //movement
        if(rightActive){
            getPosition().setX(getPosition().getX() + velocity);
        }else if(leftActive){
            getPosition().setX(getPosition().getX() + -velocity);
        }

        if(upActive){
            getPosition().setY(getPosition().getY() + -velocity);
        }else if(downActive){
            getPosition().setY(getPosition().getY() + velocity);
        }

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
    }

    @Override
    public void draw(GraphicsContext gc){
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}
