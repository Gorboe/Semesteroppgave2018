package Main;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameObject {

    private Node view;
    private Point2D velocity;
    private double x, y;

    public GameObject(Node view){
        this.view = view;
    }

    public double getRotate(){return view.getRotate();}
    public void setVelocity(Point2D velocity){this.velocity = velocity;}
    public void setX(double x){this.x = x;}
    public void setY(double y){this.y = y;}
    public Node getView(){return view;}
    //public ImageView getImageView(ImageView imageView){return imageView;}

    public void rotateRight(){
        view.setRotate(view.getRotate() + 15);
        setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())),Math.sin(Math.toRadians(getRotate()))));
    }

    public void rotateLeft(){
        view.setRotate(view.getRotate() - 15);
        setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())),Math.sin(Math.toRadians(getRotate()))));
    }

    /*
    public Image getNextImage(){
        //imagearray++

    }

    public ImageView updateAnimation(ImageView imageView){
        imageView.setImage(getNextImage());
        return imageView;
    }*/

    public void update(){
        view.setTranslateX(view.getTranslateX() + velocity.getX());
        view.setTranslateY(view.getTranslateY() + velocity.getY());
    }
}
