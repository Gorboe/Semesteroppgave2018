package com.choppyfloppy;

import javafx.scene.image.Image;

public class GameLevel {

    private Image background;
    private double spawnrate;

    public GameLevel(Image background, double spawnrate){
        this.background = background;
        this.spawnrate = spawnrate;
    }

    public Image getBackground() {
        return background;
    }

    public double getSpawnrate() {
        return spawnrate;
    }

}
