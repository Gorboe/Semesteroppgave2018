package com.choppyfloppy.game;

import com.choppyfloppy.core.GameObject;
import com.choppyfloppy.core.Vector2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Bullet extends GameObject {

    private Vector2D velocity;
    private Rectangle screenBounds;
    private final int bulletSpeed = 10;

    public Bullet(ImageView imageView, Vector2D position, Rectangle bounds, Rectangle screenBounds){
        super(imageView, position, bounds);
        this.screenBounds = screenBounds;
    }

    public void setVelocity(Vector2D velocity){this.velocity = velocity;}

    public void update() {

        //bullet movement
        getPosition().setX(getPosition().getX() + velocity.getX() * bulletSpeed);
        getPosition().setY(getPosition().getY() + velocity.getY() * bulletSpeed);

        //logic for removing bullets outside the screen
        if(getPosition().getX() < 0 - getBounds().getWidth()){
            setAlive(false);
        }else if(getPosition().getX() > screenBounds.getWidth()){
            setAlive(false);
        }

        if(getPosition().getY() < 0 - getBounds().getHeight()){
            setAlive(false);
        }else if(getPosition().getY() > screenBounds.getHeight()){
            setAlive(false);
        }
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}
