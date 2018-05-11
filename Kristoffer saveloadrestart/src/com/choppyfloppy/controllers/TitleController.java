package com.choppyfloppy.controllers;

import com.choppyfloppy.Main;
import com.choppyfloppy.saveload.ProgressManager;
import com.choppyfloppy.saveload.ProgressManagerFX;
import com.choppyfloppy.saveload.SaveData;
import com.choppyfloppy.views.titlemenu.TitleMenu;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * TitleController controls the main menu and
 * the switch between menu and game.
 */
public class TitleController {

    @FXML private TitleMenu titleMenu;

    /**
     * initializes the buttons in TitleMenu
     */
    @FXML public void initialize(){
        titleMenu.setOnNewGameClicked(this::newGameOnClick);
        titleMenu.setOnLoadClicked(this::loadOnClick);
        titleMenu.setOnExitClicked(this::exitOnClick);
    }

    private void newGameOnClick(){
        try{
            Main.changeScene("gameview.fxml", Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        }catch(IOException exception){
            System.out.println("feil");
        }
    }

    private void loadOnClick(){
        try {
            if (!ProgressManagerFX.isDirEmpty(Paths.get("/saveFolder"))) {
                ProgressManager progressManager = new ProgressManagerFX();
                SaveData load = progressManager.load();
                if (load != null) {
                    Main.changeScene("gameview.fxml", Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
                    Main.getGame().setScoreCount(load.getScore());
                    Main.getGame().setLevelCount(load.getCurrentLevel());
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No files available, please start a new game");
                alert.show();
            }
        } catch (IOException | ClassNotFoundException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to load game. File Corrupt");
            alert.show();
        }
    }

    private void exitOnClick(){
        Platform.exit();
    }
}
