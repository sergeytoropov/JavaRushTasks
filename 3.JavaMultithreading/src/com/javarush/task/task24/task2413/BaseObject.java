package com.javarush.task.task24.task2413;

/**
 * @author sergeytoropov
 * @since 29.08.17
 */
public abstract class BaseObject {
    private double x;
    private double y;
    private double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public abstract void draw(Canvas canvas);

    public abstract void move();

    public boolean isIntersec(BaseObject o) {
        return Math.sqrt(Math.pow((getX() - o.getX()), 2) + Math.pow((getY() - o.getY()), 2)) <= Double.max(getRadius(), o.getRadius());
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

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
