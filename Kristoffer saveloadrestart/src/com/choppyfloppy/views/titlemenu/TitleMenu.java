package com.choppyfloppy.views.titlemenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * TitleMenu contains the buttons for the Main Menu Menu, and the
 * method for loading the fxml.
 */
public class TitleMenu extends VBox {

    private Runnable onNewGameClicked;
    private Runnable onContinueClicked;
    private Runnable onExitClicked;

    /**
     * Loads the startMenu.fxml whenever the method is called.
     */
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

    /**
     * @param onStartClicked - Is used to connect New Game Button in Main Menu
     * to New Game Button in startMenu.fxml
     */
    public void setOnNewGameClicked(Runnable onStartClicked) {
        this.onNewGameClicked = onStartClicked;
    }

    /**
     * @param onContinueClicked - Is used to connect Continue Button in Main Menu
     * to Continue Button in startMenu.fxml
     */
    public void setOnContinueClicked(Runnable onContinueClicked){this.onContinueClicked = onContinueClicked;}

    /**
     * @param onExitClicked - Is used to connect Exit Button in Main Menu
     * to Exit Button in startMenu.fxml
     */
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
