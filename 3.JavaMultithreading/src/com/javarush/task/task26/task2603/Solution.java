package com.javarush.task.task26.task2603;

import java.util.Comparator;
import java.util.stream.IntStream;

/*
Убежденному убеждать других не трудно
*/
public class Solution {
    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... vararg) {
            this.comparators = vararg;
        }

        @Override
        public int compare(T o1, T o2) {
            return IntStream
                    .range(0, comparators.length)
                    .mapToObj(index -> Integer.valueOf(comparators[index].compare(o1, o2)))
                    .filter(result -> result != 0)
                    .findFirst()
                    .orElse(0);
        }
    }

    public static void main(String[] args) {

    }
}
