package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.*;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Integer[] array = new Integer[15];
            for (int index = 0; index < array.length; index++) {
                array[index] = Integer.valueOf(reader.readLine());
            }

            Map<Boolean, Integer> answer = IntStream.range(0, array.length)
                    .mapToObj(Integer::new)
                    .collect(groupingBy(index -> Boolean.valueOf((index % 2) == 0), summingInt(index -> array[index])));

            if (answer.get(true) != null) {
                if (answer.get(false) == null || answer.get(true) > answer.get(false)) {
                    System.out.println("В домах с четными номерами проживает больше жителей.");
                } else if (answer.get(false) > answer.get(true)) {
                    System.out.println("В домах с нечетными номерами проживает больше жителей.");
                }
            }
        }
    }
}
