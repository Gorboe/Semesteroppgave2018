package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Enemy extends GameObject {

    private ImageView imageView;
    private Vector2D position;
    private Rectangle bounds;

    public Enemy(ImageView imageView, Vector2D position, Rectangle bounds){
        super(imageView, position, bounds);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}
