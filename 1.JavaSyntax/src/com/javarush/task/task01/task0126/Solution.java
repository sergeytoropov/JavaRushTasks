package com.javarush.task.task01.task0126;

/* 
Не хочешь  - решай нехотя
*/

import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        IntStream.range(0, 16).forEach(index -> System.out.println("Хочешь - решай задачи, не хочешь - решай нехотя"));
    }
}
