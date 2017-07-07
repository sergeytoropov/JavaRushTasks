package com.javarush.task.task01.task0102;

/* 
Комплимент учителю
*/

import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        IntStream.range(0, 5).forEach(index -> System.out.println("Элли самая красивая"));
    }
}
