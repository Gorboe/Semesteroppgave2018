package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Enemy extends GameObject {

    private boolean flipImage = false;

    public Enemy(ImageView imageView, Vector2D position, Rectangle bounds){
        super(imageView, position, bounds);
    }

    public void update(Enemy enemy, Player player) {

        //Movement logic
        final double velocity = 1;

        if(player.getPosition().getX() > enemy.getPosition().getX()){
            enemy.getPosition().addX(velocity);
        }else if(player.getPosition().getX() < enemy.getPosition().getX()){
            enemy.getPosition().addX(-velocity);
            flipImage = true;
        }

        if(player.getPosition().getY() > enemy.getPosition().getY()){
            enemy.getPosition().addY(velocity);
        }else if(player.getPosition().getY() < enemy.getPosition().getY()){
            enemy.getPosition().addY(-velocity);
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        if(flipImage){
            gc.drawImage(getImageView().getImage(), getPosition().getX() + getBounds().getWidth(), getPosition().getY(), -getBounds().getWidth(), getBounds().getHeight());
            flipImage = false;
        }else

        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}