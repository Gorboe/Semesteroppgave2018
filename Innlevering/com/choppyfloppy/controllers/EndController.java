package com.choppyfloppy.controllers;

import com.choppyfloppy.Main;
import com.choppyfloppy.views.gameovermenu.EndMenu;
import javafx.application.Platform;
import javafx.fxml.FXML;

import java.io.IOException;

public class EndController {

    @FXML private EndMenu endMenu;

    @FXML public void initialize(){
        endMenu.setOnMainMenuClicked(this::mainMenuOnClick);
        endMenu.setOnExitClicked(this::exitOnClick);
    }

    private void mainMenuOnClick(){
        try{
            Main.changeScene("titleview.fxml", Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exitOnClick(){
        Platform.exit();
    }

    public static void endGame(){
        System.out.println("endgame slår inn");
        try {
            Main.changeScene("endview.fxml", Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
            Main.getGame().getGameLoop().stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /*public void init(Scene scene){
        this.scene = Objects.requireNonNull(scene);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE){
                System.out.println("Escape");

                boolean paused = !Main.getGame().isPaused();
                Main.getGame().setPaused(paused);
                endMenu.setVisible(paused);


            }
        });



        root.getChildren().remove(Main.getGame().getCanvas());
        root.getChildren().add(1, Main.getGame().getCanvas());



    }
    */

}
