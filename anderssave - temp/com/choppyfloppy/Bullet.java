package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Bullet extends GameObject{

    private double velocity = 5;

    public Bullet(ImageView imageView, Vector2D position, Rectangle bounds){
        super(imageView, position, bounds);
    }

    private Vector2D subVector(Vector2D vector1, Vector2D vector2){
        double newVectorX = vector2.getX() - vector1.getX();
        double newVectorY = vector2.getY() - vector1.getY();
        return new Vector2D(newVectorX, newVectorY);
    }

    public void update(Vector2D playerPosition, Vector2D mousePosition) {
        Vector2D aimDirection;
        aimDirection = subVector(playerPosition, mousePosition);
        double fixedDirectionX = aimDirection.getX() / Math.sqrt(Math.pow(aimDirection.getX(), 2) + Math.pow(aimDirection.getY(), 2));
        double fixedDirectionY = aimDirection.getY() / Math.sqrt(Math.pow(aimDirection.getX(), 2) + Math.pow(aimDirection.getY(), 2));


        getPosition().setX(getPosition().getX() + velocity * fixedDirectionX);
        getPosition().setY(getPosition().getY() + velocity * fixedDirectionY);
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}
