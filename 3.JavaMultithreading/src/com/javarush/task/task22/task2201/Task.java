package com.javarush.task.task22.task2201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task implements Runnable {
    private String initialString;
    private Solution solution;

    public Task(Solution solution, String initialString) {
        this.solution = solution;
        this.initialString = initialString;
    }

    @Override
    public void run() {
        try (
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();
        } catch (IOException ioe) {

        }

        String name = Thread.currentThread().getName();
        String str = this.initialString;
        do {
            System.out.println(name + str);
        } while ((str = solution.getPartOfString(str, name)) != null || !str.isEmpty());
    }
}
