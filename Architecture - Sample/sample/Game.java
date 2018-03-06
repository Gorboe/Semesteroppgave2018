package sample;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public class Game extends GameEngine{

    private Player player;

    //scene for later. need Input manager.
    public Game(GridPane parent, Scene scene, int width, int height){
        super(parent,width,height);
        loadResources();
    }

    private void loadResources(){
        createGameObjects();
        createPlayer();
    }

    private void createPlayer(){
        Image p1Image = new Image(getClass().getResourceAsStream("player.png"));
        Sprite p1Sprite = new Sprite("Player", p1Image);
        player = new Player(p1Sprite, Vector2D.Zero());
        System.out.println("Creates player");
    }

    private void createGameObjects(){
        System.out.println("No other game objects yet");
    }

    //draws 60 times a second
    protected void draw(){
        GraphicsContext gc = getGraphicsContext();

        gc.fillText("blablabla", 500, 500); //test

        player.draw(getGraphicsContext());
    }

    //calls the update method in player class. (for now)
    protected void update(){
        player.update();
    }
}
