package com.javarush.task.task23.task2305;

import java.util.Arrays;

/*
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] arraySolution = new Solution[] {new Solution(), new Solution()};

        Arrays.stream(arraySolution).forEach(s -> {
            for (int index = 0; index < s.innerClasses.length; index++) {
                s.innerClasses[index] = s.new InnerClass();
            }
        });
        return arraySolution;
    }

    public static void main(String[] args) {
    }
}
