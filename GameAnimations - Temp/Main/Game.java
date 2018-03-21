package Main;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class Game extends GameEngine{

    //global
    private Image heli1, heli2, heli3, heli4;
    private ImageView imageView;
    private int test = 0;
    private Player player;
    private boolean rightActive, leftActive, upActive, downActive = false;
    private int xSpeed = 5;
    private int ySpeed = 5;
    private boolean normalRight = true;
    private boolean normalLeft = true;

    public Game(GridPane window, int width, int height){
        super(window, width, height);
        createContent();
    }

    private void createContent(){
        createPlayer();
        getWindow().getScene().setOnKeyPressed(this::keyPressedEvent);
        getWindow().getScene().setOnKeyReleased(this::keyReleasedEvent);
    }

    public void createPlayer(){
        player = new Player();
        player.setVelocity(new Point2D(0,0));
        addPlayer(player, 100, 100);
        /*imageView = new ImageView();
        heli1 = new Image("Main/Resources/heli-1.png");
        heli2 = new Image("Main/Resources/heli-2.png");
        heli3 = new Image("Main/Resources/heli-3.png");
        heli4 = new Image("Main/Resources/heli-4.png");
        imageView.setImage(heli1);
        test = 1;
        imageView.setPreserveRatio(true);
        getWindow().getChildren().add(imageView);*/
    }

    private void addPlayer(Player player, double x, double y){
        player.setX(x);
        player.setY(y);
        getWindow().getChildren().add(player.getPlayerImageView());
    }

    private void keyPressedEvent(KeyEvent e){
        if(e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D){
            //System.out.println("Right");
            player.setVelocity(new Point2D(xSpeed,0));
            if(normalRight){
                player.rotateRight();
                normalRight = false;
                player.setVelocity(new Point2D(xSpeed,0));
            }
            rightActive = true;
            if(upActive){
                player.setVelocity(new Point2D(xSpeed,-ySpeed));
            }else if(downActive){
                player.setVelocity(new Point2D(xSpeed,ySpeed));
            }
        }else if(e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.A){
            //System.out.println("Left");
            player.setVelocity(new Point2D(-xSpeed,0));
            if(normalLeft){
                player.rotateLeft();
                normalLeft = false;
                player.setVelocity(new Point2D(-xSpeed,0));
            }
            leftActive = true;
            if(upActive){
                player.setVelocity(new Point2D(-xSpeed,-ySpeed));
            }else if(downActive){
                player.setVelocity(new Point2D(-xSpeed,ySpeed));
            }
        }

        if(e.getCode() == KeyCode.UP || e.getCode() == KeyCode.W){
            //System.out.println("Up");
            player.setVelocity(new Point2D(0,-ySpeed));
            upActive = true;
            if(rightActive){
                player.setVelocity(new Point2D(xSpeed, -ySpeed));
            }else if(leftActive){
                player.setVelocity(new Point2D(-xSpeed, -ySpeed));
            }
        }else if(e.getCode() == KeyCode.DOWN || e.getCode() == KeyCode.S){
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
        if(e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D){
            rightActive = false;
            if(!normalRight){
                player.rotateLeft();
                normalRight = true;
                player.setVelocity(new Point2D(0,0));
            }
            player.setVelocity(new Point2D(0, 0));
            if(upActive){
                player.setVelocity(new Point2D(0, -ySpeed));
            }else if(downActive){
                player.setVelocity(new Point2D(0, ySpeed));
            }
        }else if(e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.A){
            leftActive = false;
            player.setVelocity(new Point2D(0,0));
            if(!normalLeft){
                player.rotateRight();
                normalLeft = true;
                player.setVelocity(new Point2D(0,0));
            }
            if(upActive){
                player.setVelocity(new Point2D(0, -ySpeed));
            }else if(downActive){
                player.setVelocity(new Point2D(0, ySpeed));
            }
        }

        if(e.getCode() == KeyCode.UP || e.getCode() == KeyCode.W){
            upActive = false;
            player.setVelocity(new Point2D(0,0));
            if(rightActive){
                player.setVelocity(new Point2D(xSpeed, 0));
            }else if(leftActive){
                player.setVelocity(new Point2D(-xSpeed, 0));
            }
        }else if(e.getCode() == KeyCode.DOWN || e.getCode() == KeyCode.S){
            downActive = false;
            player.setVelocity(new Point2D(0,0));
            if(rightActive){
                player.setVelocity(new Point2D(xSpeed, 0));
            }else if(leftActive){
                player.setVelocity(new Point2D(-xSpeed,0));
            }
        }
    }

    protected void OnUpdate(){
        player.update();
    }

    protected void draw(){
        GraphicsContext graphicsContext = getGraphicsContext();
        player.updateAnimation();
    }
}
