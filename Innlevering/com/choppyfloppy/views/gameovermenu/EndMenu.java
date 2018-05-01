package com.choppyfloppy.views.gameovermenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class EndMenu extends VBox{

    private Runnable onMainMenuClicked;
    private Runnable onExitClicked;

    public EndMenu() {

        FXMLLoader fxmlLoader = new FXMLLoader(EndMenu.class.getResource("gameOver.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.setClassLoader(getClass().getClassLoader());

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    //fxmlLoaderEnd

    public void setOnMainMenuClicked(Runnable onMainMenuClicked) { this.onMainMenuClicked = onMainMenuClicked; }
    public void setOnExitClicked(Runnable onExitClicked){
        this.onExitClicked = onExitClicked;
    }

    @FXML
    protected void mainMenuClicked() {
        if (onMainMenuClicked != null) {
            onMainMenuClicked.run();
        }
    }

    @FXML
    protected void exitClicked(){
        if(onExitClicked != null){
            onExitClicked.run();
        }
    }
}
