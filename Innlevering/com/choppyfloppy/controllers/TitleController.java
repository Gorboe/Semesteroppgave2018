package com.choppyfloppy.controllers;

import com.choppyfloppy.Main;
import com.choppyfloppy.views.titlemenu.TitleMenu;
import javafx.application.Platform;
import javafx.fxml.FXML;

import java.io.IOException;

public class TitleController {

    @FXML private TitleMenu titleMenu;

    @FXML public void initialize(){
        titleMenu.setOnStartClicked(this::startOnClick);
        titleMenu.setOnContinueClicked(this::continueOnClick);
        titleMenu.setOnExitClicked(this::exitOnClick);
    }

    private void startOnClick(){
        try{
            Main.changeScene("gameview.fxml", Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
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




}
