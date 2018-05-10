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
     * The method takes class of type T that inherits from Serializable.
     * savegame takes an instance of the type T as a parameter.
     *
     * @param fileName - contains the filename to which the value is saved
     */
    public static <T extends Serializable> void saveGame(T data, String fileName) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))){
            oos.writeObject(data);
        }
    }

    /**
     * LoadGame method loads value from file and returns value to class/
     * method when called.
     * The method uses generic programming to return the class.
     *
     * @param fileName - contains the filename to which the value is saved
     */
    public static <T extends Serializable> T loadGame(String fileName, Class<T> clazz) throws IOException, ClassNotFoundException{
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))){
            return clazz.cast(ois.readObject());
        }
    }
}
