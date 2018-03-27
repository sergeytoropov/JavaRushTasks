package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int a1 = Integer.valueOf(reader.readLine());
            int a2 = Integer.valueOf(reader.readLine());
            int a3 = Integer.valueOf(reader.readLine());

            if (a1 == a2 && a1 == a3) {
                System.out.println(a1 + " " + a2 + " " + a3);
            } else if (a1 == a2) {
                System.out.println(a1 + " " + a2);
            } else if (a1 == a3) {
                System.out.println(a1 + " " + a3);
            } else if (a2 == a3) {
                System.out.println(a2 + " " + a3);
            }
        }
    }
}