package com.choppyfloppy.views.titlemenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class TitleMenu extends VBox {

    private Runnable onNewGameClicked;
    private Runnable onContinueClicked;
    private Runnable onExitClicked;

    public TitleMenu() {

        FXMLLoader fxmlLoader = new FXMLLoader(TitleMenu.class.getResource("startMenu.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.setClassLoader(getClass().getClassLoader());

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    public void setOnNewGameClicked(Runnable onStartClicked) {
        this.onNewGameClicked = onStartClicked;
    }
    public void setOnContinueClicked(Runnable onContinueClicked){this.onContinueClicked = onContinueClicked;}
    public void setOnExitClicked(Runnable onExitClicked){this.onExitClicked = onExitClicked;}

    @FXML
    protected void newGameClicked(){
        if (onNewGameClicked != null){
            onNewGameClicked.run();
        }
    }

    @FXML
    protected void continueClicked(){
        if(onContinueClicked != null){
            onContinueClicked.run();
        }
    }

    @FXML
    protected void exitClicked(){
        if(onExitClicked != null){
            onExitClicked.run();
        }
    }

}
