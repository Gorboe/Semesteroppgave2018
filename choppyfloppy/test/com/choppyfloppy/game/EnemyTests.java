package com.choppyfloppy.game;

import javafx.scene.image.*;
import com.choppyfloppy.core.Vector2D;
import javafx.scene.shape.Rectangle;
import org.junit.Test;

public class EnemyTests {

    @Test (expected = NullPointerException.class)
    public void ImageViewCanNotBeNull(){
        new Enemy(null, new Vector2D(10,10),new Rectangle());
    }

    @Test(expected = NullPointerException.class)
    public void Vector2dCanNotBeNull(){
        new Enemy(new ImageView(), null, new Rectangle());    }

    @Test(expected = NullPointerException.class)
    public void RectangleBoundsCanNotBeNull(){
        new Enemy(new ImageView(), new Vector2D(10,10), null);    }


    @Test (expected = NullPointerException.class)
    public void updatePlayerCanNotBeNull(){
        Enemy enemy = new Enemy(new ImageView(), new Vector2D(10,10), new Rectangle());
        enemy.update(null);
    }

    @Test (expected = NullPointerException.class)
    public void drawCanNotBeNull(){
        Player player = new Player(new ImageView(), new Vector2D(10,10), new Rectangle(), new Rectangle());
        player.draw(null);
    }


}
