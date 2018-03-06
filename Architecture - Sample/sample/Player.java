package sample;

import javafx.scene.canvas.GraphicsContext;

public class Player extends GameObject{

    private double speed;

    //Constructor
    public Player(Sprite sprite, Vector2D position){
        super(sprite, position);
        speed = 1;
    }

    //updates 60 times a second
    public void update(){
        position.addX(speed); //sample. For keyboard input we need some sort of manager in Game.
    }

    @Override
    public void draw(GraphicsContext gc){
        gc.drawImage(sprite.getImage(), position.getX(), position.getY()); //draws our player
    }
}
