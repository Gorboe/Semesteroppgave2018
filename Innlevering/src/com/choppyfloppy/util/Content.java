package com.choppyfloppy.util;

import java.awt.*;
import java.io.InputStream;

/**
 *
 */
public final class Content {

    /**
     * @param filename
     * @return
     */
    public static InputStream loadImage(String filename){

        return Content.class.getResourceAsStream("/com/choppyfloppy/resources/"+filename);


    }

}
