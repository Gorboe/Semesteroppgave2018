package Main;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public abstract class GameEngine {

    private Canvas canvas;
    private AnimationTimer gameLoop;
    private Pane window;

    public GameEngine(Pane window, int width, int height){
        this.window = window;
        canvas = new Canvas(width, height);
        window.getChildren().add(canvas);
        buildAndSetGameLoop();
    }

    public Pane getWindow(){return window;}
    public AnimationTimer getGameLoop(){return gameLoop;}
    public Canvas getCanvas(){return canvas;}
    protected GraphicsContext getGraphicsContext() {
        return canvas.getGraphicsContext2D();
    }


    //AnimationTimer runs 60 times per second calls update() and draw()
    private void buildAndSetGameLoop(){
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                OnUpdate();
                draw();
            }
        };
        gameLoop.start();
    }

    protected abstract void OnUpdate();
    protected abstract void draw();
}
