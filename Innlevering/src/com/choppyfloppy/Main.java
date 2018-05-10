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
    private static Game game;

    /**
     * Start method is responsible for setting the stage,
     * creating folders for saving, and calls upon
     * changeScene method to make titleview.fxml the starting
     * view.
     * @param primaryStage - instantiates the primary stage.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;
        Createsavefolder.createDirectoryIfNotExists();
        changeScene("titleview.fxml", SCREEN_WIDTH, SCREEN_HEIGHT);
    }


    /**
     * Method that creates a getter for Game, given it is
     * a private data field.
     */
    public static Game getGame() {
        return game;
    }

    /**
     * Method for changing the scene. Will set the primary stage to
     * titleview, and changes scene when called upon.
     *
     * @param name - Is the name of the fxml view file.
     * @param width - Sets the width of the Canvas.
     * @param height - Sets the height of the Canvas.
     * @throws IOException
     */
    public static void changeScene(String name, int width, int height)throws IOException{
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/choppyfloppy/views/" + name));

        GridPane root = loader.load();
        Scene scene = new Scene(root, width, height);

        if(name.equals("gameview.fxml")){
            game = new Game(root, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
            GameController gameController = loader.getController();
            gameController.init(scene);
            game.start();
        }

        primaryStage.setTitle("ChoppyFloppy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
