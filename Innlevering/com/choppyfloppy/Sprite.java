package com.choppyfloppy;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Sprite {

    private String name;
    private Rectangle bounds;
    private Image image;

    public Sprite(String name, Image image, Rectangle bounds){
        this.name = name;
        this.image = image;
        this.bounds = bounds;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
