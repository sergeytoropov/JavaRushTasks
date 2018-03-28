package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] digits = new int[3];
            for (int index = 0; index < digits.length; index++) {
                digits[index] = Integer.valueOf(reader.readLine());
            }

            int quantity = Arrays
                    .stream(digits)
                    .filter(val -> val > 0)
                    .map(val -> 1)
                    .reduce(0, (acc, element) -> acc += element);

            System.out.println(quantity);
        }
    }
}
