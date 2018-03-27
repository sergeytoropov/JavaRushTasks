package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int dayOfWeek = Integer.valueOf(reader.readLine());

            String message = "такого дня недели не существует";
            switch (dayOfWeek) {
                case 1:
                    message = "понедельник";
                    break;
                case 2:
                    message = "вторник";
                    break;
                case 3:
                    message = "среда";
                    break;
                case 4:
                    message = "четверг";
                    break;
                case 5:
                    message = "пятница";
                    break;
                case 6:
                    message = "суббота";
                    break;
                case 7:
                    message = "воскресенье";
                    break;
            }
            System.out.println(message);
        }
    }
}
