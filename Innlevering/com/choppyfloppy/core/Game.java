package com.choppyfloppy.core;

import com.choppyfloppy.controllers.EndController;
import com.choppyfloppy.game.*;
import com.choppyfloppy.sound.SoundManager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
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
    private ImageView explotionView = new ImageView();
    private ImageView gameView = new ImageView();
    private ImageView playerView = new ImageView();
    private Vector2D playerPosition, mousePosition, aimDirection;
    private int playerLife = 3;
    private int killCount = 0;
    private int scoreCount = 0;
    private int levelCount = 1;
    private Player player;
    private GameObjectSpawner gameObjectSpawner = new GameObjectSpawner();
    private GameLevel gameLevel = new GameLevel(gameView);
    private SoundManager soundManager = new SoundManager();
    private List<Enemy> enemies = new ArrayList<>();
    private List<Bullet> bullets = new ArrayList<>();
    private List<PowerUp> powerUps = new ArrayList<>();
    private List<Explosion> explosions = new ArrayList<>();
    private boolean paused;
    private boolean restartCheck = true;

    public List<Enemy> getEnemies(){return enemies;}
    public List<Explosion> getExplosions(){return explosions; }
    public ImageView getExplosionView(){return explotionView;}
    public SoundManager getSoundManager(){return soundManager;}

    public int getScoreCount(){return scoreCount;}
    public void setScoreCount(int scoreCount){this.scoreCount = scoreCount;}

    public void setPlayerLife(int playerLife){this.playerLife = playerLife;}
    public int getPlayerLife(){return playerLife;}

    public int getLevelCount() {
        return levelCount;
    }
    public void setLevelCount(int levelCount) {
        this.levelCount = levelCount;
    }

    public void setKillCount(int killCount){this.killCount = killCount;}
    public int getKillCount(){return killCount;}

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
        gameLevel.changeLevel(enemies, levelCount);
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
        soundManager.playSound("Sound/laser-shot.wav");
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

    protected void OnUpdate(){

        if(restartCheck){
            gameLevel.changeLevel(enemies, levelCount);
            restartCheck = false;
        }

        if (paused){
            return;
        }

        //level checker
        gameLevel.checkForChange(enemies, levelCount);

        //enemy-spawner
        gameObjectSpawner.spawnEnemies(enemies, enemyView, levelCount);

        //powerUp-spawner
        gameObjectSpawner.spawnPowerups(powerUps, powerupsView);

        //powerup hitting player
        for(PowerUp powerup: powerUps){
            powerup.update();
            if(powerup.isColliding(player)){
                powerup.givePowerup(enemies);
                powerup.setAlive(false);
                scoreCount += 100;
                soundManager.playSound("Sound/power-up.wav");
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
                    Explosion explosion = new Explosion(explotionView, new Vector2D(enemy.getPosition().getX(), enemy.getPosition().getY()), new Rectangle(0,0));
                    explosions.add(explosion);
                    soundManager.playSound("Sound/explosion.wav");
                }
            }
            if(enemy.isColliding(player)){
                enemy.setAlive(false);
                playerLife--;
                Explosion explosion = new Explosion(explotionView, new Vector2D(player.getPosition().getX(), player.getPosition().getY()), new Rectangle(0,0));
                explosions.add(explosion);
                soundManager.playSound("Sound/explosion.wav");
            }
        }

        //updates movement of every enemy.
        for(Enemy enemy: enemies){
            enemy.update(enemy, player);
        }

        //updates movement of every bullet.
        for(Bullet bullet: bullets){
            bullet.update();
        }

        //update every explotion
        for(Explosion explosion : explosions){
            explosion.update();
        }

        //updates player movement
        player.update(getCanvas().getScene());

        //remove dead object from list
        bullets.removeIf(GameObject::isDead);
        powerUps.removeIf(GameObject::isDead);
        enemies.removeIf(GameObject::isDead);
        explosions.removeIf(GameObject::isDead);
    }

    protected void draw(){
        GraphicsContext graphicsContext = getGraphicsContext();

        //draw background
        graphicsContext.drawImage(gameView.getImage(), 0,0, getWidth(), getHeight());

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

        //explosions
        for(Explosion explosion : explosions){
            explosion.draw(getGraphicsContext());
            explosion.updateAnimation(explotionView, "com/choppyfloppy/resources/Explosion/explosion-");
        }

        graphicsContext.setFont(Font.font("SERIF", 15));
        graphicsContext.fillText("Score: " + scoreCount + "\nLife: " + playerLife, 10, 20);

        if(playerLife <= 0) {
            soundManager.playSound("Sound/game-over.wav");
            EndController.endGame();
            graphicsContext.setFill(Color.BLACK);
            graphicsContext.fillRect(0, 0, getWidth(), getHeight());
            graphicsContext.setFill(Color.WHITE);
            graphicsContext.setFont(Font.font("SERIF", 25));
            graphicsContext.fillText("GAME OVER! Press ESCAPE and restart to try again\nYour score was: " + scoreCount, getWidth() / 2 - 250, getHeight() / 2);
            getGameLoop().stop();
        }
    }
}
