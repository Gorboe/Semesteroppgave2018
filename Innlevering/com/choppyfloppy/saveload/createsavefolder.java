package com.choppyfloppy.saveload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class createsavefolder {

    public static void createDirectoryIfNotExists() {
        //Hvis save folder eksisterer så fortsett, hvis ikke lages folderen.
        try {
            if (!Files.exists(Paths.get("saveFolder"))) {
                Files.createDirectory(Paths.get("saveFolder"));
                System.out.println("mappe lager");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
