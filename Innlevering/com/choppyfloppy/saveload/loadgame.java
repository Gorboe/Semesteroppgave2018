package com.choppyfloppy.saveload;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class loadgame {

    public static void readFile() {

        String s = "";
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader loadfile = Files.newBufferedReader(Paths.get("saveFolder/save.txt"));

            //BufferedReader in = new BufferedReader(new FileReader(file));

            while ((s = loadfile.readLine()) != null) {
                sb.append(s+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(sb.toString());



/*
        for (int i = 0; i < loadfile; i++){
            saveToFile[i] = Integer.parseInt(inputReader.readLine());
        }
*/
    }

    public void skrivFil(){

    }


}
