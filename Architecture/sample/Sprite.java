package sample;

import javafx.scene.image.Image;

import java.util.Objects;

public class Sprite{

    private String name;
    private Image image;

    public Sprite(String name, Image image){
        this.name = Objects.requireNonNull(name); //Checks that the specified object reference is not null.
        this.image = Objects.requireNonNull(image);
    }

    public Image getImage(){return image;}
    public String getName(){return name;}
}
