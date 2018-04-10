package com.choppyfloppy.controllers;

import com.choppyfloppy.Main;
import com.choppyfloppy.menu.TitleMenu;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

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
            Main.changeScene("gameview.fxml");
        }catch(IOException exception){
            System.out.println("feil");
        }
    }

    private void continueOnClick(){
        System.out.print("funker");
    }

    private void exitOnClick(){
        Platform.exit();
    }
}
