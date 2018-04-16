package Main;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public abstract class GameEngine {

    /**
     * Tegner til canvas. Display canvas med javafx
     */
    private Canvas canvas;
    private AnimationTimer gameLoop;
    private Pane window;

    public GameEngine(Pane window, int width, int height){
        this.window = window;
        canvas = new Canvas(width, height);
        //window.add(canvas, 0,0);
        window.getChildren().add(canvas);
        buildAndSetGameLoop();
    }

    //public int getHeight(){return height;}
    //public int getWidth(){return width;}
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
