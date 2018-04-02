package Main;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane window = new Pane();
        Scene scene = new Scene(window);

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        Game game = new Game(window, (int)primaryScreenBounds.getMaxX(), (int)primaryScreenBounds.getMaxY()+50); //set til pc screen max width og height
        game.getGameLoop().start();

        primaryStage.setScene(scene);
        primaryStage.setTitle("The Game");
        primaryStage.setResizable(true); //false ikke ønskelig at de kan endre dette
        //primaryStage.setFullScreen(true); //esc for å exit fs. esc blir også for pausemeny.
        primaryStage.show();
    }


}
