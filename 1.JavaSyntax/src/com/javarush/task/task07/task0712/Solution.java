package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> list = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                list.add(reader.readLine());
            }

            OptionalInt min = list.stream().mapToInt(String::length).min();
            OptionalInt max = list.stream().mapToInt(String::length).max();

            Optional<String> answer = list.stream()
                    .filter(str -> (str.length() == min.getAsInt() || str.length() == max.getAsInt()))
                    .findFirst();

            System.out.println(answer.get());
        }
    }
}
