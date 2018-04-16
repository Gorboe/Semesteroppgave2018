package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Enemy extends GameObject {

    public Enemy(ImageView imageView, Vector2D position, Rectangle bounds){
        super(imageView, position, bounds);
    }

    public void enemyMovement(Enemy enemy, Player player){
        final double enemySpeed = 1;

        if(player.getPosition().getX() > enemy.getPosition().getX()){
           //player.setVelocity();
            //enemy.set
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}
