package com.choppyfloppy.views.pausemenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

/**
 * GameMenu is a custom control that inherits and extends VBOX.
 * Contains the buttons for the Pause menu, and the
 * method for loading the fxml.
 */
public class GameMenu extends VBox {


        private Runnable onResumeClicked;
        private Runnable onRestartClicked;
        private Runnable onQuitToMainClicked;
        private Runnable onExitClicked;
        private Runnable onSaveClicked;

    /**
     * Loads the stopMenu.fxml whenever the method is called.
     */
        public GameMenu() {

            FXMLLoader fxmlLoader = new FXMLLoader(GameMenu.class.getResource("/com/choppyfloppy/views/pausemenu/stopMenu.fxml"));
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
     * @param onResumeClicked - Is used to connect Resume Button in Pause Menu
     * to Resume Button in stopMenu.fxml
     */
        public void setOnResumeClicked(Runnable onResumeClicked) {
            this.onResumeClicked = Objects.requireNonNull(onResumeClicked);
        }

    /**
     * @param onRestartClicked - Is used to connect Restart Button in Pause Menu
     * to Restart Button in stopMenu.fxml
     */
        public void setOnRestartClicked(Runnable onRestartClicked) {
            this.onRestartClicked = Objects.requireNonNull(onRestartClicked);
        }

    /**
     * @param onSaveClicked - Is used to connect Save Button in Pause Menu
     * to Save Button in stopMenu.fxml
     */
        public void setOnSaveClicked(Runnable onSaveClicked) {
        this.onSaveClicked = Objects.requireNonNull(onSaveClicked);
    }

    /**
     * @param onQuitToMainMenuClicked - Is used to connect Main Menu Button in Pause Menu
     * to Main Menu Button in stopMenu.fxml
     */
        public void setOnQuitToMainClicked(Runnable onQuitToMainMenuClicked) {
            this.onQuitToMainClicked = Objects.requireNonNull(onQuitToMainMenuClicked);
        }

    /**
     * @param onExitClicked - Is used to connect Exit Button in Pause Menu
     * to Exit Button in stopMenu.fxml
     */
        public void setOnExitClicked(Runnable onExitClicked){
        this.onExitClicked = Objects.requireNonNull(onExitClicked);
    }

        @FXML
        protected void resumeClicked() {
            if (onResumeClicked != null) {
                onResumeClicked.run();
            }
        }

        @FXML
        protected void restartClicked() {
            if (onRestartClicked != null) {
                onRestartClicked.run();
            }
        }
        @FXML
        protected void saveClicked() {
            if (onSaveClicked != null) {
                onSaveClicked.run();
            }
        }


        @FXML
        protected void quitToMainMenuClicked() {
            if (onQuitToMainClicked != null) {
                onQuitToMainClicked.run();
            }
        }

        @FXML
        protected void exitClicked(){
            if(onExitClicked != null){
                onExitClicked.run();
            }
        }
}