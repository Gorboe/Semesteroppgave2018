package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.GridPane;

public abstract class GameEngine {

    private GridPane window;
    private int width;
    private int height;

    public GameEngine(GridPane window, int width, int height){
        this.window = window;
        this.width = width;
        this.height = height;
        buildAndSetGameLoop();
    }

    public int getHeight(){return height;}
    public int getWidth(){return width;}
    public GridPane getWindow(){return window;}

    //AnimationTimer runs 60 times per second calls update() and draw()
    private void buildAndSetGameLoop(){
        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                onUpdate();
            }
        };
        gameLoop.start();
    }

    protected abstract void onUpdate();
}
