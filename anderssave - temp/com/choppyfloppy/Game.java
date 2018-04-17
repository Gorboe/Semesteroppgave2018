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

    private Enemy enemy;

    private ImageView enemyView = new ImageView();
    //private ImageView bulletView;
    //private Bullet bullet;
    //private double fixedDirectionY;
    //private double fixedDirectionX;

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
        //getCanvas().getScene().setOnMousePressed(this::mousePressedEvent);
        createPlayer();
        //Enemy enemy = new Enemy(enemyView, new Vector2D(600, 600), new Rectangle(70, 48));
        //enemies.add(enemy);
    }


    private void createPlayer(){
        player = new Player(playerView, new Vector2D(200,200), new Rectangle(165, 70), new Rectangle(0,0,getWidth(),getHeight()));

        enemy = new Enemy(enemyView, Vector2D.Zero(), new Rectangle(70, 48));
        enemies.add(enemy);
    }

    /*public void mousePressedEvent(MouseEvent e){
        Vector2D mousePosition, aimDirection;

        mousePosition = new Vector2D(e.getX(), e.getY());
        aimDirection = subtractVector(player.getPosition(), mousePosition);

        fixedDirectionX = aimDirection.getX() / Math.sqrt(Math.pow(aimDirection.getX(), 2) + Math.pow(aimDirection.getY(), 2));
        fixedDirectionY = aimDirection.getY() / Math.sqrt(Math.pow(aimDirection.getX(), 2) + Math.pow(aimDirection.getY(), 2));

        /*bullet = new Bullet(bulletView, new Vector2D(player.getPosition().getX(), player.getPosition().getY()), new Rectangle());
        bullets.add(bullet);
        bullet.getPosition().add(0,0);

    } */

    /*public Vector2D subtractVector(Vector2D vector1, Vector2D vector2){
        double newVectorX = vector2.getX() - vector1.getX();
        double newVectorY = vector2.getY() - vector1.getY();
        return new Vector2D(newVectorX, newVectorY);
    }*/

    protected void OnUpdate(){
        for(Enemy enemy: enemies){
            enemy.update(enemy, player);
        }
        player.update(getCanvas().getScene());

        //enemies.forEach(GameObject::update);
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
