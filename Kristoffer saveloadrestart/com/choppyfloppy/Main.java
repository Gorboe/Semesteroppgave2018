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

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;
        changeScene("titleview.fxml", 500, 500);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void changeScene(String name, int width, int height)throws IOException{
        //Parent root = FXMLLoader.load(Main.class.getResource("/com/choppyfloppy/views/" + name));
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/choppyfloppy/views/" + name));

        GridPane root = loader.load();
        Scene scene = new Scene(root, width, height);

        if(name.equals("gameview.fxml")){
            Game game = new Game(root, width, height);
        }

        primaryStage.setTitle("ChoppyFloppy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
