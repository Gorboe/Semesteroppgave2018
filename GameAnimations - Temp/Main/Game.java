package Main;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Game extends GameEngine{

    //global
    private Image background = new Image("Main/Resources/Background/citybackground.jpg");
    private Player player;
    private boolean rightActive, leftActive, upActive, downActive = false;
    private final int playerSpeed = 5;
    private final int bulletSpeed = 15;
    private boolean normalRight = true;
    private boolean normalLeft = true;
    private ImageView playerImageView = new ImageView();
    private List<GameObject> bullets = new ArrayList<>();

    public Game(Pane window, int width, int height){
        super(window, width, height);
        createContent();
    }

    private void createContent(){
        createPlayer();
        getWindow().getScene().setOnKeyPressed(this::keyPressedEvent);
        getWindow().getScene().setOnKeyReleased(this::keyReleasedEvent);
        getWindow().getScene().setOnMousePressed(this::mousePressedEvent);
    }

    public void createPlayer(){
        player = new Player(playerImageView);
        player.setVelocity(new Point2D(0,0));
        addGameObject(player, 100, 100);
    }

    private void addGameObject(GameObject object, double x, double y){
        object.getView().setTranslateX(x);
        object.getView().setTranslateY(y);
        getWindow().getChildren().add(object.getView());
    }

    private void addBullet(GameObject bullet, double x, double y){
        bullets.add(bullet);
        addGameObject(bullet, x, y);
    }

    private void mousePressedEvent(MouseEvent e){
        Vector2D playerPosition, mousePosition, aimDirection;
        double normalizedX, normalizedY;
        Bullet bullet = new Bullet();
        playerPosition = new Vector2D(player.getView().getTranslateX()+160, player.getView().getTranslateY()+65);
        //System.out.println("x: " + player.getView().getTranslateX() + "   " + "y: " + player.getView().getTranslateY());

        mousePosition = new Vector2D(e.getX(), e.getY());
        //System.out.println("x: " + e.getX() + "  " + "y: " + e.getY());


        aimDirection = subVector(playerPosition, mousePosition);
        normalizedX = aimDirection.getX() / Math.sqrt(Math.pow(aimDirection.getX(), 2) + Math.pow(aimDirection.getY(), 2));
        normalizedY = aimDirection.getY() / Math.sqrt(Math.pow(aimDirection.getX(), 2) + Math.pow(aimDirection.getY(), 2));

       //System.out.println(normalizedX + "  " + normalizedY);
        bullet.setVelocity(new Point2D( bulletSpeed * normalizedX, bulletSpeed * normalizedY));
        addBullet(bullet, player.getView().getTranslateX()+160, player.getView().getTranslateY()+65);
    }

    private Vector2D subVector(Vector2D vector1, Vector2D vector2){
        double newX = vector2.getX() - vector1.getX();
        double newY = vector2.getY() - vector1.getY();
        return new Vector2D(newX, newY);
    }

    private void keyPressedEvent(KeyEvent e){
        if(e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D){
            //System.out.println("Right");
            player.setVelocity(new Point2D(playerSpeed,0));
            if(normalRight){
                player.rotateRight();
                normalRight = false;
                player.setVelocity(new Point2D(playerSpeed,0));
            }
            rightActive = true;
            if(upActive){
                player.setVelocity(new Point2D(playerSpeed,-playerSpeed));
            }else if(downActive){
                player.setVelocity(new Point2D(playerSpeed,playerSpeed));
            }
        }else if(e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.A){
            //System.out.println("Left");
            player.setVelocity(new Point2D(-playerSpeed,0));
            if(normalLeft){
                player.rotateLeft();
                normalLeft = false;
                player.setVelocity(new Point2D(-playerSpeed,0));
            }
            leftActive = true;
            if(upActive){
                player.setVelocity(new Point2D(-playerSpeed,-playerSpeed));
            }else if(downActive){
                player.setVelocity(new Point2D(-playerSpeed,playerSpeed));
            }
        }

        if(e.getCode() == KeyCode.UP || e.getCode() == KeyCode.W){
            //System.out.println("Up");
            player.setVelocity(new Point2D(0,-playerSpeed));
            upActive = true;
            if(rightActive){
                player.setVelocity(new Point2D(playerSpeed, -playerSpeed));
            }else if(leftActive){
                player.setVelocity(new Point2D(-playerSpeed, -playerSpeed));
            }
        }else if(e.getCode() == KeyCode.DOWN || e.getCode() == KeyCode.S){
            //System.out.println("Down");
            player.setVelocity(new Point2D(0,playerSpeed));
            downActive = true;
            if(rightActive){
                player.setVelocity(new Point2D(playerSpeed, playerSpeed));
            }else if(leftActive){
                player.setVelocity(new Point2D(-playerSpeed, playerSpeed));
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
                player.setVelocity(new Point2D(0, -playerSpeed));
            }else if(downActive){
                player.setVelocity(new Point2D(0, playerSpeed));
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
                player.setVelocity(new Point2D(0, -playerSpeed));
            }else if(downActive){
                player.setVelocity(new Point2D(0, playerSpeed));
            }
        }

        if(e.getCode() == KeyCode.UP || e.getCode() == KeyCode.W){
            upActive = false;
            player.setVelocity(new Point2D(0,0));
            if(rightActive){
                player.setVelocity(new Point2D(playerSpeed, 0));
            }else if(leftActive){
                player.setVelocity(new Point2D(-playerSpeed, 0));
            }
        }else if(e.getCode() == KeyCode.DOWN || e.getCode() == KeyCode.S){
            downActive = false;
            player.setVelocity(new Point2D(0,0));
            if(rightActive){
                player.setVelocity(new Point2D(playerSpeed, 0));
            }else if(leftActive){
                player.setVelocity(new Point2D(-playerSpeed,0));
            }
        }
    }

    protected void OnUpdate(){
        player.update();
        bullets.forEach(GameObject::update);
    }

    protected void draw(){
        GraphicsContext graphicsContext = getGraphicsContext();

        graphicsContext.getCanvas().getGraphicsContext2D().drawImage(background, 0,0,getWindow().getWidth(), getWindow().getHeight());
        player.updatePlayerAnimation(playerImageView);
    }
}
