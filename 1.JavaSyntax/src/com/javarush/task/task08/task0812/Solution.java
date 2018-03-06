package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        IntStream.range(1, 10).forEach(r -> {
            try {
                list.add(Integer.valueOf(reader.readLine()));
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        });
        Collections.sort(list);


        list.forEach(v -> {
            System.out.println(v);
        });

    }
}