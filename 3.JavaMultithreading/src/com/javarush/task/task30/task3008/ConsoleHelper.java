package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author sergeytoropov
 * @since 28.03.18
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String message = "";
        boolean isComplated = false;
        while (!isComplated) {
            try {
                message = reader.readLine();
                isComplated = true;
            } catch (IOException ioe) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return message;
    }

    public static int readInt() {
        int value = 0;
        boolean isComplated = false;
        while (!isComplated) {
            try {
                value = Integer.valueOf(readString());
                isComplated = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return value;
    }
}
