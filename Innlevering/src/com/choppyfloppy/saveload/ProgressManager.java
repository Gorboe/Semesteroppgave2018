package com.choppyfloppy.saveload;

import java.io.IOException;

/**
 * Interface for ProgressManager.
 */
public interface ProgressManager {
    void save(SaveData saveData) throws IOException;
    SaveData load() throws IOException, ClassNotFoundException;

}
