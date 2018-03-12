package com.javarush.task.task25.task2512;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 12.03.18
 */
public class SolutionTest {

    public class MyThread implements Runnable {

        @Override
        public void run() throws RuntimeException {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("MyThread is sleep in 1 s.");
                    Thread.sleep(1000);
                    throw new RuntimeException("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
                }
            } catch (InterruptedException ex) {
            }
        }
    }

    @Test
    public void breaking() {
        Thread thread = new Thread(new MyThread());
        thread.setUncaughtExceptionHandler(new Solution());
        thread.start();

        sleep(5000);
        System.out.println("wait 5 sec.");
        //thread.interrupt();
    }

    private void sleep() {
        sleep(1000);
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}