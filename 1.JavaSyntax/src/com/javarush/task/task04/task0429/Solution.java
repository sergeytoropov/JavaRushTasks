package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] digits = new int[3];
            for (int index = 0; index < digits.length; index++) {
                digits[index] = Integer.valueOf(reader.readLine());
            }

            Map<Boolean, List<Integer>> map = Arrays.stream(digits)
                    .filter(value -> value != 0)
                    .mapToObj(Integer::valueOf)
                    .collect(Collectors.partitioningBy(value -> value > 0));

            System.out.println("количество отрицательных чисел: " + map.get(false).size());
            System.out.println("количество положительных чисел: " + map.get(true).size());
        }
    }
}
