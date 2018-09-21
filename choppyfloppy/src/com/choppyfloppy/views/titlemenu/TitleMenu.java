package com.choppyfloppy.views.titlemenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

/**
 * TitleMenu is a custom control that inherits and extends VBOX.
 * Contains the buttons for the Pause menu, and the
 * method for loading the fxml.
 */
public class TitleMenu extends VBox {

    private Runnable onNewGameClicked;
    private Runnable onLoadClicked;
    private Runnable onExitClicked;

    /**
     * Loads the startMenu.fxml whenever the method is called.
     */
    public TitleMenu() {

        FXMLLoader fxmlLoader = new FXMLLoader(TitleMenu.class.getResource("/com/choppyfloppy/views/titlemenu/startMenu.fxml"));
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
        this.onNewGameClicked = Objects.requireNonNull(onStartClicked);
    }

    /**
     * @param onContinueClicked - Is used to connect Continue Button in Main Menu
     * to Continue Button in startMenu.fxml
     */
    public void setOnLoadClicked(Runnable onContinueClicked){this.onLoadClicked = Objects.requireNonNull(onContinueClicked);}

    /**
     * @param onExitClicked - Is used to connect Exit Button in Main Menu
     * to Exit Button in startMenu.fxml
     */
    public void setOnExitClicked(Runnable onExitClicked){this.onExitClicked = Objects.requireNonNull(onExitClicked);}

    @FXML
    protected void newGameClicked(){
        if (onNewGameClicked != null){
            onNewGameClicked.run();
        }
    }

    @FXML
    protected void loadClicked(){
        if(onLoadClicked != null){
            onLoadClicked.run();
        }
    }

    @FXML
    protected void exitClicked(){
        if(onExitClicked != null){
            onExitClicked.run();
        }
    }
}
