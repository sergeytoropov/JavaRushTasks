package com.javarush.task.task25.task2512;

import java.util.Deque;
import java.util.LinkedList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        Deque<Throwable> deque = new LinkedList<>();
        Throwable throwable = e;
        do {
            deque.addFirst(throwable);
            throwable = throwable.getCause();
        } while (throwable != null);

        deque.forEach(System.out::println);
    }


    public static void main(String[] args) {
    }
}
