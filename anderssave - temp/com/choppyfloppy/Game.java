package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Game extends GameEngine {

    private Player player;
    private Image background = new Image("com/choppyfloppy/Resources/Background/citybackground.jpg");

    public Game(GridPane parent, int width, int height){
        super(parent, width, height);
        createContent();
    }

    private void createContent(){
        createPlayer();
    }

    private void createPlayer(){
        Image playerimage = new Image("com/choppyfloppy/resources/Helicopter/helicopter1.png");
        Sprite playersprite = new Sprite("Player", playerimage, new Rectangle(50, 50)); //change w and h later. need to match picture size
        player = new Player(playersprite, Vector2D.Zero(), new Rectangle(getWidth(), getHeight()));
        System.out.println("player created");
    }

    protected void OnUpdate(){
        player.update();
    }

    protected void draw(){
        GraphicsContext graphicsContext = getGraphicsContext();
        graphicsContext.drawImage(background, 0,0, getWidth(), getHeight());
        player.draw(getGraphicsContext());

    }
}
