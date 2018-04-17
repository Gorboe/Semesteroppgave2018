package Main;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends GameObject{

    private Image heli1, heli2, heli3, heli4;
    private int imageDelay = 0;

    public Player(ImageView imageView){
        super(imageView);
        heli1 = new Image("Main/Resources/Helicopter/helicopter1.png");
        heli2 = new Image("Main/Resources/Helicopter/helicopter2.png");
        heli3 = new Image("Main/Resources/Helicopter/helicopter3.png");
        heli4 = new Image("Main/Resources/Helicopter/helicopter4.png");
    }


    public ImageView updatePlayerAnimation(ImageView imageView){
        if(imageDelay >= 1 && imageDelay <= 5){
            imageView.setImage(heli2);
            imageDelay++;
        }else if(imageDelay >= 6 && imageDelay <= 10){
            imageView.setImage(heli3);
            imageDelay++;
        }else if(imageDelay >= 11 && imageDelay <= 15){
            imageView.setImage(heli4);
            imageDelay++;
        }else if(imageDelay >= 16 && imageDelay <= 20){
            imageView.setImage(heli1);
            imageDelay++;
        }else{
            imageDelay = 1;
        }

        return imageView;
    }

}
