package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Game extends GameEngine {

    private ImageView enemyView = new ImageView();
    private ImageView bulletView = new ImageView();
    Vector2D playerPosition, mousePosition;
    int checker = 0;

    private Player player;
    private Image background = new Image("com/choppyfloppy/Resources/Background/citybackground.jpg");
    private ImageView playerView = new ImageView();
    private List<Enemy> enemies = new ArrayList<>();
    private List<Bullet> bullets = new ArrayList<>();

    public Game(GridPane parent, int width, int height){
        super(parent, width, height);
        createContent();
    }

    private void createContent(){
        createPlayer();
        getCanvas().getScene().setOnMousePressed(this::mousePressedEvent);

        Enemy enemy = new Enemy(enemyView, new Vector2D(500, 500), new Rectangle(70, 48));
        enemies.add(enemy);
    }

    private void mousePressedEvent(MouseEvent e){
        playerPosition = new Vector2D(player.getPosition().getX(), player.getPosition().getY());
        mousePosition = new Vector2D(e.getX(), e.getY());
        Bullet bullet = new Bullet(bulletView, playerPosition, new Rectangle(50,45), new Rectangle(0, 0, getWidth(), getHeight())); //fix size later
        bullets.add(bullet);
        System.out.println("PlayerPosition: (" + (int)playerPosition.getX() + ", " +  (int)playerPosition.getY() +
                ")\nMousePosition: (" + (int)mousePosition.getX() + ", " + (int)mousePosition.getY() + ")\n");
    }


    private void createPlayer(){
        player = new Player(playerView, new Vector2D(200,200), new Rectangle(165, 70), new Rectangle(0,0,getWidth(),getHeight()));

        Enemy enemy = new Enemy(enemyView, Vector2D.Zero(), new Rectangle(70, 48));
        enemies.add(enemy);
    }

    protected void OnUpdate(){

        //need to fix removal of enemies!!
        //updates movement of every enemy
        for(Enemy enemy: enemies){
            enemy.update(enemy, player);
        }

        //updates movement of every bullet. removes those out of screenbounds
        for(Bullet bullet: bullets){
            bullet.update(playerPosition, mousePosition);
        }
        bullets.removeIf(GameObject::isDead);

        //remove this later!
        checker++;
        if(checker == 120) {
            System.out.println("Bullets: " + bullets.size() + "\nEnemies: " + enemies.size() + "\n");
            checker = 0;
        }

        //updates player movement
        player.update(getCanvas().getScene());

    }

    protected void draw(){
        GraphicsContext graphicsContext = getGraphicsContext();

        //draw background
        graphicsContext.drawImage(background, 0,0, getWidth(), getHeight());

        //draw player and update the animation
        player.draw(getGraphicsContext());
        player.updateAnimation(playerView, "com/choppyfloppy/resources/Helicopter/helicopter");

        //draws every bullet and updates the animation of every bullet
        for(Bullet bullet: bullets){
            bullet.draw(getGraphicsContext());
            bullet.updateAnimation(bulletView, "com/choppyfloppy/resources/Bullet/bullet-");
        }

        //draws every enemy and updates the animation of every enemy
        for(Enemy enemy: enemies){
            enemy.draw(getGraphicsContext());
            enemy.updateAnimation(enemyView, "com/choppyfloppy/resources/Enemy/RedBird/frame-");
        }
    }
}
