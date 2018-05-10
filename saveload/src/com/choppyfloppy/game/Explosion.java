package com.choppyfloppy.game;

import com.choppyfloppy.core.GameObject;
import com.choppyfloppy.core.Vector2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Explosion should really not be a GameObject, but
 * we choose to do it like this, because it was
 * faster to implement. A new Explosion is created
 * whenever a enemy is hit by a bullet or when
 * the player is hit by an enemy. It is a short animation
 * of an explosion.
 */
public class Explosion extends GameObject {

    private int lifeTimer = 0;

    /**
     * This is the constructor
     * @param imageView is used to make animations
     * @param position is used to select where the explosion should "land"
     * @param bounds is the "hit-box" of the powerup.
     */
    public Explosion(ImageView imageView, Vector2D position, Rectangle bounds){
        super(imageView, position, bounds);
    }

    /**
     * This is used to keep track of how long the explosion should "live"
     * it only lives for 20 "ticks" because that is when the animation
     * is finished.
     */
    public void update() {
        lifeTimer++;
        if(lifeTimer >= 20){
            setAlive(false);
        }
    }

    /**
     * draw is used to draw the explosion to the canvas.
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}
