package com.choppyfloppy.game;

import com.choppyfloppy.Main;
import com.choppyfloppy.core.GameObject;
import com.choppyfloppy.core.Vector2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Powerups are GameObjects. It grant the player
 * a "powerup" whenever the player collide with the
 * powerup-star on the game-board. This class contains
 * four different powerups, selected randomly.
 */
public class PowerUpCollection extends GameObject {

    private int lifeTimer = 0;

    /**
     * This is the constructor
     * @param imageView is used to create Animations easily
     * @param position keeps track of where the powerup is
     * @param bounds is the "hit-box" of the powerup.
     */
    public PowerUpCollection(ImageView imageView, Vector2D position, Rectangle bounds){
        super(imageView, position, bounds);
    }

    /**
     * This method selects randomly one of four different "powerups" whenever a player
     * collide with a powerup-star.
     * -Plus one health to the player
     * -Clear the game-board of enemies
     * -Freeze all enemies currently on the game-board
     * -Increase score by 500points
     * @param enemies is a list of all the enemies currently on the game-board
     */
    public void getPowerup(List<Enemy> enemies){
        Objects.requireNonNull(enemies);
        int randomizedReward = ThreadLocalRandom.current().nextInt(0,4); //0 - 3 verdier
        if(randomizedReward == 0){
            Main.getGame().setPlayerLife(Main.getGame().getPlayerLife() + 1);
        }else if(randomizedReward == 1){
            int clearScore = enemies.size() * 10;
            Main.getGame().setScoreCount(Main.getGame().getScoreCount() + clearScore);
            for(Enemy enemy: enemies){
                Explosion explosion = new Explosion(Main.getGame().getExplosionView(), new Vector2D(enemy.getPosition().getX(), enemy.getPosition().getY()), new Rectangle(0,0));
                Main.getGame().getExplosions().add(explosion);
                enemy.setAlive(false);
            }
            Main.getGame().getSoundManager().playSound("sound/explosion.wav");
        }else if(randomizedReward == 2){
            for(Enemy enemy: enemies){
                enemy.setFreeze(true);
            }
            Main.getGame().getSoundManager().playSound("sound/freezing.wav");
        }else if(randomizedReward == 3){
            Main.getGame().setScoreCount(Main.getGame().getScoreCount() + 500);
        }
    }

    /**
     * update is used to keep track of how long the
     * powerups "live". In this case each powerup
     * lives for 10seconds unless a player collides
     * with it.
     */
    public void update() {
        lifeTimer++;
        if(lifeTimer >= 600){
            setAlive(false);
        }
    }

    /**
     * draw is used to draw powerups to the canvas.
     */
    @Override
    public void draw(GraphicsContext gc) {
        Objects.requireNonNull(gc);
        gc.drawImage(getImageView().getImage(), getPosition().getX(), getPosition().getY());
    }
}

