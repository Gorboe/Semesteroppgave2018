package com.choppyfloppy.saveload;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Resource Manager class contains the methods for save and
 * load value with serializable.
 */
public class ResourceManager {

    /**
     * SaveGame method serializes the given class to the file in fileName
     * and is used to save values to file.
     *
     * @param fileName - contains the filename to which the value is saved
     */
    public static void saveGame(Serializable data, String fileName) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))){
            oos.writeObject(data);
        }
    }

    /**
     * LoadGame method loads value from file and returns value to class/
     * method when called.
     *
     * @param fileName - contains the filename to which the value is saved
     */
    public static Object loadGame(String fileName) throws IOException, ClassNotFoundException{
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))){
            return ois.readObject();
        }
    }
}
