package com.javarush.task.task22.task2209.a;

import java.io.*;
import java.util.*;

/*
Составить цепочку слов
*/

public class Solution {
    public static class Answer {
        public final String firstWord;
        public final String lastWord;

        public Answer(String firstWord, String lastWord) {
            this.firstWord = firstWord;
            this.lastWord = lastWord;
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

    public static Answer findFirstLastWords(String... words) {
        Map<String, Answer> level1 = new HashMap<>();
        Map<String, Answer> level2 = new HashMap<>();

        for (String word: words) {
            String firstChar = String.valueOf(word.charAt(0)).toUpperCase();
            String lastChar = String.valueOf(word.charAt(word.length() - 1)).toUpperCase();

            // level1
            if (level1.containsKey(lastChar)) {
                return new Answer(level1.get(lastChar).firstWord, word);
            } else {
                level1.put(firstChar, new Answer(word, null));
            }

            // level2
            if (level2.containsKey(firstChar)) {
                return new Answer(word, level2.get(firstChar).lastWord);
            } else {
                level2.put(lastChar, new Answer(null, word));
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Не пройдены тесты
        String fileName;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
            StringBuilder result = getLine(getWords(fileName));
            System.out.println(result.toString());
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder("");
        StringBuilder firstWords = new StringBuilder("");
        StringBuilder lastWords = new StringBuilder("");

        if (words == null) {
            return new StringBuilder();
        }

        if (words.length == 0) {
            return new StringBuilder();
        }

        Answer answer = findFirstLastWords(words);
        Arrays.stream(words).forEach(word -> {

            if (answer.firstWord.equals(word)) {
                if (firstWords.length() > 0) {
                    firstWords.append(" ");
                }
                firstWords.append(word);
            } else if (answer.lastWord.equals(word)) {
                if (lastWords.length() > 0) {
                    lastWords.append(" ");
                }
                lastWords.append(word);
            } else {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(word);
            }
        });

        if (sb.length() > 0) {
            if (firstWords.length() > 0) {
                firstWords.append(" ");
            }
        }
        firstWords.append(sb);

        if (lastWords.length() > 0) {
            if (firstWords.length() > 0) {
                firstWords.append(" ");
            }
        }
        firstWords.append(lastWords);

        return firstWords;
    }
}
