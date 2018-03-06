package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));

        GridPane root = loader.load();
        Scene scene = new Scene(root);

        Game game = new Game(root, scene, 600,600);

        Controller mainController = loader.getController();
        mainController.init(game);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Semesteroppgave");
        primaryStage.show();
    }



}
