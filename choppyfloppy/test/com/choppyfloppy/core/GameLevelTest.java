package com.choppyfloppy.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameLevelTest {

    @Test (expected = NullPointerException.class)
    public void ImageviewCanNotBeNull(){
        new GameLevel(null);
    }

}