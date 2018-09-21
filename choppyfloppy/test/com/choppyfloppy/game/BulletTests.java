package com.choppyfloppy.game;

import com.choppyfloppy.core.Vector2D;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import org.junit.Test;

import static  org.junit.Assert.*;

public class BulletTests {

    @Test (expected = NullPointerException.class)
    public void ImageviewCanNotBeNull(){
        new Bullet(null, new Vector2D(10,10),new Rectangle(),new Rectangle());
    }

    @Test(expected = NullPointerException.class)
    public void Vector2dCanNotBeNull(){
        new Bullet(new ImageView(), null, new Rectangle(), new Rectangle());
    }

    @Test(expected = NullPointerException.class)
    public void RectangleBoundsCanNotBeNull(){
        new Bullet(new ImageView(), new Vector2D(10,10), null, new Rectangle());
    }

    @Test(expected = NullPointerException.class)
    public void RectangleScreenBoundsCanNotBeNull(){
        new Bullet(new ImageView(), new Vector2D(10,10), new Rectangle(), null);
    }

    @Test (expected = NullPointerException.class)
    public void setVelocityCanNotBeNull() {
        Bullet bullet = new Bullet(new ImageView(), new Vector2D(10,10), new Rectangle(), new Rectangle());
        bullet.setVelocity(null);
    }

    @Test (expected = NullPointerException.class)
    public void drawCanNotBeNull() {
        Bullet bullet = new Bullet(new ImageView(), new Vector2D(10,10), new Rectangle(), new Rectangle());
        bullet.draw(null);
    }

}
