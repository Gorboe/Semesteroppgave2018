package com.choppyfloppy.core;

import com.choppyfloppy.Main;
import com.choppyfloppy.game.Enemy;
import com.choppyfloppy.game.Explosion;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import java.util.List;
import java.util.Objects;

/**
 * The class GameLevel is used to store
 * the methods checkForChange and
 * changeLevel.
 */
public class GameLevel {

    private ImageView imageView;

    public GameLevel(ImageView imageView){
        this.imageView = Objects.requireNonNull(imageView);
    }

    /**
     * This method is checked 60 times a second to see if
     * it is time to advance a level.
     * @param enemies a list of all the enemies currently "alive".
     * @param levelCount a integer of the current level.
     */
    public void checkForChange(List<Enemy> enemies, int levelCount){
        if(levelCount < 4){
            if(Main.getGame().getKillCount() >= 10){
                levelCount ++;
                Main.getGame().setLevelCount(levelCount);
                changeLevel(enemies, levelCount);
                Main.getGame().setKillCount();
            }
        }
    }

    /**
     * This method is used to change the level. When
     * the number of enemies killed exceeds the target
     * threshold (currently at 10 for each level).
     * The background image is changed and the "game-board"
     * is cleared of all enemies.
     * @param enemies a list of all the enemies currently "alive".
     * @param levelCount a integer of the current level.
     */
    public void changeLevel(List<Enemy> enemies, int levelCount){
        Image gameLevel;
        if(levelCount == 1) {
            gameLevel = new Image("com/choppyfloppy/Resources/Background/level-1.png");
            imageView.setImage(gameLevel);
        }else if(levelCount == 2){
            gameLevel = new Image("com/choppyfloppy/Resources/Background/level-2.png");
            for(Enemy enemy: enemies){
                Explosion explosion = new Explosion(Main.getGame().getExplosionView(), new Vector2D(enemy.getPosition().getX(), enemy.getPosition().getY()), new Rectangle(0,0));
                Main.getGame().getExplosions().add(explosion);
                enemy.setAlive(false);
            }
            imageView.setImage(gameLevel);
            Main.getGame().getSoundManager().playSound("sound/next-level.wav");
        }else if(levelCount == 3){
            gameLevel = new Image("com/choppyfloppy/Resources/Background/level-3.png");
            for(Enemy enemy: enemies){
                Explosion explosion = new Explosion(Main.getGame().getExplosionView(), new Vector2D(enemy.getPosition().getX(), enemy.getPosition().getY()), new Rectangle(0,0));
                Main.getGame().getExplosions().add(explosion);
                enemy.setAlive(false);
            }
            imageView.setImage(gameLevel);
            Main.getGame().getSoundManager().playSound("sound/next-level.wav");
        }else if(levelCount == 4){
            gameLevel = new Image("com/choppyfloppy/Resources/Background/level-4.png");
            for(Enemy enemy: enemies){
                Explosion explosion = new Explosion(Main.getGame().getExplosionView(), new Vector2D(enemy.getPosition().getX(), enemy.getPosition().getY()), new Rectangle(0,0));
                Main.getGame().getExplosions().add(explosion);
                enemy.setAlive(false);
            }
            imageView.setImage(gameLevel);
            Main.getGame().getSoundManager().playSound("sound/next-level.wav");
        }
    }
}
