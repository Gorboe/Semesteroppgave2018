
package com.choppyfloppy.saveload;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

public class Save {

    static int playerHp = 1;
    static int playerScore = 2000;
    static int currentLevel = 3;
    int locPlayerX = 10;
    int locPlayerY = 10;

    int[] savePlayer = {playerHp, playerScore, currentLevel};

    int pHpLoc = 0;
    int pSLoc = 1;
    int cLLoc = 2;

    public Save() {

    }
/*
    public static void createfile() {
        //Dette skriver en fil til mappen savefolder.txt
        try {
            //Hvordan får vi fikset path når spillet flyttes til en annen pc?
            PrintWriter saveFile = new PrintWriter("C:\\Users\\krist\\IdeaProjects\\choppyfloppy\\saveFolder\\save.txt", "UTF-8");
            saveFile.println(playerHp);
            saveFile.println(playerScore);
            saveFile.println(currentLevel);
            saveFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/

/*
                try {
                    Files.createFile(Paths.get("saveFolder"));
                } catch (IOException e){
                e.printStackTrace();
                }
    */


    public static void main(String[] args) {

        createsavefolder.createDirectoryIfNotExists();
        createsavefile.saveFile();
        loadgame.readFile();


        // Klarer vi å hente datafelt fra game?
        //
    }
}




