package com.choppyfloppy.game;

import com.choppyfloppy.core.GameObject;
import com.choppyfloppy.core.Vector2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

/**
 * Bullet class contains the method to give the bullet image and position.
 * Contains logic for the bullet object, and updates the bullet.
 */
public class Bullet extends GameObject {

    private Vector2D velocity;
    private Rectangle screenBounds;

    /**
     * Bullet method is used to give the Bullet an image, position and boundaries.
     * Inherits from GameObject.
     *
     * @param imageView - Is used to attach an Image to the bullet.
     * @param position - Is used to give the Bullet a position.
     * @param bounds - Is used to set bounds between objects to
     *               register collision.
     * @param screenBounds - Is used to set the outer bounds for the
     *                     bullet. Bullet will be removed if it goes out of
     *                     bounds.
     */
    public Bullet(ImageView imageView, Vector2D position, Rectangle bounds, Rectangle screenBounds){
        super(imageView, position, bounds);
        this.screenBounds = Objects.requireNonNull(screenBounds);
    }

    /**
     * setVelocity is used to set a value to the velocity variable.
     *
     * @param velocity - is a varible that contains the speed of
     *                 the bullet.
     */
    public void setVelocity(Vector2D velocity){this.velocity = Objects.requireNonNull(velocity);}


    /**
     * The method Update will update the Bullets position.
     *
     * If the position of the bullet is greater than the
     * boundaries of the canvas, update method will remove
     * the object.
     */
    public void update() {
        final int bulletSpeed = 10;

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

    /**
     *  The method draw is used to draw Bullets to the Canvas.
     *  Graphic Context uses drawImage to draw the Bullets Image and position.
     */
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}
