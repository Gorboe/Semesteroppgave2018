package SaveLoadData;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(createContent());
        primaryStage.setTitle("SaveLoadData");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Parent createContent(){
        TextField fieldName = new TextField();
        TextField fieldHP = new TextField();

        Button btnSave = new Button("SAVE");
        btnSave.setOnAction(e -> {
            SaveData data = new SaveData();
            data.name = fieldName.getText();
            data.hp = Integer.parseInt(fieldHP.getText());
            try{
                ResourceManager.save(data, "1.save");
            }catch(Exception ev){
                System.out.println("Could not save: " + ev.getMessage());
            }
        });

        Button btnLoad = new Button("LOAD");
        btnLoad.setOnAction(e -> {
            try {
                SaveData data = (SaveData) ResourceManager.load("1.save");
                fieldName.setText(data.name);
                fieldHP.setText(String.valueOf(data.hp));
            }catch(Exception ev){
                System.out.println("Could not load save data: " + ev.getMessage());
            }
        });

        VBox vBox = new VBox(10, fieldName, fieldHP, btnSave, btnLoad);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(50,50,50,50));
        return vBox;
    }
}
