package sample;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class Game extends GameEngine {

    private Player player;
    private boolean rightActive, leftActive, upActive, downActive = false;
    private int xSpeed = 5;
    private int ySpeed = 5;

    public Game(GridPane window, int width, int height){
        super(window, width, height);
        createContent();
    }

    private void createContent(){
        createPlayer();
        getWindow().getScene().setOnKeyPressed(this::keyPressedEvent);
        getWindow().getScene().setOnKeyReleased(this::keyReleasedEvent);
    }

    private void createPlayer(){
        player = new Player();
        player.setVelocity(new Point2D(0,0));
        addGameObject(player,200, 200); //puts player on the scene in x=200, y=200
    }

    private void addGameObject(GameObject object, double x, double y){
        object.getView().setTranslateX(x);
        object.getView().setTranslateY(y);
        getWindow().getChildren().add(object.getView());
    }

    private void keyPressedEvent(KeyEvent e){
        if(e.getCode() == KeyCode.RIGHT){
            //System.out.println("Right");
            player.setVelocity(new Point2D(xSpeed,0));
            rightActive = true;
            if(upActive){
                player.setVelocity(new Point2D(xSpeed,-ySpeed));
            }else if(downActive){
                player.setVelocity(new Point2D(xSpeed,ySpeed));
            }
        }else if(e.getCode() == KeyCode.LEFT){
            //System.out.println("Left");
            player.setVelocity(new Point2D(-xSpeed,0));
            leftActive = true;
            if(upActive){
                player.setVelocity(new Point2D(-xSpeed,-ySpeed));
            }else if(downActive){
                player.setVelocity(new Point2D(-xSpeed,ySpeed));
            }
        }

        if(e.getCode() == KeyCode.UP){
            //System.out.println("Up");
            player.setVelocity(new Point2D(0,-ySpeed));
            upActive = true;
            if(rightActive){
                player.setVelocity(new Point2D(xSpeed, -ySpeed));
            }else if(leftActive){
                player.setVelocity(new Point2D(-xSpeed, -ySpeed));
            }
        }else if(e.getCode() == KeyCode.DOWN){
            //System.out.println("Down");
            player.setVelocity(new Point2D(0,ySpeed));
            downActive = true;
            if(rightActive){
                player.setVelocity(new Point2D(xSpeed, ySpeed));
            }else if(leftActive){
                player.setVelocity(new Point2D(-xSpeed, ySpeed));
            }
        }
    }

    private void keyReleasedEvent(KeyEvent e){
        if(e.getCode() == KeyCode.RIGHT){
            rightActive = false;
            player.setVelocity(new Point2D(0, 0));
            if(upActive){
                player.setVelocity(new Point2D(0, -ySpeed));
            }else if(downActive){
                player.setVelocity(new Point2D(0, ySpeed));
            }
        }else if(e.getCode() == KeyCode.LEFT){
            leftActive = false;
            player.setVelocity(new Point2D(0,0));
            if(upActive){
                player.setVelocity(new Point2D(0, -ySpeed));
            }else if(downActive){
                player.setVelocity(new Point2D(0, ySpeed));
            }
        }

        if(e.getCode() == KeyCode.UP){
            upActive = false;
            player.setVelocity(new Point2D(0,0));
            if(rightActive){
                player.setVelocity(new Point2D(xSpeed, 0));
            }else if(leftActive){
                player.setVelocity(new Point2D(-xSpeed, 0));
            }
        }else if(e.getCode() == KeyCode.DOWN){
            downActive = false;
            player.setVelocity(new Point2D(0,0));
            if(rightActive){
                player.setVelocity(new Point2D(xSpeed, 0));
            }else if(leftActive){
                player.setVelocity(new Point2D(-xSpeed,0));
            }
        }
    }


    protected void onUpdate(){
        player.update();
    }
}
