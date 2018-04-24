package com.choppyfloppy;

import com.choppyfloppy.controllers.GameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    private static Stage primaryStage;

    public static final int SCREEN_WIDTH = 500;
    public static final int SCREEN_HEIGHT = 500;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;
        changeScene("titleview.fxml", 500, 500);
    }

    private static Game game;

    public static Game getGame() {
        return game;
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
            game = new Game(root, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
            GameController gameController = loader.getController();
            gameController.init(scene);
        }

        primaryStage.setTitle("ChoppyFloppy");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
