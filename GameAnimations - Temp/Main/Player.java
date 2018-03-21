package Main;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {

    private ImageView imageView = new ImageView();
    private Image heli1, heli2, heli3, heli4;
    private Point2D velocity;
    private double x, y;
    private int test = 0;

    public Player(){
        heli1 = new Image("Main/Resources/Helicopter/heli-1.png");
        heli2 = new Image("Main/Resources/Helicopter/heli-2.png");
        heli3 = new Image("Main/Resources/Helicopter/heli-3.png");
        heli4 = new Image("Main/Resources/Helicopter/heli-4.png");
    }

    public void setVelocity(Point2D velocity){this.velocity = velocity;}
    public void setX(double x){this.x = x;}
    public void setY(double y){this.y = y;}
    public ImageView getPlayerImageView(){return imageView;}
    public double getRotate(){return imageView.getRotate();}

    public void rotateRight(){
        imageView.setRotate(imageView.getRotate() + 15);
        setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())),Math.sin(Math.toRadians(getRotate()))));
    }

    public void rotateLeft(){
        imageView.setRotate(imageView.getRotate() - 15);
        setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())),Math.sin(Math.toRadians(getRotate()))));
    }

    public void updateAnimation(){
        if(test >= 1 && test <= 5){
            imageView.setImage(heli2);
            test++;
        }else if(test >= 6 && test <= 10){
            imageView.setImage(heli3);
            test++;
        }else if(test >= 11 && test <= 15){
            imageView.setImage(heli4);
            test++;
        }else if(test >= 16 && test <= 20){
            imageView.setImage(heli1);
            test++;
        }else{
            test = 1;
        }
    }

    public void update(){
        imageView.setTranslateX(imageView.getTranslateX() + velocity.getX());
        imageView.setTranslateY(imageView.getTranslateY() + velocity.getY());
    }

}
