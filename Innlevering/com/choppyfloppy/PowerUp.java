package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class PowerUp extends GameObject {

    //powerups live for 10seconds before they are removed.
    private int lifeTimer = 0;

    public PowerUp(ImageView imageView, Vector2D position, Rectangle bounds){
        super(imageView, position, bounds);
    }

    public void givePowerup(List<Enemy> enemies){
        int randomizedReward = (int)(4 * Math.random()); //0 - 3 verdier
        if(randomizedReward == 0){
            Main.getGame().setPlayerLife(Main.getGame().getPlayerLife() + 1);
        }else if(randomizedReward == 1){
            int clearScore = enemies.size() * 10;
            Main.getGame().setScoreCount(Main.getGame().getScoreCount() + clearScore);
            for(Enemy enemy: enemies){
                Explotion explotion = new Explotion(Main.getGame().getExplotionView(), new Vector2D(enemy.getPosition().getX(), enemy.getPosition().getY()), new Rectangle(0,0));
                Main.getGame().getExplotions().add(explotion);
                enemy.setAlive(false);
            }
        }else if(randomizedReward == 2){
            for(Enemy enemy: enemies){
                enemy.setFreeze(true);
            }
        }else if(randomizedReward == 3){
            Main.getGame().setScoreCount(Main.getGame().getScoreCount() + 500);
        }
    }

    public void update() {
        lifeTimer++;
        if(lifeTimer >= 600){
            setAlive(false);
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}

