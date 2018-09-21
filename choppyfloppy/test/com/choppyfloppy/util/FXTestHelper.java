package com.choppyfloppy.util;

import javafx.application.Application;
import javafx.stage.Stage;

public class FXTestHelper extends Application {

    private static boolean init;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //nothing happens
    }

    public static void runFX(){
        if (init){
            return;
        }


    Thread helpThreadFX = new Thread(() -> Application.launch(FXTestHelper.class));
        helpThreadFX.setDaemon(true);
        helpThreadFX.start();
        init = true;

    }

}
