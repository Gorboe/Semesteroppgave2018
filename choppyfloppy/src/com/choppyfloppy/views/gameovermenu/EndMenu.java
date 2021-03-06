package com.choppyfloppy.views.gameovermenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

/**
 * EndMenu is a custom control that inherits and extends VBOX.
 * Contains the buttons for the EndGame menu, and the
 * method for loading the fxml.
 */
public class EndMenu extends VBox{

    private Runnable onNewGameClicked;
    private Runnable onMainMenuClicked;
    private Runnable onExitClicked;

    /**
     * Loads the gameOver.fxml whenever EndMenu is called.
     */
    public EndMenu() {

        FXMLLoader fxmlLoader = new FXMLLoader(EndMenu.class.getResource("/com/choppyfloppy/views/gameovermenu/gameOver.fxml"));
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
     * @param onNewGameClicked - Used to connect New Game Button in EndMenu
     * to New Game Button in gameOver.fxml
     */
    public void setOnNewGameClicked(Runnable onNewGameClicked){
        this.onNewGameClicked = Objects.requireNonNull(onNewGameClicked);
    }

    /**
     * @param onMainMenuClicked - Is used to connect Main Menu Button in EndMenu
     * to Main Menu Button in gameOver.fxml
     */
    public void setOnMainMenuClicked(Runnable onMainMenuClicked) { this.onMainMenuClicked = Objects.requireNonNull(onMainMenuClicked); }

    /**
     * @param onExitClicked - Is used to connect Exit Button in EndMenu
     * to Exit Button in gameOver.fxml
     */
    public void setOnExitClicked(Runnable onExitClicked){
        this.onExitClicked = Objects.requireNonNull(onExitClicked);
    }

    @FXML
    protected void newGameClicked() {
        if (onNewGameClicked != null) {
            onNewGameClicked.run();
        }
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
