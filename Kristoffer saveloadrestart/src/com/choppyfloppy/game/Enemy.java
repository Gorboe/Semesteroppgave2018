package com.choppyfloppy.game;

import com.choppyfloppy.core.GameObject;
import com.choppyfloppy.core.Vector2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Enemy class contains the method to give the enemy object an image and position.
 * Contains logic for the enemy object, and updates the enemy position.
 */
public class Enemy extends GameObject {

    private boolean flipImage = false;

    /**
     * Enemy method is used to give the Enemy object an image, position and boundaries.
     * Inherits from GameObject.
     *
     * @param imageView - Is used to attach an Image to the bullet.
     * @param position - Is used to give the Bullet a position.
     * @param bounds - Is used to set bounds between objects to
     *               register collision.
     */
    public Enemy(ImageView imageView, Vector2D position, Rectangle bounds){
        super(imageView, position, bounds);
    }

    /**
     * Update is used to update the enemy position to
     * determine if there is a collision between objects.
     * The position of player will determine the movement of enemy object.
     *
     * @param player - Is used to determine the values of the player class,
     *               i.e. in case of collision between objects.
     */
    public void update(Player player) {

        if(isFrozen()){
            if(player.getPosition().getX() < getPosition().getX()){
                flipImage = true;
            }
            return;
        }

        //Movement logic
        final double velocity = 1;

        if(player.getPosition().getX() > getPosition().getX()){
            getPosition().addX(velocity);
        }else if(player.getPosition().getX() < getPosition().getX()){
            getPosition().addX(-velocity);
            flipImage = true;
        }

        if(player.getPosition().getY() > getPosition().getY()){
            getPosition().addY(velocity);
        }else if(player.getPosition().getY() < getPosition().getY()){
            getPosition().addY(-velocity);
        }
    }

    /**
     *  The method draw is used to draw Enemies to the Canvas.
     *  Graphic Context uses drawImage to draw the Enemys Image and position.
     *
     *  contains functions to draw enemy in different ways determined by
     *  the game play.
     */
    @Override
    public void draw(GraphicsContext gc) {
        if(isFrozen()){
            if(flipImage){
                gc.drawImage(new Image("com/choppyfloppy/resources/Frozen/frozenbird.png"), getPosition().getX() + getBounds().getWidth(), getPosition().getY(), -getBounds().getWidth(), getBounds().getHeight());
                return;
            }
            gc.drawImage(new Image("com/choppyfloppy/resources/Frozen/frozenbird.png"), getPosition().getX(), getPosition().getY());
            return;
        }
        if(flipImage){
            gc.drawImage(getImageView().getImage(), getPosition().getX() + getBounds().getWidth(), getPosition().getY(), -getBounds().getWidth(), getBounds().getHeight());
            flipImage = false;
        }else
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}
