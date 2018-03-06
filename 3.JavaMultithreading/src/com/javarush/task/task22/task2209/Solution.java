package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

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
            if (word == null || word.length() < 1) {
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
            activeValue = activeValue + 1;
            if (activeValue > value) {
                throw new TaskException("Добавили лишнее слово.");
            }
        }

        public void dec() throws TaskException {
            activeValue = activeValue - 1;
            if (activeValue < 0) {
                throw new TaskException("Нет доступных слов.");
            }
        }

        public boolean availableWord() {
            return activeValue > 0 ? true : false;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;

            Point point = (Point) o;

            if (value != point.value) return false;
            if (i != point.i) return false;
            if (j != point.j) return false;
            if (activeValue != point.activeValue) return false;
            if (word != null ? !word.equals(point.word) : point.word != null) return false;
            return isNullObject != null ? isNullObject.equals(point.isNullObject) : point.isNullObject == null;
        }

        @Override
        public int hashCode() {
            int result = value;
            result = 31 * result + (word != null ? word.hashCode() : 0);
            result = 31 * result + i;
            result = 31 * result + j;
            result = 31 * result + (isNullObject != null ? isNullObject.hashCode() : 0);
            result = 31 * result + activeValue;
            return result;
        }

        @Override
        public String toString() {
            return String.format("[%10.10s %2d %2d %2d,%2d]", word, value, activeValue, i, j);
        }
    }

    public static class Algorithm {

        public final Point[][] map = new Point[33][33];
        private final int INIT = 10;
        private final int EXIT = 11;
        private final int ROOT = 12;
        private final int NEXT = 13;
        private final int PREV = 14;
        private final int ALTERNATIVE = 15;
        private int state = INIT;
        private Point root = null;
        private Deque<Point> path = new LinkedList<>();
        private int maxPath;
        private List[] answers;

        public Point[][] getMap() {
            return map;
        }

        public void init(final String[] words) throws TaskException {
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

            maxPath = words.length;

            answers = new ArrayList[words.length];
            for (int i = 0; i < answers.length; i++) {
                answers[i] = null;
            }
        }

        public Point root() throws TaskException {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j].isNullObject == false) {
                        return map[i][j];
                    }
                }
            }
            throw new TaskException("Отсутствует корневой элемент.");
        }

        /**
         * @param prevRoot - предыдущий корневой элемент.
         * @return Возвращает следующий корневой элемент. Если не найден то NULL.
         */
        public Point root(Point prevRoot) {
            int prevJ = prevRoot.j + 1;
            for (int i = prevRoot.i; i < map.length; i++) {
                for (int j = prevJ; j < map[i].length; j++) {
                    if (map[i][j].isNullObject == false) {
                        return map[i][j];
                    }
                }
                prevJ = 0;
            }
            return null;
        }

        public Point next(Point prevWord) {
            int i = prevWord.j;
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].isNullObject == false && map[i][j].availableWord()) {
                    return map[i][j];
                }
            }
            return null;
        }

        public Point alternative(Point prevWord) {
            int i = prevWord.i;
            for (int j = prevWord.j + 1; j < map[i].length; j++) {
                if (map[i][j].isNullObject == false && map[i][j].availableWord()) {
                    return map[i][j];
                }
            }
            return null;
        }

        public void addAnswer() {
            int currentLength = path.size();
            if (currentLength <= answers.length && currentLength > 0) {
                if (answers[currentLength - 1] == null) {
                    List<Point> list = new ArrayList<>();

                    Iterator<Point> iter = path.iterator();
                    while (iter.hasNext()) {
                        list.add(iter.next());
                    }
                    answers[currentLength - 1] = list;
                }
            }
        }

        public List<Point> getMaxAnswer() {
            for (int i = answers.length - 1; i >= 0; i--) {
                if (answers[i] != null) {
                    return answers[i];
                }
            }
            return new ArrayList<>();
        }

        public void algorithm(final String[] words) throws TaskException {
            boolean isRun = true;
            while (isRun) {
                switch (state) {
                    case INIT:
                        state = NEXT;
                        init(words);
                        root = root();
                        path.addLast(root);
                        root.dec();
                        break;

                    case NEXT:
                        addAnswer();
                        if (path.size() == maxPath) {
//                    if (false) {
                            state = EXIT;
                        } else {
                            Point word;
                            if ((word = next(path.getLast())) != null) {
                                path.addLast(word);
                                word.dec();

                                state = NEXT;
                            } else {
                                state = PREV;
                            }
                        }
                        break;

                    case ALTERNATIVE:
                        state = PREV;

                        Point word;
                        if ((word = path.pollLast()) != null) {
                            word.inc();

                            Point newWord = alternative(word);
                            if (newWord != null) {
                                path.addLast(newWord);
                                newWord.dec();
                                state = NEXT;
                            }
                        }
                        break;

                    case PREV:
                        state = ROOT;
                        if (path.size() > 0) {
                            state = ALTERNATIVE;
                        }
                        break;

                    case ROOT:
                        if ((root = root(root)) != null) {
                            path.addLast(root);
                            root.dec();
                            state = NEXT;
                        } else {
                            state = EXIT;
                        }
                        break;

                    case EXIT:
                        isRun = false;
                        break;
                }
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
        try {
            Algorithm algorithm = new Algorithm();
            algorithm.algorithm(words);

            boolean isNext = false;
            for(Point p: algorithm.getMaxAnswer()) {
                if (isNext) {
                    sb.append(" ");
                } else {
                    isNext = true;
                }
                sb.append(p.word);
            }
        } catch (TaskException ex) {
            sb.append(ex.toString());
        }
        return sb;
    }
}
