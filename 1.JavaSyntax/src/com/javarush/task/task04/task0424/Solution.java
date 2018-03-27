package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int b1 = Integer.valueOf(reader.readLine());
            int b2 = Integer.valueOf(reader.readLine());
            int b3 = Integer.valueOf(reader.readLine());

            if (!(b1 != b2 && b1 != b3 && b2 != b3)) {
                if (b1 != b2 && b1 != b3) {
                    System.out.println("1");
                }
                if (b2 != b1 && b2 != b3) {
                    System.out.println("2");
                }
                if (b3 != b1 && b3 != b2) {
                    System.out.println("3");
                }
            }
        }
    }
}
