package com.choppyfloppy.core;

/**
 * This class is used to store position of GameObjects
 * and to give them a velocity and move them around
 * on the game-board. It is also used to calculate
 * the mouse-shooting.
 */
public class Vector2D {
    private double x;
    private double y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector2D vector2D = (Vector2D) o;

        if (Double.compare(vector2D.x, x) != 0) return false;
        return Double.compare(vector2D.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * This is the constructor. When you create a new
     * Vector2D for example a player. You must give it
     * an initial x and y value to place it where you
     * want on the game-board. You cannot give it a value of null.
     * @param initialX is the start x-value
     * @param initialY is the start y-value
     */
    public Vector2D(double initialX, double initialY) {
        this.x = initialX;
        this.y = initialY;
    }

    /**
     * This is used to subtract a Vector2D with an other
     * Vector2D.
     * @param vector1 is the first Vector2D
     * @param vector2 is the second Vector2D
     * @return a new Vector2D with new x and y values
     */
    public static Vector2D subtract(Vector2D vector1, Vector2D vector2){
        double newVectorX = vector2.getX() - vector1.getX();
        double newVectorY = vector2.getY() - vector1.getY();
        return new Vector2D(newVectorX, newVectorY);
    }

    /**
     * Used to add a x-value to the current x-value of the Vector2D
     * this is used when we want objects to move (velocity)
     * @param x is a double value
     */
    public void addX(double x) {
        this.x += x;
    }

    /**
     * Used to add a y-value to the current y-value of the Vector2D
     * this is used when we want objects to move (velocity)
     * @param y is a double value
     */
    public void addY(double y) {
        this.y += y;
    }

    /**
     * Used to get the x value from a Vector2D. (position)
     */
    public double getX() {
        return x;
    }

    /**
     * Used to set the x value of a Vector2D. (position)
     * @param x is a double value
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Used to get the y value from a Vector2D. (position)
     */
    public double getY() {
        return y;
    }

    /**
     * Used to set the y value of a Vector2D. (position)
     * @param y is a double value
     */
    public void setY(double y) {
        this.y = y;
    }
}
