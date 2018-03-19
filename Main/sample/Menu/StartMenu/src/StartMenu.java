import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class StartMenu extends Application {

    private StartMenu gameMenu;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        root.setPrefHeight(600);
        root.setPrefWidth(800);

        InputStream is = Files.newInputStream(Paths.get("res/img/start.jpg"));
        Image img = new Image(img);
        is.close();

        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(600);
        imgView.setFitWidth(800);

        gameMenu = new StartMenu();


        root.getChildren().addAll(imgView,gameMenu);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

   private class StartMenu extends Parent{
        public StartMenu() {
            VBox menuStart = new VBox(20);

            menuStart.setAlignment(Pos.CENTER_LEFT);
        }

        MenuButton buttonStart = new MenuButton("Start");
        //buttonStart.setOnMouseclicked( {
          // init(game);});


       MenuButton buttonLoad = new MenuButton("Load");
       MenuButton buttonOptions = new MenuButton("Options");



       MenuButton buttonExit = new MenuButton("Exit");
        //buttonExit.setonmouseClicked(event ->{
          //  System.exit(0);})

   }


    private static class MenuButton extends StackPane{
        private Text text;

        public MenuButton(String name) {
            text = new Text(name);
            text.setFont(text.getFont().font(40));
            text.setFill(Color.RED);

            Rectangle menuBtn = new Rectangle(200, 30);
            //menuBtn.setFill();



            setAlignment(Pos.CENTER);
            getChildren().addAll(menuBtn,text);

           /* setOnMouseEntered(event -> {
                menuBtn.setFill()
            });*/

            DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));


        }

   }


    public static void main(String[] args) {
        launch(args);
    }

}
