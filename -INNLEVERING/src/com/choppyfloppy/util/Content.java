package com.choppyfloppy.util;


import java.io.InputStream;

/**
 * Class contains method to retrieve resources from a given path
 */
public final class Content {

    /**
     * Retrieves resources from a given path.
     *
     * @param filename - cointains the filename of the file you want to open
     * @return
     */
    public static InputStream loadImage(String filename){
        return Content.class.getResourceAsStream("/com/choppyfloppy/resources/"+filename);
    }

}
