package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Game extends GameEngine {

    private Enemy enemy;
    private ImageView enemyView = new ImageView();
    
    private Player player;
    private Image background = new Image("com/choppyfloppy/Resources/Background/citybackground.jpg");
    private ImageView playerView = new ImageView();
    private List<Enemy> enemies = new ArrayList<>();

    public Game(GridPane parent, int width, int height){
        super(parent, width, height);
        createContent();
    }

    private void createContent(){
        createPlayer();
    }

    private void createPlayer(){
        player = new Player(playerView, new Vector2D(200,200), new Rectangle(165, 70), new Rectangle(0,0,getWidth(),getHeight()));

        enemy = new Enemy(enemyView, Vector2D.Zero(), new Rectangle(70, 48));
        enemies.add(enemy);
    }

    protected void OnUpdate(){
        for(Enemy enemy: enemies){
            enemy.enemyMovement(enemy, player);
        }
        player.update(getCanvas().getScene());
    }

    protected void draw(){
        GraphicsContext graphicsContext = getGraphicsContext();
        graphicsContext.drawImage(background, 0,0, getWidth(), getHeight());
        player.draw(getGraphicsContext());
        enemy.draw(getGraphicsContext());
        enemy.updateAnimation(enemyView, "com/choppyfloppy/resources/Enemy/RedBird/frame-");
        player.updateAnimation(playerView, "com/choppyfloppy/resources/Helicopter/helicopter");
    }
}
