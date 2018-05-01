package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Explotion extends GameObject {

    private int lifeTimer = 0;

    public Explotion(ImageView imageView, Vector2D position, Rectangle bounds){
        super(imageView, position, bounds);
    }

    public void update() {
        lifeTimer++;
        if(lifeTimer >= 20){
            setAlive(false);
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}
