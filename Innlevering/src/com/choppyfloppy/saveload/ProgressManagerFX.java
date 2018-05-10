package com.choppyfloppy.saveload;

import com.choppyfloppy.Main;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File.*;

/**
 * Progress Manager FX allows the user to select which file to save or load while playing.
 * The class allows for more than one save to be stored.
 */
public class ProgressManagerFX implements ProgressManager{

    /**
     * Constructor for Progress Manager.
     */
    public ProgressManagerFX(){
    }

    /**
     * Uses File Chooser to allow access to file structure.
     * Opens Canvas with showOpenDialog and returns null if no
     * file is selected.
     */
    public SaveData load() throws IOException, ClassNotFoundException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load File");
        fileChooser.setInitialDirectory(Paths.get("/saveFolder").toFile());

        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile == null) {
            return null;
        }

        return ResourceManager.loadGame(selectedFile.getPath().toString(), SaveData.class);

    }

    /**
     * Method that checks if the directory is empty.
     */
    public static boolean isDirEmpty(final Path directory) throws IOException {
        try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(directory)) {
            return !dirStream.iterator().hasNext();
        }
    }



    /**
     * Uses File Chooser to allow access to file structure.
     * Saves variables to directory and allows for naming and
     * overwriting files.
     *
     * Warning is shoved if user hits cancel instead of save.
     */
    public void save(SaveData saveData) throws IOException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.setInitialDirectory(Paths.get("/saveFolder").toFile());


        File selectedFile = fileChooser.showSaveDialog(null);
        if (selectedFile == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "File not saved");
            alert.show();
            return;
        }

        ResourceManager.saveGame(saveData, selectedFile.toPath().toString());

    }


}
