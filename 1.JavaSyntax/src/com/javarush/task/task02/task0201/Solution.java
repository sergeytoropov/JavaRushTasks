package com.javarush.task.task02.task0201;

import java.util.stream.IntStream;

/*
Реализуем метод print
*/
public class Solution {
    public static void main(String[] args) {
        print("Java easy to learn!");
    }

    public static void print(String s) {
        IntStream.range(0, 4).forEach(index -> System.out.println(s));
    }
}
