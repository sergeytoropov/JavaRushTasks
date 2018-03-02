package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {

    public static class TaskException extends Exception {
        public TaskException() {
            super();
        }

        public TaskException(String message) {
            super(message);
        }
    }

    public static class Util {
        private static final String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        public static int indexOf(char ch) throws TaskException {
            int index = abc.indexOf(Character.toLowerCase(ch));
            if (index == -1) {
                throw new TaskException("Встретилься неизвестный символ [" + ch + "]");
            }
            return index;
        }

        private static void checkWord(final String word) throws TaskException {
            if (word == null || word.length() < 2) {
                throw new TaskException("Слово должно состоять из минимум двух символов");
            }
        }

        public static int firstIndex(final String word) throws TaskException {
            checkWord(word);
            return indexOf(word.charAt(0));
        }

        public static int lastIndex(final String word) throws TaskException {
            checkWord(word);
            return indexOf(word.charAt(word.length() - 1));
        }
    }

    public static class Point {
        public final int value;
        public final String word;
        public final int i;
        public final int j;
        public final Boolean isNullObject;

        private int activeValue;

        public Point() {
            this.value = 0;
            this.word = "";
            this.i = -1;
            this.j = -1;
            isNullObject = true;
            activeValue = 0;
        }

        public Point(int value, final String word, int i, int j) {
            this.value = value;
            this.word = word;
            this.i = i;
            this.j = j;
            isNullObject = false;
            activeValue = value;
        }

        public void inc() throws TaskException {
            activeValue =+ 1;
            if (activeValue > value) {
                throw new TaskException("Добавили лишнее слово.");
            }
        }

        public void dec() throws TaskException {
            activeValue =- 1;
            if (activeValue < 0) {
                throw new TaskException("Нет доступных слов.");
            }
        }

        @Override
        public String toString() {
            return String.format("[%10.10s %2d %2d %2d,%2d]", word, value, activeValue, i, j);
        }
    }

    public static final Point[][] map = new Point[33][33];

    private static final int INIT = 10;
    private static final int EXIT = 11;
    private static final int ROOT = 12;
    private static final int NEXT = 13;
    private static final int PREV = 14;
    private static int state = INIT;

    public static void init(final String[] words) throws TaskException {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new Point();
            }
        }

        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            int i = Util.firstIndex(word);
            int j = Util.lastIndex(word);
            Point p = map[i][j];
            map[i][j] = new Point(p.value + 1, word, i, j);
        }
    }

    public static void algorithm(final String[] words) throws TaskException {
       boolean isRun = true;
       while(isRun) {
            switch (state) {
                case INIT:
                    state = EXIT;
                    init(words);
                    break;

                case EXIT:
                    isRun = false;
                    break;
            }
       }
    }

    public static String[] getWords(String fileName) throws FileNotFoundException, IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Arrays.stream(line.split(" ")).forEach(word -> words.add(word));
            }
            return words.toArray(new String[words.size()]);
        }
    }

    public static void main(String[] args) {
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
            reader.close();

            StringBuilder result = getLine(getWords(fileName));
            System.out.println(result.toString());
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0) {
            return sb;
        }

        sb.append(1);
        return sb;
    }
}
