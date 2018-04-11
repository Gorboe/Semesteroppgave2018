package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject {

    protected Sprite sprite;
    protected Vector2D position;

    public GameObject(Sprite sprite, Vector2D position){
        this.sprite = sprite;
        this.position = position;
    }

    public void update(){}

    public abstract void draw(GraphicsContext gc);
}
