package com.choppyfloppy.saveload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Createsavefolder {

    public static void createDirectoryIfNotExists() {
        System.out.println("Jeg virker(mappe)");
        //Hvis save folder eksisterer så fortsett, hvis ikke lages folderen.
        try {
            if (!Files.exists(Paths.get("saveFolder"))) {
                Files.createDirectory(Paths.get("saveFolder"));
                System.out.println("mappe lages");
            }else {
                System.out.println("mappe eksisterer");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

//Liten endring
}
