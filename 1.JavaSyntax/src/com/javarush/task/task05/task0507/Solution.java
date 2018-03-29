package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Integer> list = new ArrayList<>();
            while (true) {
                int value = Integer.valueOf(reader.readLine());
                if (value == -1) {
                    break;
                }
                list.add(value);
            }
            float result = (float) list.stream().reduce(0, (acc, element) -> acc += element) / list.size();
            System.out.println(result);
        }
    }
}

