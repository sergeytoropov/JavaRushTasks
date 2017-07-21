package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Solution {
    private static char[] buf = new char[2048];

    public static String getFileName() {
        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException ioe) {
        }
        return fileName;
    }

    public static String getTagName(String[] args) {
        return args[0];
    }

    public static String readLine(FileReader reader) throws IOException {
        assert (reader != null);
        int count = reader.read(buf);
        return (count == -1) ? "" : String.valueOf(buf, 0, count);
    }

    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (FileReader reader = new FileReader(fileName)) {
            String line;
            do {
                line = readLine(reader);
                sb.append(line);
            } while ("".equals(line));

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return sb.toString();
    }

    public static Matcher getMatcher(String text, String regex) {
        try {
            Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CASE | Pattern.DOTALL);
            return pattern.matcher(text);
        } catch (PatternSyntaxException ex) {
            System.out.println(ex);
            throw ex;
        }
    }

    public static MatchResult nextTag(Matcher matcher) {
        if (matcher.find()) {
            return matcher.toMatchResult();
        }
        return null;
    }

    public static class Position {
        final int position;
        final int start;

        public Position(int position, int start) {
            this.position = position;
            this.start = start;
        }
    }

    public static class Pair {
        final int start;
        final int end;
        final int position;

        public Pair(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }
    }

    public static List<Pair> algorithm(String text, String openCloseTag) {
        final int STATE_NEXT = 0;
        final int STATE_EXIT = 1;
        final int STATE_PUSH = 2;
        final int STATE_POP  = 3;
        int state = STATE_NEXT;

        Deque<Position> stack = new LinkedList<>();
        List<Pair> lines = new ArrayList<>();

        Matcher matcher = getMatcher(text, openCloseTag);
        MatchResult result = null;
        int position = 0;
        boolean run = true;
        while (run) {

            switch (state) {
                case STATE_NEXT:
                    state = STATE_EXIT;
                    result = nextTag(matcher);
                    if (result != null) {
                        state = STATE_PUSH;
                        if (result.group().startsWith("</")) {
                            state = STATE_POP;
                        }
                    }
                    break;

                case STATE_EXIT:
                    run = false;
                    break;

                case STATE_PUSH:
                    stack.push(new Position(position++, result.start()));
                    state = STATE_NEXT;
                    break;

                case STATE_POP:
                    Position start = stack.poll();
                    if (start != null) {
                        lines.add(new Pair(start.start, result.end(), start.position));
                    }
                    state = STATE_NEXT;
                    break;

                default:
                    run = false;
            }
        }
        return lines;
    }

    public static void main(String[] args) {
        String tagName = getTagName(args);
        String text = readFile(getFileName());
        List<Pair> lines = algorithm(text, "<" + tagName + "\\b[^>]*>|</" + tagName + "\\s*>");

        lines.stream()
                .sorted(Comparator.comparingInt(p -> p.position))
                .forEach(pair -> System.out.println(text.substring(pair.start, pair.end)));
    }
}
