package com.javarush.task.task25.task2504;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    public static class TestThread extends Thread {
        public final String testName;

        public TestThread(String testName) {
            super();
            this.testName = testName;
        }

        @Override
        public void run() {
            System.out.println("This is a my thread. " + testName + ", " + getName());
        }
    }

    @Test
    public void threads() throws InterruptedException {
        TestThread[] threads = new TestThread[] {
                new TestThread("Thread_One"),
                new TestThread("Thread_Two"),
                new TestThread("Thread_Three"),
                new TestThread("Thread_Four"),
                new TestThread("Thread_Five")
        };
        Solution.processThreads(threads);
        Thread.sleep(1000);
        Solution.processThreads(threads);
    }

    @Test
    public void info() {
        Thread mainThread = Thread.currentThread();
        System.out.println("Текущий поток: " + mainThread.getName());

        // Меняем имя и выводим в текстовом поле
        mainThread.setName("CatThread");
        System.out.println("\nНовое имя потока: " + mainThread.getName());
    }
}