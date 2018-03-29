package com.javarush.task.task26.task2601;

import java.util.Arrays;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        int m = array.length % 2 == 0 ?
                Math.round((array[array.length / 2] + array[array.length / 2 - 1]) / 2) :
                Math.round(array[array.length / 2]);
        Arrays.sort(array, (a, b) -> Integer.compare(Math.abs(m - a), Math.abs(m - b)));
        return array;
    }
}
