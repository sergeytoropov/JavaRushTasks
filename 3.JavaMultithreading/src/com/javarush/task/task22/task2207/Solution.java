package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        // 3.JavaMultithreading/src/com/javarush/task/task22/task2207/test1.txt

        // Считали имя файла
        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        // Считали все слова
        List<String> words = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Arrays.stream(line.split(" ")).forEach(word -> words.add(word));
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        // Ищем обращенные слова
        while (words.size() > 0) {
            String firstWord = words.get(0);
            words.remove(0);

            String secondWord = new StringBuilder(firstWord).reverse().toString();

            Optional<String> finded = words.stream().filter(word -> word.equals(secondWord)).findFirst();
            if (finded.isPresent()) {
                words.remove(secondWord);
                result.add(new Pair(firstWord, secondWord));
            }
        }

        // Выводим на экран
        StringBuilder sb = new StringBuilder("");
        result.stream().forEach(pair -> sb.append(pair.first).append(" ").append(pair.second).append("\n"));
        System.out.println(sb);
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
            this("", "");
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
