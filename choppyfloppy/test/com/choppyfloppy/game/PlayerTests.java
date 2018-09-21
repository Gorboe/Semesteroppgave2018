package com.choppyfloppy.game;

import com.choppyfloppy.core.Vector2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import org.junit.Test;

public class PlayerTests {

    @Test (expected = NullPointerException.class)
    public void ImageViewCanNotBeNull(){
        new Player(null, new Vector2D(10,10),new Rectangle(),new Rectangle());
    }

    @Test(expected = NullPointerException.class)
    public void Vector2dCanNotBeNull(){
        new Player(new ImageView(), null, new Rectangle(), new Rectangle());
    }

    @Test(expected = NullPointerException.class)
    public void RectangleBoundsCanNotBeNull(){
        new Player(new ImageView(), new Vector2D(10,10), null, new Rectangle());
    }

    @Test(expected = NullPointerException.class)
    public void RectangleScreenBoundsCanNotBeNull(){
        new Player(new ImageView(), new Vector2D(10,10), new Rectangle(), null);
    }

    @Test (expected = NullPointerException.class)
    public void updateCanNotBeNull(){
        Player player = new Player(new ImageView(), new Vector2D(10,10), new Rectangle(), new Rectangle());
        player.update(null);
    }

    @Test (expected = NullPointerException.class)
    public void drawCanNotBeNull(){
        Player player = new Player(new ImageView(), new Vector2D(10,10), new Rectangle(), new Rectangle());
        player.draw(null);
    }




}
