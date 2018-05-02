package com.choppyfloppy.core;

import com.choppyfloppy.controllers.EndController;
import com.choppyfloppy.game.*;
import com.choppyfloppy.sound.SoundManager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import java.util.ArrayList;
import java.util.List;

/**
 * Game is where all the GameContent is made.
 * MouseEvent - Shooting logic is here.
 *
 * OnUpdate - updates the movement of all the
 * GameObjects like player, bullets, enemies
 * and powerups. Enemies and powerups are
 * spawned here. Checking for bounds collision
 * and removing "dead" GameObjects.
 *
 * draw - draws all the GameObjects to the
 * canvas, and updates all of the game -
 * animations. Also displays the scoreCount
 * and playerLife in the top left corner.
 */
public class Game extends GameEngine {

    private ImageView enemyView = new ImageView();
    private ImageView bulletView = new ImageView();
    private ImageView powerupsView = new ImageView();
    private ImageView explosionView = new ImageView();
    private ImageView gameView = new ImageView();
    private ImageView playerView = new ImageView();
    private int playerLife = 3;
    private int killCount, scoreCount = 0;
    private int levelCount = 1;
    private Player player;
    private final GameObjectSpawner gameObjectSpawner = new GameObjectSpawner();
    private final GameLevel gameLevel = new GameLevel(gameView);
    private final SoundManager soundManager = new SoundManager();
    private final List<Enemy> enemies = new ArrayList<>();
    private final List<Bullet> bullets = new ArrayList<>();
    private final List<PowerUpCollection> powerUps = new ArrayList<>();
    private final List<Explosion> explosions = new ArrayList<>();
    private boolean paused;
    private boolean restartCheck = true;

    /**
     * Is used to access the explosions list
     */
    public List<Explosion> getExplosions(){return explosions; }

    /**
     * Is used to access the explosionView
     */
    public ImageView getExplosionView(){return explosionView;}

    /**
     * Is used to access the soundManager
     */
    public SoundManager getSoundManager(){return soundManager;}

    /**
     * Is used to access the scoreCount integer.
     */
    public int getScoreCount(){return scoreCount;}

    /**
     * Is used to set the scoreCount integer.
     */
    public void setScoreCount(int scoreCount){this.scoreCount = scoreCount;}

    /**
     * Is used to set the levelCount integer.
     */
    public void setPlayerLife(int playerLife){this.playerLife = playerLife;}

    /**
     * Is used to access the killCount integer.
     */
    public int getPlayerLife(){return playerLife;}

    /**
     * Is used to access the levelCount integer.
     */
    public int getLevelCount() {
        return levelCount;
    }

    /**
     * Is used to set the levelCount integer.
     */
    public void setLevelCount(int levelCount) {
        this.levelCount = levelCount;
    }

    /**
     * Is used to set the killCount integer.
     */
    public void setKillCount(int killCount){this.killCount = killCount;}

    /**
     * Is used to access the killCount integer.
     */
    public int getKillCount(){return killCount;}

    /**
     * Constructor of the Game class
     * @param parent is used to get the size of the window
     * @param width is used to set the width of the Canvas
     * @param height is used to set the height of the Canvas
     */
    public Game(GridPane parent, int width, int height){
        super(parent, width, height);
        createContent();
    }

    /**
     * Used to set the value of paused in Game
     */
    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    /**
     * Used to access paused in Game
     */
    public boolean isPaused() {
        return paused;
    }

    private void createContent(){
        gameLevel.changeLevel(enemies, levelCount);
        createPlayer();
        getCanvas().getScene().setOnMousePressed(this::onMousePressed);
    }

    private void onMousePressed(MouseEvent e){
        Vector2D mousePosition, aimDirection;
        mousePosition = new Vector2D(e.getX(), e.getY());
        aimDirection = Vector2D.subtract(new Vector2D(player.getPosition().getX() + player.getBounds().getWidth() - 10, player.getPosition().getY() + player.getBounds().getHeight() - 10), mousePosition);
        double normalizedX = aimDirection.getX() / Math.sqrt(Math.pow(aimDirection.getX(), 2) + Math.pow(aimDirection.getY(), 2));
        double normalizedY = aimDirection.getY() / Math.sqrt(Math.pow(aimDirection.getX(), 2) + Math.pow(aimDirection.getY(), 2));
        Bullet bullet = new Bullet(bulletView, new Vector2D(player.getPosition().getX() + player.getBounds().getWidth() - 10, player.getPosition().getY() + player.getBounds().getHeight() - 10), new Rectangle(15,14), new Rectangle(0, 0, getWidth(), getHeight()));
        bullets.add(bullet);
        bullet.setVelocity(new Vector2D(normalizedX, normalizedY));
        soundManager.playSound("sound/laser-shot.wav");
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
        for(PowerUpCollection powerup: powerUps){
            powerup.update();
            if(powerup.isColliding(player)){
                powerup.getPowerup(enemies);
                powerup.setAlive(false);
                scoreCount += 100;
                soundManager.playSound("sound/power-up.wav");
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
                    Explosion explosion = new Explosion(explosionView, new Vector2D(enemy.getPosition().getX(), enemy.getPosition().getY()), new Rectangle(0,0));
                    explosions.add(explosion);
                    soundManager.playSound("sound/explosion.wav");
                }
            }
            if(enemy.isColliding(player)){
                enemy.setAlive(false);
                playerLife--;
                Explosion explosion = new Explosion(explosionView, new Vector2D(player.getPosition().getX(), player.getPosition().getY()), new Rectangle(0,0));
                explosions.add(explosion);
                soundManager.playSound("sound/explosion.wav");
            }
        }

        //updates movement of every enemy.
        enemies.parallelStream().forEach((enemy) -> {enemy.update(player);});

        //updates movement of every bullet.
        bullets.parallelStream().forEach(Bullet::update);

        //update every explosion
        explosions.parallelStream().forEach(Explosion::update);

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
        for(PowerUpCollection powerUp: powerUps){
            powerUp.draw(getGraphicsContext());
            powerUp.updateAnimation(powerupsView, "com/choppyfloppy/resources/PowerUp/Powerup-");
        }

        //draws explosions and updates animation
        for(Explosion explosion: explosions){
            explosion.draw(getGraphicsContext());
            explosion.updateAnimation(explosionView, "com/choppyfloppy/resources/Explosion/explosion-");
        }

        graphicsContext.setFont(Font.font("SERIF", 15));
        graphicsContext.fillText("Score: " + scoreCount + "\nLife: " + playerLife, 10, 20);

        if(playerLife <= 0) {
            soundManager.playSound("sound/game-over.wav");
            EndController.endGame();
            getGameLoop().stop();
        }
    }
}
