package com.choppyfloppy.controllers;

import com.choppyfloppy.Main;
import com.choppyfloppy.saveload.SaveLoadManager;
import com.choppyfloppy.saveload.VariablesSaved;
import com.choppyfloppy.views.titlemenu.TitleMenu;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.nio.file.Files;
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
        titleMenu.setOnContinueClicked(this::continueOnClick);
        titleMenu.setOnExitClicked(this::exitOnClick);
    }

    private void newGameOnClick(){
        try{
            Main.changeScene("gameview.fxml", Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        }catch(IOException exception){
            System.out.println("feil");
        }
    }

    private void continueOnClick(){

        if (!Files.exists(Paths.get("saveFolder/save.txt"))) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to load game, file not found. Please start a new game");
            alert.show();
            return;
        }

        try {
            VariablesSaved load = (VariablesSaved) SaveLoadManager.loadGame("saveFolder/save.txt");
            Main.changeScene("gameview.fxml", Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
            Main.getGame().setScoreCount(load.getScore());
            Main.getGame().setLevelCount(load.getCurrentLevel());
        } catch (IOException | ClassNotFoundException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to load game. File Corrupt");
            alert.show();
        }
    }

    private void exitOnClick(){
        Platform.exit();
    }
}
