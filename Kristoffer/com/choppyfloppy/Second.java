package com.choppyfloppy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Second extends Application {

        private static Stage secondaryStage;

        @Override
        public void start(Stage secondaryStage) throws Exception{
            com.choppyfloppy.Second.secondaryStage = secondaryStage;
            changeScene("gameview.fxml", 500, 500);
        }

        public static void main(String[] args) {
            launch(args);
        }

        public static void changeScene(String name, int width, int height)throws IOException {
            //Parent root = FXMLLoader.load(Main.class.getResource("/com/choppyfloppy/views/" + name));
            FXMLLoader loader = new FXMLLoader(com.choppyfloppy.Main.class.getResource("/com/choppyfloppy/views/" + name));

            GridPane root = loader.load();
            Scene scene = new Scene(root, width, height);

            if(name.equals("titleview.fxml")){
                Game game = new Game(root, width, height);
            }

            secondaryStage.setTitle("ChoppyFloppy");
            secondaryStage.setScene(scene);
            secondaryStage.show();
        }
    }

