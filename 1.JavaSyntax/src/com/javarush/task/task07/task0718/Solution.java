package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

/* 
Проверка на упорядоченность
*/

public class Solution {
    private static class Pair {
        private int prevLength = Integer.MIN_VALUE;
        private int currLength = Integer.MIN_VALUE;
        private int index = -1;

        public Pair() {
        }

        private Pair(int prevLength, int currLength, int index) {
            this.prevLength = prevLength;
            this.currLength = currLength;
            this.index = index;
        }

        public Pair createPair(int currLength, int index) {
            this.prevLength = this.currLength;
            this.currLength = currLength;
            this.index = index + 1;
            return new Pair(this.prevLength, this.currLength, this.index);
        }

        public Boolean increase() {
            return index == 0 ? prevLength > currLength : prevLength >= currLength;
        }

        public int getIndex() {
            return index;
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayList<String> list = new ArrayList<>();
            for (int index = 0; index < 10; index++) {
                list.add(reader.readLine());
            }

            final Pair pair = new Pair();
            Optional<Pair> answer = list.stream()
                    .map(value -> pair.createPair(value.length(), pair.getIndex()))
                    .filter(p -> p.increase())
                    .findFirst();

            if (answer.isPresent()) {
                System.out.println(answer.get().getIndex());
            }
        }
    }
}

