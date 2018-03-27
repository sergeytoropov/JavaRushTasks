package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int x = Integer.valueOf(reader.readLine());
            int y = Integer.valueOf(reader.readLine());

            if (x > 0 && y > 0) {
                System.out.println("1");
            } else if (x < 0 && y > 0) {
                System.out.println("2");
            } else if (x < 0 && y < 0) {
                System.out.println("3");
            } else if (x > 0 && y < 0) {
                System.out.println("4");
            }
        }
    }
}
