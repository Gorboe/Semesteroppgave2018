package com.choppyfloppy.saveload;

import java.io.IOException;
import java.io.PrintWriter;

public class createsavefile {

    public static void saveFile(){
        try {
            PrintWriter saveFile = new PrintWriter("saveFolder/save.txt", "UTF-8");
            saveFile.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
