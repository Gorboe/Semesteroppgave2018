package com.choppyfloppy.util;

import java.awt.*;
import java.io.InputStream;

public class Content {

    public static InputStream loadImage(String filename){

        return Content.class.getResourceAsStream("/com/choppyfloppy/resources/"+filename);


    }

}
