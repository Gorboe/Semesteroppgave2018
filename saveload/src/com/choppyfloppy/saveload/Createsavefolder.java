package com.choppyfloppy.saveload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Createsavefolder contains the method for creating
 * the save-folder. It creates if the folder is missing
 * and it ignores the method if the folder already exists.
 */
public class Createsavefolder {

    /**
     * If the save-folder exist then continue and do nothing.
     * If the folder does not exist then create it
     */
    public static void createDirectoryIfNotExists() {
        try {
            if (!Files.exists(Paths.get("saveFolder"))) {
                Files.createDirectory(Paths.get("saveFolder"));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}