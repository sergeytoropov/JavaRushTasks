package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Long year = Long.valueOf(reader.readLine());
            int days = 365;
            if (year % 4 == 0) {
                days = 366;
                if (year % 100 == 0) {
                    days = (year % 400 == 0) ? 366 : 365;
                }
            }
            System.out.println("количество дней в году: " + days);
        }
    }
}