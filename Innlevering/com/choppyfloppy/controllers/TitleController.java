package com.choppyfloppy.controllers;

import com.choppyfloppy.Main;
import com.choppyfloppy.saveload.loadgame;
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
        loadgame.readFile();
    }

    private void exitOnClick(){
        Platform.exit();
    }




}
