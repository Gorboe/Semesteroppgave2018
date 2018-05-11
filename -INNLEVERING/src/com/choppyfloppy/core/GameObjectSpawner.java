package com.choppyfloppy.core;

import com.choppyfloppy.Main;
import com.choppyfloppy.game.Enemy;
import com.choppyfloppy.game.PowerUpCollection;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import java.util.List;

/**
 * This class is responsible for spawning all enemies
 * and powerups to the game-board. It also increases
 * the difficulty of the game when the game level increases
 * by starting to spawn enemies from different sides.
 */
public class GameObjectSpawner {

    /**
     * spawnEnemies is called 60 times each second and is used for
     * spawning enemies to the game-board.
     * @param enemies an array list of enemies
     * @param levelCount is the current level
     */
    public void spawnEnemies(List<Enemy> enemies, ImageView enemyView, int levelCount){
        final double enemySpawnRateRightSide = 0.01;
        final double enemySpawnRateLeftSide = 0.005;
        final double enemySpawnRateTopSide = 0.003;
        final double enemySpawnRateBottomSide = 0.002;

        if(Math.random() < enemySpawnRateRightSide){
            Enemy enemy = new Enemy(enemyView, new Vector2D(Main.getGame().getWidth(), Math.random() * Main.getGame().getHeight()), new Rectangle(70, 48));
            enemies.add(enemy);
        }

        if(levelCount >= 2){
            if(Math.random() < enemySpawnRateLeftSide){
                Enemy enemy = new Enemy(enemyView, new Vector2D(0, Math.random() * Main.getGame().getHeight()), new Rectangle(70, 48));
                enemies.add(enemy);
            }
        }

        if(levelCount >= 3){
            if(Math.random() < enemySpawnRateTopSide){
                Enemy enemy = new Enemy(enemyView, new Vector2D((int)(Math.random() * Main.getGame().getWidth()), 0), new Rectangle(70, 48));
                enemies.add(enemy);
            }
        }

        if(levelCount >= 4){
            if(Math.random() < enemySpawnRateBottomSide){
                Enemy enemy = new Enemy(enemyView, new Vector2D((int)(Math.random() * Main.getGame().getWidth()), Main.getGame().getHeight()), new Rectangle(70, 48));
                enemies.add(enemy);
            }
        }
    }

    /**
     * spawnPowerups is called 60 times each second and is used for
     * spawning powerups to the game-board.
     * @param powerUps is a list of powerups currently on the game-board
     */
    public void spawnPowerups(List<PowerUpCollection> powerUps, ImageView powerupsView){
        final double powerupsSpawnRate = 0.003;
        if(Math.random() < powerupsSpawnRate){
            PowerUpCollection powerUp = new PowerUpCollection(powerupsView, new Vector2D(Math.random() * Main.getGame().getWidth(), Math.random() * Main.getGame().getHeight()), new Rectangle(50,50));
            powerUps.add(powerUp);
        }
    }
}
