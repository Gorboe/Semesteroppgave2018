package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class Enemy extends GameObject {

    private boolean flipImage = false;
    private double spawnRate = 0.015;

    public Enemy(ImageView imageView, Vector2D position, Rectangle bounds){
        super(imageView, position, bounds);
    }

    public void spawnEnemies(List<Enemy> enemies, ImageView enemyView, int levelCount){
        if(Math.random() < spawnRate){
            Enemy enemy = new Enemy(enemyView, new Vector2D(Main.getGame().getWidth(), Math.random() * Main.getGame().getHeight()), new Rectangle(70, 48));
            enemies.add(enemy);
        }

        if(levelCount >= 2){
            if(Math.random() < spawnRate){
                Enemy enemy = new Enemy(enemyView, new Vector2D(0, Math.random() * Main.getGame().getHeight()), new Rectangle(70, 48));
                enemies.add(enemy);
            }
        }

        if(levelCount >= 3){
            if(Math.random() < spawnRate){
                Enemy enemy = new Enemy(enemyView, new Vector2D(Math.random() * Main.getGame().getWidth(), 0), new Rectangle(70, 48));
                enemies.add(enemy);
            }
        }

        if(levelCount >= 4){
            if(Math.random() < spawnRate){
                Enemy enemy = new Enemy(enemyView, new Vector2D(Math.random() * Main.getGame().getWidth(), Main.getGame().getHeight()), new Rectangle(70, 48));
                enemies.add(enemy);
            }
        }
    }

    public void update(Enemy enemy, Player player) {

        //Movement logic
        final double velocity = 1;

        if(player.getPosition().getX() > enemy.getPosition().getX()){
            enemy.getPosition().addX(velocity);
        }else if(player.getPosition().getX() < enemy.getPosition().getX()){
            enemy.getPosition().addX(-velocity);
            flipImage = true;
        }

        if(player.getPosition().getY() > enemy.getPosition().getY()){
            enemy.getPosition().addY(velocity);
        }else if(player.getPosition().getY() < enemy.getPosition().getY()){
            enemy.getPosition().addY(-velocity);
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        if(flipImage){
            gc.drawImage(getImageView().getImage(), getPosition().getX() + getBounds().getWidth(), getPosition().getY(), -getBounds().getWidth(), getBounds().getHeight());
            flipImage = false;
        }else

        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}
