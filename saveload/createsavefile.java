package com.choppyfloppy.saveload;

import java.io.IOException;
import java.io.PrintWriter;

public class createsavefile {

    public static void saveFile(){
        try {
            PrintWriter saveFile = new PrintWriter("C:\\Users\\krist\\IdeaProjects\\choppyfloppy\\saveFolder\\save.txt", "UTF-8");
            saveFile.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
