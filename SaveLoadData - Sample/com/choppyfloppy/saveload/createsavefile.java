package com.choppyfloppy.saveload;

import java.io.IOException;
import java.io.PrintWriter;

public class createsavefile {

    static int playerScore = 14;
    static int currentLevel = 4;

    //legg til filename; saveFile(String filename){

    public static void saveFile(){
        try {
            PrintWriter saveFile = new PrintWriter("saveFolder/save.txt", "UTF-8");
            saveFile.println(playerScore);
            saveFile.println(currentLevel);
            saveFile.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
