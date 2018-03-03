package sample;

import javafx.geometry.Point2D;
import javafx.scene.Node;

public class GameObject{

    private Node view;
    private Point2D velocity;

    public GameObject(Node view){
        this.view = view;
    }

    public Node getView(){return view;}
    public void setVelocity(Point2D velocity){this.velocity = velocity;}

    public void update(){
        view.setTranslateX(view.getTranslateX() + velocity.getX()); //gets current x pos and adds the x-velocity
        view.setTranslateY(view.getTranslateY() + velocity.getY()); //gets current y pos and adds the y-velocity
    }
}
