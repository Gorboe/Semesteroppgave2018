package com.choppyfloppy.core;

import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2DTest {

    @Test
    public void addX() throws Exception {
        Vector2D vector2D = new Vector2D(20, 30);
        vector2D.addX(5);
        assertEquals(25, vector2D.getX(), 0.0d);
    }

    @Test
    public void addY() throws Exception {
        Vector2D vector2D = new Vector2D(20, 30);
        vector2D.addY(5);
        assertEquals(35, vector2D.getY(), 0.0d);
    }

    @Test
    public void getX() throws Exception {
        Vector2D vector2D = new Vector2D(20, 30);
        assertEquals(20, vector2D.getX(), 0.0d);
    }

    @Test
    public void setX() throws Exception {
        Vector2D vector2D = new Vector2D(20, 30);
        vector2D.setX(5);
        assertEquals(5, vector2D.getX(), 0.0d);
    }

    @Test
    public void getY() throws Exception {
        Vector2D vector2D = new Vector2D(20, 30);
        assertEquals(30, vector2D.getY(), 0.0d);
    }

    @Test
    public void setY() throws Exception {
        Vector2D vector2D = new Vector2D(20, 30);
        vector2D.setY(5);
        assertEquals(5, vector2D.getY(), 0.0d);
    }

}