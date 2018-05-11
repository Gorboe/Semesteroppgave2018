package com.choppyfloppy.game;

import com.choppyfloppy.core.Vector2D;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import org.junit.Test;

public class ExplosionTests {


    @Test(expected = NullPointerException.class)
    public void ImageviewCanNotBeNull(){
        new Explosion(null, new Vector2D(10,10),new Rectangle());
    }

    @Test(expected = NullPointerException.class)
    public void Vector2dCanNotBeNull(){
        new Explosion(new ImageView(), null, new Rectangle());    }

    @Test(expected = NullPointerException.class)
    public void RectangleBoundsCanNotBeNull(){
        new Explosion(new ImageView(), new Vector2D(10,10), null);    }

    @Test (expected = NullPointerException.class)
    public void drawCanNotBeNull(){
        Explosion explosion = new Explosion(new ImageView(), new Vector2D(10,10), new Rectangle());
        explosion.draw(null);
    }

}
