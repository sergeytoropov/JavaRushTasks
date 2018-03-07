package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.*;

/*
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                list.add(Integer.valueOf(reader.readLine()));
            }

            int maxLength = 0;
            int length = 0;
            int prevValue = 0;

            boolean start = true;
            for (Integer value: list) {
                if (start) {
                    length = 1;
                    maxLength = length;
                    prevValue = value;
                    start = false;
                } else {
                    if (prevValue == value) {
                        length++;
                        if (length > maxLength) {
                            maxLength = length;
                        }
                    } else {
                        length = 1;
                        prevValue = value;
                    }
                }
            }
            System.out.println(maxLength);
        }
    }
}