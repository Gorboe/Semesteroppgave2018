package sample.Core;

import javafx.geometry.Point2D;
import javafx.scene.Node;

public class GameObject{

    private Node view;
    private Point2D velocity;
    private boolean alive = true;

    public GameObject(Node view){
        this.view = view;
    }

    public Node getView(){return view;}
    public void setVelocity(Point2D velocity){this.velocity = velocity;}
    public boolean isAlive(){
        return alive;
    }
    public boolean isDead(){
        return !alive;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }

    public boolean isColliding(GameObject other){
        return getView().getBoundsInParent().intersects(other.getView().getBoundsInParent());
    }

    public void update(){
        view.setTranslateX(view.getTranslateX() + velocity.getX()); //gets current x pos and adds the x-velocity
        view.setTranslateY(view.getTranslateY() + velocity.getY()); //gets current y pos and adds the y-velocity
    }
}
