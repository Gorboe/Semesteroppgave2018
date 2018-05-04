package com.choppyfloppy.game;

import com.choppyfloppy.core.Vector2D;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import org.junit.Test;

public class PowerUpCollectionTests {

    @Test (expected = NullPointerException.class)
    public void ImageViewCanNotBeNull(){
        new PowerUpCollection(null, new Vector2D(10,10),new Rectangle());
    }

    @Test(expected = NullPointerException.class)
    public void Vector2dCanNotBeNull(){
        new PowerUpCollection(new ImageView(), null, new Rectangle());    }

    @Test(expected = NullPointerException.class)
    public void RectangleBoundsCanNotBeNull() {
        new PowerUpCollection(new ImageView(), new Vector2D(10, 10), null);
    }

    @Test(expected = NullPointerException.class)
    public void enemiesCanNotBeNull(){
        PowerUpCollection powerUp = new PowerUpCollection(new ImageView(), new Vector2D(10, 10), new Rectangle());
        powerUp.getPowerup(null);
    }

    @Test (expected = NullPointerException.class)
    public void drawCanNotBeNull(){
        PowerUpCollection powerUp = new PowerUpCollection(new ImageView(), new Vector2D(10,10), new Rectangle());
        powerUp.draw(null);
    }


}
