package com.choppyfloppy.game;

import com.choppyfloppy.core.GameObject;
import com.choppyfloppy.core.Vector2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

/**
 * Contains logic for the bullet object, and updates the bullet.
 */
public class Bullet extends GameObject {

    private Vector2D velocity;
    private Rectangle screenBounds;

    /**
     * Bullet constructor is used to give the Bullet an image, position and boundaries.
     * Inherits from GameObject.
     *
     * @param imageView - Is used to attach an Image to the bullet.
     * @param position - Is used to give the Bullet a position.
     * @param bounds - is the GameObjects "hit-box". It is an invisible rectangle behind
     *               the actual visible image of the GameObject that when hit by another
     *               "hit-box" of another GameObject might do something. For example when
     *               a bullets "hit-box" hit an enemy "hit-box", both the single enemy and
     *               the single bullet are removed from the game-board. (see game logic for more)
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
     * @param velocity - is a variable that contains the speed of
     *                 the bullet.
     */
    public void setVelocity(Vector2D velocity){this.velocity = Objects.requireNonNull(velocity);}


    /**
     * updates the Bullets position.
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
     *  draws Bullets to the Canvas.
     *  Graphic Context uses drawImage to draw the Bullets Image and position.
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}
