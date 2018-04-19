package com.choppyfloppy.controllers;

import com.choppyfloppy.Main;
import com.choppyfloppy.views.pausemenu.GameMenu;
import com.choppyfloppy.views.titlemenu.TitleMenu;
import javafx.application.Platform;
import javafx.fxml.FXML;

import java.beans.Visibility;
import java.io.IOException;

public class TitleController {

    @FXML private TitleMenu titleMenu;
    @FXML private GameMenu gameMenu;

    @FXML public void initialize(){
        titleMenu.setOnStartClicked(this::startOnClick);
        titleMenu.setOnContinueClicked(this::continueOnClick);
        titleMenu.setOnExitClicked(this::exitOnClick);
        gameMenu.setOnResumeClicked(this::resumeOnClick);
        gameMenu.setOnRestartClicked(this::restartOnClick);
        gameMenu.setOnQuitToMainClicked(this::quitToMainOnClick);
    }

    private void startOnClick(){
        try{
            Main.changeScene("gameview.fxml", 800, 800);
        }catch(IOException exception){
            System.out.println("feil");
        }
    }

    private void continueOnClick(){
        System.out.println("Continnue funker");
    }

    private void exitOnClick(){
        Platform.exit();
    }

    private void resumeOnClick(){
        //set visibility of menu = 0.
        //start gameloop.
    }

    private void restartOnClick(){
        //set killscore = 0, set position = x= 10, y = 10, update score, load current level.
    }

    private void quitToMainOnClick(){
        /*try{
            Main.changeScene("titleview.fxml", 800, 800);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }


}
