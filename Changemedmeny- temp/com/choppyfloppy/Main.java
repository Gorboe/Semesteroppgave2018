package com.choppyfloppy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;
        changeScene("titleview.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void changeScene(String name)throws IOException{
        Parent root = FXMLLoader.load(Main.class.getResource("/com/choppyfloppy/views/" + name));
        primaryStage.setTitle("The game");

        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
}
