package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class PowerUp extends GameObject {

    private int lifeTimer = 0;

    public PowerUp(ImageView imageView, Vector2D position, Rectangle bounds){
        super(imageView, position, bounds);
    }

    public void update() {
        lifeTimer++;
        if(lifeTimer >= 600){
            setAlive(false);
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}

