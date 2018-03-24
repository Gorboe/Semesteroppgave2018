package Main;

public class Vector2D {
    private double x;
    private double y;

    //public final static Vector2D ZERO = Zero();

    public Vector2D(double initialX, double initialY) {
        this.x = initialX;
        this.y = initialY;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void addX(double x) {
        this.x += x;
    }

    public void addY(double y) {
        this.y += y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static Vector2D Zero() {
        return new Vector2D(0,0);
    }
}
