package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane window = new GridPane();
        Scene scene = new Scene(window);

        Game game = new Game(window, 800, 800);
        game.getGameLoop().start();

        primaryStage.setScene(scene);
        primaryStage.setTitle("The Game");
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }
}
