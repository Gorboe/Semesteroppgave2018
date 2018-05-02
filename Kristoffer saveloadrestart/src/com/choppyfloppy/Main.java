package com.choppyfloppy;

import com.choppyfloppy.controllers.GameController;
import com.choppyfloppy.core.Game;
import com.choppyfloppy.saveload.Createsavefolder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static Stage primaryStage;
    private static Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    public static final int SCREEN_WIDTH = (int)primaryScreenBounds.getMaxX();
    public static final int SCREEN_HEIGHT = (int)primaryScreenBounds.getMaxY();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;
        Createsavefolder.createDirectoryIfNotExists();
        changeScene("titleview.fxml", SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    private static Game game;
    public static Game getGame() {
        return game;
    }

    public static void changeScene(String name, int width, int height)throws IOException{
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
