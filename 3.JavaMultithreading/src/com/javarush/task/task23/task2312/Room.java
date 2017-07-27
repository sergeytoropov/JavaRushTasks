package com.javarush.task.task23.task2312;

/**
 * @author sergeytoropov
 * @since 26.07.17
 */
public class Room {
    public static Room game;

    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public void run() {

    }

    public void print() {

    }

    public void createMouse() {
        mouse = new Mouse((int) (Math.random()*getWidth()), (int)(Math.random()*getHeight()));
    }

    public void eatMouse() {
        createMouse();
    }

    public void sleep() {

    }

    public static void main(String[] args) {
        Snake snake = new Snake(0, 0);
        snake.setDirection(SnakeDirection.DOWN);
        game = new Room(200, 200, snake);
        game.createMouse();
        game.run();
    }
}
