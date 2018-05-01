package com.choppyfloppy.saveload;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Createsavefile {

    public static void createfile() {
        try {
            if (!Files.exists(Paths.get("saveFolder/save.txt"))) {
                PrintWriter saveFile = new PrintWriter("saveFolder/save.txt", "UTF-8");
                saveFile.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}