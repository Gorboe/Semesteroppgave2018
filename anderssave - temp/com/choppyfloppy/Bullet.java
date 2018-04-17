package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Bullet extends GameObject{

    private double velocity;

    public Bullet(ImageView imageView, Vector2D position, Rectangle bounds){
        super(imageView, position, bounds);
    }

    public void update(double fixedDirectionX, double fixedDirectionY) {
        //getPosition().setX(getPosition().getX() + velocity * fixedDirectionX);
        //getPosition().setX(getPosition().getX() + velocity * fixedDirectionY);
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}
