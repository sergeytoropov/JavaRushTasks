package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.stream.IntStream;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String num = reader.readLine();

            IntStream.range(0, num.length()).map(index -> Integer.valueOf(num.charAt(index))).forEach(value -> {
                if (value % 2 == 0) {even++; } else { odd++; }
            });

            System.out.println(String.format("Even: %d Odd: %d", even, odd));
        }
    }
}
