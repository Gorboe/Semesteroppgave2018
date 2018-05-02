package com.choppyfloppy.core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * All GameObjects inherit from this class.
 */
public abstract class GameObject {

    private final Vector2D position;
    private final ImageView imageView;
    private final Rectangle bounds;
    private int imageDelay = 0;
    private boolean alive = true;
    private boolean freeze = false;
    private Map<String, Image> imageMap = new HashMap<>();

    /**
     * This is the constructor of the GameObject class
     * @param imageView takes an Image and makes it easy to create
     * @param position stores the GameObjects location on the game-board
     * @param bounds is the GameObjects "hit-box"
     */
    public GameObject(ImageView imageView, Vector2D position, Rectangle bounds){
        this.imageView = Objects.requireNonNull(imageView);
        this.position = Objects.requireNonNull(position);
        this.bounds = Objects.requireNonNull(bounds);
    }

    /**
     * This method checks if the image is already saved in the imageMap
     * or not. If it is already in the imageMap it will just return
     * the String location of the image back to the updateAnimation
     * method. If it is not in the imageMap a new Image will be created
     * and stored.
     * @param imagepath stores the string value of the image location
     */
    private Image getImage(String imagepath){
        if(!imageMap.containsKey(imagepath)){
            imageMap.put(imagepath, new Image(imagepath));
        }
        return imageMap.get(imagepath);
    }

    /**
     * This is used to update the animations of every GameObject
     * @param imageView takes an Image and makes it easy to create
     * simple GameAnimations.
     * @param imagepath stores the string value of the image location
     */
     public void updateAnimation(ImageView imageView, String imagepath){
        if(imageDelay >= 1 && imageDelay <= 5){
            imageView.setImage(getImage(imagepath + "1.png"));
            imageDelay++;
        }else if(imageDelay >= 6 && imageDelay <= 10){
            imageView.setImage(getImage(imagepath + "2.png"));
            imageDelay++;
        }else if(imageDelay >= 11 && imageDelay <= 15){
            imageView.setImage(getImage(imagepath + "3.png"));
            imageDelay++;
        }else if(imageDelay >= 16 && imageDelay <= 20){
            imageView.setImage(getImage(imagepath + "4.png"));
            imageDelay++;
        }else{
            imageDelay = 1;
        }
     }

    /**
     * Used to access the ImageView of the object.
     */
    protected ImageView getImageView(){
        return imageView;
    }

    /**
     * Used to access the object bounds. This is important for the
     * isColliding method.
     */
    protected Rectangle getBounds(){
        return bounds;
    }

    /**
     * Used to access the position Vector2D value. We can use this to
     * get the coordinates of for example the player.
     * We can for example type player.getPosition(); and it will return
     * two double values. x-coordinate and y-coordinate
     */
    public Vector2D getPosition(){
        return position;
    }

    public boolean isDead(){
        return !alive;
    }

    /**
     * Used to set the alive boolean value. If we want to remove an
     * Enemy from the game we can type: enemy.setAlive(false);
     * alive is true by default.
     * @param alive boolean value
     */
    public void setAlive(boolean alive){
        this.alive = alive;
    }

    /**
     * Used to set the freeze boolean value. If we want to freeze an
     * Enemy we can type: enemy.setFreeze(true);
     * freeze is false by default.
     * @param freeze boolean value
     */
    public void setFreeze(boolean freeze){
        this.freeze = freeze;
    }

    /**
     * Used to access the freeze boolean value. We can use this
     * to check if a GameObject is frozen or not.
     */
    protected boolean isFrozen(){
        return freeze;
    }

    /**
     * This method is used to check if GameObjects is colliding
     * with eachother. In Game class we type: enemy.isColliding(bullet)
     * this method will then check the bounds between the GameObject
     * enemy and the GameObject bullet, that is named "other".
     * @param other is another GameObject that you check against
     * in the example above, "other" is a bullet.
     */
    public boolean isColliding(GameObject other){
        if(getPosition().getX() < other.getPosition().getX() && getPosition().getX() + getBounds().getWidth() < other.getPosition().getX()){
            return false;
        }else if(getPosition().getX() > other.getPosition().getX() + other.getBounds().getWidth() && getPosition().getX() + getBounds().getWidth() > other.getPosition().getX() + other.getBounds().getWidth()){
            return false;
        }else if(getPosition().getY() < other.getPosition().getY() && getPosition().getY() + getBounds().getHeight() < other.getPosition().getY()){
            return false;
        }else if(getPosition().getY() > other.getPosition().getY() + other.getBounds().getHeight() && getPosition().getY() + getBounds().getHeight() > other.getPosition().getY() + other.getBounds().getHeight()){
            return false;
        }else
        return true;
    }

    /**
     * Is used by all the different GameObjects like
     * player, powerup, enemy, bullet. Is used to update
     * the movement, checking for screenbounds, keeping track
     * of how long powerups "live"
     */
    public void update(){}

    /**
     * Is used by all the different GameObjects like
     * player, powerup, enemy, bullet. Is used to draw
     * the different GameObjects to the canvas.
     */
    public abstract void draw(GraphicsContext gc);
}
