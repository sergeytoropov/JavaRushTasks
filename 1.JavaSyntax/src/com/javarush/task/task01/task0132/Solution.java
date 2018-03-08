package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        char[] digits = String.valueOf(number).toCharArray();
        return IntStream.range(0, digits.length)
                .mapToObj(index -> Integer.valueOf(String.valueOf(digits[index])))
                .reduce(0, (acc, element) -> acc = acc + element);
    }
}