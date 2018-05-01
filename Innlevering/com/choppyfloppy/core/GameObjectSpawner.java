package com.choppyfloppy.core;

import com.choppyfloppy.Main;
import com.choppyfloppy.game.Enemy;
import com.choppyfloppy.game.PowerUp;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class GameObjectSpawner {

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

    public void spawnPowerups(List<PowerUp> powerUps, ImageView powerupsView){
        final double powerupsSpawnRate = 0.003;
        if(Math.random() < powerupsSpawnRate){
            PowerUp powerUp = new PowerUp(powerupsView, new Vector2D(Math.random() * Main.getGame().getWidth(), Math.random() * Main.getGame().getHeight()), new Rectangle(50,50));
            powerUps.add(powerUp);
        }
    }
}
