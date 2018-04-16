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

    public void update(){}

    public abstract void draw(GraphicsContext gc);
}
