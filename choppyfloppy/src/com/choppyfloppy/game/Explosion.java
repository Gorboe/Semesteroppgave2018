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
     * @param imageView is used add a image and to make animations
     * @param position is used to select where the explosion should "land"
     * @param bounds is the GameObjects "hit-box". It is an invisible rectangle behind
     *               the actual visible image of the GameObject that when hit by another
     *               "hit-box" of another GameObject might do something. For example when
     *               a bullets "hit-box" hit an enemy "hit-box", both the single enemy and
     *               the single bullet are removed from the game-board. (see game logic for more)
     */
    public Explosion(ImageView imageView, Vector2D position, Rectangle bounds){
        super(imageView, position, bounds);
    }

    /**
     * This is used to keep track of how long the explosion should "live"
     * it only lives for 20 "ticks" because that is when the animation
     * is finished.
     * This could be improved, but right now we do not have the time to fix all
     * the things we are not happy about.
     */
    public void update() {
        lifeTimer++;
        if(lifeTimer >= 20){
            setAlive(false);
        }
    }

    /**
     * draws the explosion to the canvas.
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}
