package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;
    private Thread.State prevState;

    public LoggingStateThread(Thread target) {
        this.target = target;
        prevState = target.getState();
        System.out.println(prevState);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            Thread.State currentState = target.getState();
            if (prevState != currentState) {
                prevState = currentState;
                System.out.println(prevState);
                if (prevState == Thread.State.TERMINATED) {
                    interrupt();
                }
            }
        }
    }
}
