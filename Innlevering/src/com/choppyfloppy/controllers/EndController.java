package com.choppyfloppy.controllers;

import com.choppyfloppy.Main;
import com.choppyfloppy.views.gameovermenu.EndMenu;
import javafx.application.Platform;
import javafx.fxml.FXML;

import java.io.IOException;


/**
 * EndController handles interaction between the view and the model "game".
 */
public class EndController {

    @FXML private EndMenu endMenu;

    /**
     * initializes the buttons in EndMenu
     */
    @FXML public void initialize(){
        endMenu.setOnNewGameClicked(this::newGameOnClick);
        endMenu.setOnMainMenuClicked(this::mainMenuOnClick);
        endMenu.setOnExitClicked(this::exitOnClick);
    }

    private void newGameOnClick(){
        try{
            Main.changeScene("gameview.fxml", Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        }catch(IOException exception){
            exception.printStackTrace();
        }
    }

    private void mainMenuOnClick(){
        try{
            Main.changeScene("titleview.fxml", Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void exitOnClick(){
        Platform.exit();
    }

    /**
     * Change scene from gameview.fxml to endview.fxml
     */
    public static void endGame(){
        try {
            Main.changeScene("endview.fxml", Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
            Main.getGame().getGameLoop().stop();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
