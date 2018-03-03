package sample.Objects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Core.GameObject;

public class Enemy extends GameObject {
    public Enemy(){super(new Rectangle(20,20, Color.RED));}
}
