package com.choppyfloppy.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test(expected = NullPointerException.class)
    public void ParentCanNotBeNull(){
        new Game(null, 500, 400);
    }

}