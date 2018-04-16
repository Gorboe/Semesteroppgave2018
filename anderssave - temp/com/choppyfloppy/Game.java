package com.choppyfloppy;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Game extends GameEngine {

    private Enemy enemy;
    private ImageView enemyView = new ImageView();

    private Player player;
    private final double playerSpeed = 5;
    private boolean upActive, downActive, leftActive, rightActive = false;
    private Image background = new Image("com/choppyfloppy/Resources/Background/citybackground.jpg");
    private ImageView playerView = new ImageView();

    public Game(GridPane parent, int width, int height){
        super(parent, width, height);
        createContent();
    }

    private void createContent(){
        createPlayer();
        getCanvas().getScene().setOnKeyPressed(this::keyPressedEvent);
        getCanvas().getScene().setOnKeyReleased(this::keyReleasedEvent);
    }

    private void keyPressedEvent(KeyEvent e){
        if(e.getCode() == KeyCode.RIGHT){
            player.setVelocityX(playerSpeed);
            //leftActive = false;
            rightActive = true;
            if(upActive){
                player.setVelocityY(-playerSpeed);
            }else if(downActive){
                player.setVelocityY(playerSpeed);
            }
        }else if(e.getCode() == KeyCode.LEFT){
            player.setVelocityX(-playerSpeed);
            //rightActive = false;
            leftActive = true;
            if(upActive){
                player.setVelocityY(-playerSpeed);
            }else if(downActive){
                player.setVelocityY(playerSpeed);
            }
        }

        if(e.getCode() == KeyCode.UP){
            player.setVelocityY(-playerSpeed);
            //downActive = false;
            upActive = true;
            if(rightActive){
                player.setVelocityX(playerSpeed);
            }else if(leftActive){
                player.setVelocityX(-playerSpeed);
            }
        }else if(e.getCode() == KeyCode.DOWN){
            player.setVelocityY(playerSpeed);
            //upActive = false;
            downActive = true;
            if(rightActive){
                player.setVelocityX(playerSpeed);
            }else if(leftActive){
                player.setVelocityX(-playerSpeed);
            }
        }
    }

    private void keyReleasedEvent(KeyEvent e){
        if(e.getCode() == KeyCode.RIGHT){
            player.setVelocityX(0);
            rightActive = false;
        }else if(e.getCode() == KeyCode.LEFT){
            player.setVelocityX(0);
            leftActive = false;
        }

        if(e.getCode() == KeyCode.UP){
            player.setVelocityY(0);
            upActive = false;
        }else if(e.getCode() == KeyCode.DOWN){
            player.setVelocityY(0);
            downActive = false;
        }
    }

    private void createPlayer(){
        player = new Player(playerView, Vector2D.Zero(), new Rectangle(200, 70), new Rectangle(0,0,getWidth(),getHeight()));

        enemy = new Enemy(enemyView, Vector2D.Zero(), new Rectangle(70, 48));
    }

    protected void OnUpdate(){
        for(GameObject enemy: enemies){
            enemy.enemyMovement(enemy);
        }
        player.update();
    }

    protected void draw(){
        GraphicsContext graphicsContext = getGraphicsContext();
        graphicsContext.drawImage(background, 0,0, getWidth(), getHeight());
        player.draw(getGraphicsContext());
        enemy.draw(getGraphicsContext());
        enemy.updateAnimation(enemyView, "com/choppyfloppy/resources/Enemy/RedBird/frame-");
        player.updateAnimation(playerView, "com/choppyfloppy/resources/Helicopter/helicopter");
    }
}
