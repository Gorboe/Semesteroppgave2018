package com.choppyfloppy.controllers;

import com.choppyfloppy.Main;
import com.choppyfloppy.saveload.ProgressManager;
import com.choppyfloppy.saveload.ProgressManagerFX;
import com.choppyfloppy.saveload.SaveData;
import com.choppyfloppy.views.pausemenu.GameMenu;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.util.Objects;

/**
 * GameController is the controller that
 * handles interaction between the view gameview.fxml
 * and the model "game".
 */
public class GameController {

    @FXML private GameMenu gameMenu;
    @FXML private GridPane root;

    /**
     * Contains a KeyEvent that pauses the game loop and brings up
     * the pausemenu by setting it to visible when you press
     * escape.
     *
     * @param scene is used to grab input
     */
    public void init(Scene scene){
        Scene scene1 = Objects.requireNonNull(scene);
        scene1.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE){
                boolean paused = !Main.getGame().isPaused();
                Main.getGame().setPaused(paused);
                gameMenu.setVisible(paused);
            }
        });
        root.getChildren().remove(Main.getGame().getCanvas());
        root.getChildren().add(1, Main.getGame().getCanvas());
    }

    /**
     * initializes the buttons in GameMenu
     */
    @FXML public void initialize(){
        gameMenu.setOnResumeClicked(this::resumeOnClick);
        gameMenu.setOnRestartClicked(this::restartOnClick);
        gameMenu.setOnSaveClicked(this::saveOnClick);
        gameMenu.setOnQuitToMainClicked(this::quitToMainOnClick);
        gameMenu.setOnExitClicked(this::exitOnClick);
        gameMenu.setVisible(false);
    }

    private void resumeOnClick(){
        boolean paused = !Main.getGame().isPaused();
        Main.getGame().setPaused(paused);
        gameMenu.setVisible(paused);
    }

    private void restartOnClick(){
        try{
            int currentLevel = Main.getGame().getLevelCount();
            int currentScore = Main.getGame().getScoreCount();
            Main.changeScene("gameview.fxml", Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
            Main.getGame().setLevelCount(currentLevel);
            Main.getGame().setScoreCount(currentScore);
        }catch(IOException exception){
            exception.printStackTrace();
        }
        gameMenu.setVisible(false);
    }

    private void saveOnClick(){
        SaveData data = new SaveData();
        data.setCurrentLevel(Main.getGame().getLevelCount());
        data.setScore(Main.getGame().getScoreCount());
        try {
            ProgressManager progressManager = new ProgressManagerFX();
            progressManager.save(data);
        } catch (IOException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "error, unable to save game");
            alert.show();
        }
    }

    private void quitToMainOnClick(){
        try{
            Main.changeScene("titleview.fxml", Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exitOnClick(){
        Platform.exit();
    }
}
