package com.choppyfloppy;

import com.choppyfloppy.controllers.GameController;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class Game extends GameEngine {

    private ImageView enemyView = new ImageView();
    private ImageView bulletView = new ImageView();
    private ImageView powerupsView = new ImageView();
    private Vector2D playerPosition, mousePosition, aimDirection;
    private int checker = 0;
    private int playerLife = 3;
    private int killCount = 0;
    private int scoreCount = 0;
    private int levelCount = 1;
    private Player player;
    private GameObjectSpawner gameObjectSpawner = new GameObjectSpawner();
    private ImageView playerView = new ImageView();
    private List<Enemy> enemies = new ArrayList<>();
    private List<Bullet> bullets = new ArrayList<>();
    private List<PowerUp> powerUps = new ArrayList<>();
    private Image gameLevel;
    private boolean paused;
    private boolean restartCheck = true;

    public int getScoreCount(){return scoreCount;}

    public int getLevelCount() {
        return levelCount;
    }

    public void setLevelCount(int levelCount) {
        this.levelCount = levelCount;
    }

    public Game(GridPane parent, int width, int height){
        super(parent, width, height);
        createContent();
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public boolean isPaused() {
        return paused;
    }

    private void createContent(){
        changeLevel();
        createPlayer();
        getCanvas().getScene().setOnMousePressed(this::mousePressedEvent);
    }

    private void mousePressedEvent(MouseEvent e){
        playerPosition = new Vector2D(player.getPosition().getX(), player.getPosition().getY());
        mousePosition = new Vector2D(e.getX(), e.getY());

        aimDirection = subVector(new Vector2D(player.getPosition().getX() + player.getBounds().getWidth() - 10, player.getPosition().getY() + player.getBounds().getHeight() - 10), mousePosition);
        double normalizedX = aimDirection.getX() / Math.sqrt(Math.pow(aimDirection.getX(), 2) + Math.pow(aimDirection.getY(), 2));
        double normalizedY = aimDirection.getY() / Math.sqrt(Math.pow(aimDirection.getX(), 2) + Math.pow(aimDirection.getY(), 2));

        Bullet bullet = new Bullet(bulletView, new Vector2D(player.getPosition().getX() + player.getBounds().getWidth() - 10, player.getPosition().getY() + player.getBounds().getHeight() - 10), new Rectangle(15,14), new Rectangle(0, 0, getWidth(), getHeight()));
        bullets.add(bullet);
        bullet.setVelocity(new Vector2D(normalizedX, normalizedY));

        //System.out.println("PlayerPosition: (" + (int)playerPosition.getX() + ", " +  (int)playerPosition.getY() + ")\nMousePosition: (" + (int)mousePosition.getX() + ", " + (int)mousePosition.getY() + ")\n");
    }
    private Vector2D subVector(Vector2D vector1, Vector2D vector2){
        double newVectorX = vector2.getX() - vector1.getX();
        double newVectorY = vector2.getY() - vector1.getY();
        return new Vector2D(newVectorX, newVectorY);
    }

    private void createPlayer(){
        player = new Player(playerView, new Vector2D(200,200), new Rectangle(165, 70), new Rectangle(0,0,getWidth(),getHeight()));
    }

    private void changeLevel(){
        //level-changer
        if(levelCount == 1) {
            gameLevel = new Image("com/choppyfloppy/Resources/Background/level-1.png");
            enemies.clear();
        }else if(levelCount == 2){
            gameLevel = new Image("com/choppyfloppy/Resources/Background/level-2.png");
            enemies.clear();
        }else if(levelCount == 3){
            gameLevel = new Image("com/choppyfloppy/Resources/Background/level-3.png");
            enemies.clear();
        }else if(levelCount == 4){
            gameLevel = new Image("com/choppyfloppy/Resources/Background/level-4.png");
            enemies.clear();
        }
    }

    protected void OnUpdate(){

        if(restartCheck){
            changeLevel();
            restartCheck = false;
        }

        if (paused){
            return;
        }

        if(levelCount < 4){
            if(killCount >= 10){
                levelCount++;
                changeLevel();
                killCount = 0;
            }
        }

        //enemy-spawner
        gameObjectSpawner.spawnEnemies(enemies, enemyView, levelCount);

        //powerUp-spawner
        gameObjectSpawner.spawnPowerups(powerUps, powerupsView);

        //powerup hitting player
        for(GameObject powerup: powerUps){
            powerup.update();
            if(powerup.isColliding(player)){
                powerup.setAlive(false);
                scoreCount += 100;
            }
        }


        //bullets hitting enemies, and enemy hitting player
        for(GameObject enemy: enemies){
            for(GameObject bullet: bullets){
                if(enemy.isColliding(bullet)){
                    bullet.setAlive(false);
                    enemy.setAlive(false);
                    scoreCount += 10;
                    killCount++;
                }
            }
            if(enemy.isColliding(player)){
                enemy.setAlive(false);
                playerLife--;
            }
        }

        //updates movement of every enemy. removes enemies hit by bullets
        for(Enemy enemy: enemies){
            enemy.update(enemy, player);
        }

        //updates movement of every bullet. removes bullets that are out of screenbounds
        for(Bullet bullet: bullets){
            bullet.update();
        }

        //player movement
        player.update(getCanvas().getScene());

        //remove dead object from list
        bullets.removeIf(GameObject::isDead);
        powerUps.removeIf(GameObject::isDead);
        enemies.removeIf(GameObject::isDead);

        //remove this later! checking the size of the bullets and enemies arrays every 2seconds
        checker++;
        if(checker == 120) {
            System.out.println("The Game board\nBullets: " + bullets.size() + "\nEnemies: " + enemies.size() + "\n");
            checker = 0;
        }
    }

    protected void draw(){
        GraphicsContext graphicsContext = getGraphicsContext();

        //draw background
        graphicsContext.drawImage(gameLevel, 0,0, getWidth(), getHeight());

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

        //draws powerups and update animation
        for(PowerUp powerUp: powerUps){
            powerUp.draw(getGraphicsContext());
            powerUp.updateAnimation(powerupsView, "com/choppyfloppy/resources/PowerUp/Powerup-");
        }

        if(playerLife <= 0) {
            graphicsContext.setFill(Color.BLACK);
            graphicsContext.fillRect(0, 0, getWidth(), getHeight());
            graphicsContext.setFill(Color.WHITE);
            graphicsContext.setFont(Font.font("SERIF", 25));
            graphicsContext.fillText("GAME OVER! Press ESCAPE and restart to try again\nYour score was: " + scoreCount, getWidth() / 2 - 250, getHeight() / 2);
            getGameLoop().stop();
        }
    }
}
