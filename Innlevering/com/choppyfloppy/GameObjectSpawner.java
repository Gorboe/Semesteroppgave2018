package com.choppyfloppy;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class GameObjectSpawner {

    private final double enemySpawnRate = 0.015;
    private final double powerupsSpawnRate = 0.01;

    public void spawnEnemies(List<Enemy> enemies, ImageView enemyView, int levelCount){
        if(Math.random() < enemySpawnRate){
            Enemy enemy = new Enemy(enemyView, new Vector2D(Main.getGame().getWidth(), Math.random() * Main.getGame().getHeight()), new Rectangle(70, 48));
            enemies.add(enemy);
        }

        if(levelCount >= 2){
            if(Math.random() < enemySpawnRate){
                Enemy enemy = new Enemy(enemyView, new Vector2D(0, Math.random() * Main.getGame().getHeight()), new Rectangle(70, 48));
                enemies.add(enemy);
            }
        }

        if(levelCount >= 3){
            if(Math.random() < enemySpawnRate){
                Enemy enemy = new Enemy(enemyView, new Vector2D(Math.random() * Main.getGame().getWidth(), 0), new Rectangle(70, 48));
                enemies.add(enemy);
            }
        }

        if(levelCount >= 4){
            if(Math.random() < enemySpawnRate){
                Enemy enemy = new Enemy(enemyView, new Vector2D(Math.random() * Main.getGame().getWidth(), Main.getGame().getHeight()), new Rectangle(70, 48));
                enemies.add(enemy);
            }
        }
    }

    public void spawnPowerups(List<PowerUp> powerUps, ImageView powerupsView){
        if(Math.random() < powerupsSpawnRate){
            PowerUp powerUp = new PowerUp(powerupsView, new Vector2D(Math.random() * Main.getGame().getWidth(), Math.random() * Main.getGame().getHeight()), new Rectangle(50,50));
            powerUps.add(powerUp);
        }
    }
}
