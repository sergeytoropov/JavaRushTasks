package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sergeytoropov
 * @since 26.07.17
 */
public class Snake {
    private List<SnakeSection> sections = new ArrayList<>();
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        this.sections.add(new SnakeSection(x, y));
        this.isAlive = true;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public void move() {

    }
}
