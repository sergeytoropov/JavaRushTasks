package com.javarush.task.task24.task2413;

/**
 * @author sergeytoropov
 * @since 23.08.17
 */
public class Brick extends BaseObject {
    public Brick(double x, double y, double radius) {
        super(x, y, radius);
    }

    public Brick(double x, double y) {
        super(x, y, 3);
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void move() {

    }
}
