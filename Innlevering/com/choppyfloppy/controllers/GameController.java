package com.choppyfloppy.controllers;

import com.choppyfloppy.Game;
import com.choppyfloppy.Main;
import com.choppyfloppy.views.pausemenu.GameMenu;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Objects;

public class GameController {



    @FXML private GameMenu gameMenu;
    @FXML private GridPane root;
    private Scene scene;

    public void init(Scene scene){
        this.scene = Objects.requireNonNull(scene);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE){
                System.out.println("Escape");

                boolean paused = !Main.getGame().isPaused();
                Main.getGame().setPaused(paused);
                gameMenu.setVisible(paused);


            }
        });

        root.getChildren().remove(Main.getGame().getCanvas());
        root.getChildren().add(1, Main.getGame().getCanvas());



    }

    @FXML public void initialize(){

        gameMenu.setOnResumeClicked(this::resumeOnClick);
        gameMenu.setOnRestartClicked(this::restartOnClick);
        gameMenu.setOnQuitToMainClicked(this::quitToMainOnClick);
        gameMenu.setOnExitClicked(this::exitOnClick);


        gameMenu.setVisible(false);



    }

    private void resumeOnClick(){
        //set visibility of menu = 0.
        //start gameloop.
    }

    private void restartOnClick(){
        //set killscore = 0, set position = x= 10, y = 10, update score, load current level.
        System.out.println("restart");

        try{
            int currentLevel = Main.getGame().getLevelCount();
            Main.changeScene("gameview.fxml", Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
            Main.getGame().setLevelCount(currentLevel);
        }catch(IOException exception){
            System.out.println("feil");
        }

        gameMenu.setVisible(false);
    }

    private void quitToMainOnClick(){
        try{
            Main.changeScene("titleview.fxml", 800, 800);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exitOnClick(){
        Platform.exit();
    }


}
