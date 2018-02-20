package sample;

import javafx.animation.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;

public abstract class GameEngine {

    private AnimationTimer gameLoop;
    private Canvas canvas;

    public GameEngine(GridPane parent, int width, int height){
        canvas = new Canvas(width, height);
        parent.add(canvas,0,1,1,1);
        buildAndSetGameLoop();
    }

    //AnimationTimer runs 60 times per second calls update() and draw()
    private void buildAndSetGameLoop(){
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                draw();
            }
        };
        gameLoop.start();
    }

    protected abstract void update();
    protected abstract void draw();
    protected GraphicsContext getGraphicsContext(){return canvas.getGraphicsContext2D();}
}
