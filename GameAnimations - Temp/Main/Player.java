package Main;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends GameObject{

    //private ImageView imageView = new ImageView();
    private Image heli1, heli2, heli3, heli4;
    private int test = 0;

    public Player(ImageView imageView){
        super(imageView);
        heli1 = new Image("Main/Resources/Helicopter/heli-1.png");
        heli2 = new Image("Main/Resources/Helicopter/heli-2.png");
        heli3 = new Image("Main/Resources/Helicopter/heli-3.png");
        heli4 = new Image("Main/Resources/Helicopter/heli-4.png");
    }


    public ImageView getPlayerImageView(ImageView imageView){return imageView;}


    public ImageView updateAnimation(ImageView imageView){
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

        return imageView;
    }

}
