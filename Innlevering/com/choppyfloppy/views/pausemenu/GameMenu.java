package com.choppyfloppy.views.pausemenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class GameMenu extends VBox {

        private Runnable onResumeClicked;
        private Runnable onRestartClicked;
        private Runnable onQuitToMainClicked;
        private Runnable onExitClicked;
        private Runnable onSaveClicked;

        public GameMenu() {

            FXMLLoader fxmlLoader = new FXMLLoader(GameMenu.class.getResource("stopMenu.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.setClassLoader(getClass().getClassLoader());

            try {
                fxmlLoader.load();
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }

        }

        public void setOnResumeClicked(Runnable onResumeClicked) {
            this.onResumeClicked = onResumeClicked;
        }

        public void setOnRestartClicked(Runnable onRestartClicked) {
            this.onRestartClicked = onRestartClicked;
        }

        public void setOnSaveClicked(Runnable onSaveClicked) {
        this.onSaveClicked = onSaveClicked;
    }

        public void setOnQuitToMainClicked(Runnable onQuitToMainMenuClicked) { this.onQuitToMainClicked = onQuitToMainMenuClicked; }

        public void setOnExitClicked(Runnable onExitClicked){
        this.onExitClicked = onExitClicked;
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