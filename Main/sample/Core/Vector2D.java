package sample.Core;

public class Vector2D {

    private double x;
    private double y;

    public Vector2D(double initialX, double initialY){
        this.x = initialX;
        this.y = initialY;
    }

    public void set(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void add(double x, double y){
        this.x += x;
        this.y += y;
    }

    public void addX(double x){this.x += x;}
    public void addY(double y){this.y += y;}
    public double getX(){return x;}
    public double getY(){return y;}
    public void setX(){this.x = x;}
    public void setY(){this.y = y;}

    public static Vector2D Zero(){return new Vector2D(0,0);}
}
