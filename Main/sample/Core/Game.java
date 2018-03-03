package sample.Core;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import sample.Objects.Bullet;
import sample.Objects.Enemy;
import sample.Objects.Player;

import java.util.ArrayList;
import java.util.List;

public class Game extends GameEngine {

    private Player player;
    private boolean rightActive, leftActive, upActive, downActive = false;
    private boolean right, left, up, down = false;
    private double xSpeed = 5;
    private double ySpeed = 5;
    private List<GameObject> bullets = new ArrayList<>(); //list of bullets
    private List<GameObject> enemies = new ArrayList<>(); //list of enemies
    private int playerLife = 3; //life of player
    private int killCount = 0;

    public Game(GridPane window, int width, int height){
        super(window, width, height);
        createContent();
    }

    private void createContent(){
        createPlayer();
        getWindow().getScene().setOnKeyPressed(this::keyPressedEvent);
        getWindow().getScene().setOnKeyReleased(this::keyReleasedEvent);
        getWindow().getScene().setOnMousePressed(this::mousePressedEvent);
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

    //adds bullet to the array-list of many bullets
    private void addBullet(GameObject bullet, double x, double y){
        bullets.add(bullet);
        addGameObject(bullet, x, y);
    }

    private void addEnemy(GameObject enemy, double x, double y){
        enemies.add(enemy);
        addGameObject(enemy, x, y);
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

    private void mousePressedEvent(MouseEvent e) {
        Vector2D playerPosition, mousePosition, aimDirection;
        double normalizedX, normalizedY;
        Bullet bullet = new Bullet();
        playerPosition = new Vector2D(player.getView().getTranslateX(), player.getView().getTranslateY());
        mousePosition = new Vector2D(e.getX(), e.getY());
        aimDirection = subVector(playerPosition, mousePosition);
        normalizedX = aimDirection.getX() / Math.sqrt(Math.pow(aimDirection.getX(), 2) + Math.pow(aimDirection.getY(), 2));
        normalizedY = aimDirection.getY() / Math.sqrt(Math.pow(aimDirection.getX(), 2) + Math.pow(aimDirection.getY(), 2));
        //System.out.println(normalizedX + "  " + normalizedY);
        bullet.setVelocity(new Point2D(2 * xSpeed * normalizedX, 2 * ySpeed * normalizedY));
        addBullet(bullet, player.getView().getTranslateX(), player.getView().getTranslateY());
    }

    private Vector2D subVector(Vector2D vector1, Vector2D vector2){
        double newVectorX = vector2.getX() - vector1.getX();
        double newVectorY = vector2.getY() - vector1.getY();
        return new Vector2D(newVectorX, newVectorY);
    }

    //Enemy movement logic
    private void enemyMovement(GameObject enemy){
        final double xSpeedEnemy = 1;
        final double ySpeedEnemy = 1;
        if(player.getView().getTranslateX() > enemy.getView().getTranslateX()){
            enemy.setVelocity(new Point2D(xSpeedEnemy, 0));
            right = true;
            left = false;
            if(up){
                enemy.setVelocity(new Point2D(xSpeedEnemy, ySpeedEnemy));
            }else if(down){
                enemy.setVelocity(new Point2D(xSpeedEnemy, -ySpeedEnemy));
            }
        }else if(player.getView().getTranslateX() < enemy.getView().getTranslateX()){
            enemy.setVelocity(new Point2D(-xSpeedEnemy,0));
            left = true;
            right = false;
            if(up){
                enemy.setVelocity(new Point2D(-xSpeedEnemy, ySpeedEnemy));
            }else if(down){
                enemy.setVelocity(new Point2D(-xSpeedEnemy, -ySpeedEnemy));
            }
        }

        if(player.getView().getTranslateY() > enemy.getView().getTranslateY()){
            enemy.setVelocity(new Point2D(0, ySpeedEnemy));
            up = true;
            down = false;
            if(right){
                enemy.setVelocity(new Point2D(xSpeedEnemy, ySpeedEnemy));
            }else if(left){
                enemy.setVelocity(new Point2D(-xSpeedEnemy, ySpeedEnemy));
            }
        }else if(player.getView().getTranslateY() < enemy.getView().getTranslateY()){
            enemy.setVelocity(new Point2D(0, -ySpeedEnemy));
            down = true;
            up = false;
            if(right){
                enemy.setVelocity(new Point2D(xSpeedEnemy, -ySpeedEnemy));
            }else if(left){
                enemy.setVelocity(new Point2D(-xSpeedEnemy, -ySpeedEnemy));
            }
        }
    }

    protected void onUpdate(){
        for(GameObject enemy: enemies){
            enemyMovement(enemy); //Enemy movement logic
        }

        //removal of bullets an enemies on hit
        for(GameObject bullet: bullets){
            for(GameObject enemy: enemies){
                if(bullet.isColliding(enemy)){
                    bullet.setAlive(false);
                    enemy.setAlive(false);
                    killCount++;
                    //System.out.println(killCount);
                    getWindow().getChildren().removeAll(bullet.getView(), enemy.getView());
                }
            }
        }

        for(GameObject enemy: enemies){
            if(player.isColliding(enemy)){
                enemy.setAlive(false);
                playerLife--;
                System.out.println("Player got: " + playerLife + " life remaining");
                if(playerLife == 0){
                    player.setAlive(false);
                    System.out.println("Game over\n" + "Your final score was: " + killCount);
                    getWindow().getChildren().removeAll(player.getView());
                    getGameLoop().stop();
                }
                getWindow().getChildren().removeAll(enemy.getView());
            }
        }
        bullets.removeIf(GameObject::isDead);
        enemies.removeIf(GameObject::isDead);

        player.update();
        bullets.forEach(GameObject::update); //updates the movement of every bullet
        enemies.forEach(GameObject::update);


        if(Math.random() < 0.03){
            Enemy enemy = new Enemy();
            enemy.setVelocity(new Point2D(0,0));
            addEnemy(enemy, getWindow().getWidth(), Math.random() * getWindow().getPrefHeight());
        }
    }
}
