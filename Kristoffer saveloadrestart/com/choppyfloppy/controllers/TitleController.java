package com.choppyfloppy.controllers;

import com.choppyfloppy.Main;
import com.choppyfloppy.saveload.ResourceManager;
import com.choppyfloppy.saveload.SaveData;
import com.choppyfloppy.views.titlemenu.TitleMenu;
import javafx.application.Platform;
import javafx.fxml.FXML;

import java.io.IOException;

public class TitleController {

    @FXML private TitleMenu titleMenu;

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
        try {
            System.out.println("Jeg virker load");
            SaveData load = (SaveData) ResourceManager.loadGame("saveFolder/save.txt");
            Main.changeScene("gameview.fxml", Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
            Main.getGame().setScoreCount(load.score);
            Main.getGame().setLevelCount(load.currentLevel);


        } catch (Exception ev) {
            System.out.println("Could not load save data: " + ev.getMessage());
        }
        //loadgame.readFile();
    }

    private void exitOnClick(){
        Platform.exit();
    }




}
