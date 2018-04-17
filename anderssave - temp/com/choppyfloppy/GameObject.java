package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public abstract class GameObject {

    private Vector2D position;
    private ImageView imageView;
    private Rectangle bounds;
    private int imageDelay = 0;
    private boolean alive = true;

    public GameObject(ImageView imageView, Vector2D position, Rectangle bounds){
        this.imageView = imageView;
        this.position = position;
        this.bounds = bounds;
    }

    public ImageView updateAnimation(ImageView imageView, String imagepath){
        if(imageDelay >= 1 && imageDelay <= 5){
            imageView.setImage(new Image(imagepath + "1.png"));
            imageDelay++;
        }else if(imageDelay >= 6 && imageDelay <= 10){
            imageView.setImage(new Image(imagepath + "2.png"));
            imageDelay++;
        }else if(imageDelay >= 11 && imageDelay <= 15){
            imageView.setImage(new Image(imagepath + "3.png"));
            imageDelay++;
        }else if(imageDelay >= 16 && imageDelay <= 20){
            imageView.setImage(new Image(imagepath + "4.png"));
            imageDelay++;
        }else{
            imageDelay = 1;
        }

        return imageView;
    }

    public ImageView getImageView(){return imageView;}
    public Rectangle getBounds(){return bounds;}
    public Vector2D getPosition(){return position;}
    public boolean isAlive(){
        return alive;
    }
    public boolean isDead(){
        return !alive;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }


    public boolean isColliding(GameObject other){

        //A = bullet, B = enemy
        //if(A-left < B-left og Aright < B-left eller A-left > B-right og A-right > B-right) return false
        //if(A-top < B-top og A-top < B-top eller A-top > B-bot og A-bot > B-bot) return false
        //all other conditions equals bounds crossed, return true

        if(getPosition().getX() < other.getPosition().getX() && getPosition().getX() + getBounds().getWidth() < other.getPosition().getX() || getPosition().getX() > other.getPosition().getX() + other.getBounds().getWidth() && getPosition().getX() + getBounds().getWidth() > other.getPosition().getX() + other.getBounds().getWidth()){
            return false;
        }else if(getPosition().getY() < other.getPosition().getY() && getPosition().getY() + getBounds().getHeight() < other.getPosition().getY() || getPosition().getY() > other.getPosition().getY() + other.getBounds().getHeight() && getPosition().getY() + getBounds().getHeight() > other.getPosition().getY() + other.getBounds().getHeight()){
            return false;
        }else

        return true;
    }

    public void update(){}

    public abstract void draw(GraphicsContext gc);
}
