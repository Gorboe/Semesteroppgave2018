package sample;

import javafx.scene.canvas.GraphicsContext;
import java.util.Objects;

public abstract class GameObject{

    protected Sprite sprite;
    protected Vector2D position;

    public GameObject(Sprite sprite, Vector2D position){
        this.sprite = Objects.requireNonNull(sprite); //Checks that the specified object reference is not null.
        this.position = Objects.requireNonNull(position);
    }

    protected void update(){}
    public abstract void draw(GraphicsContext gc);
}
