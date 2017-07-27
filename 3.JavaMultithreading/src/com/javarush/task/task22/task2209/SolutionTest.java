package com.javarush.task.task22.task2209;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 24.07.17
 */
public class SolutionTest {
    String path = "src/com/javarush/task/task22/task2209/";
    String test1 = path + "test1.txt";
    File file;

    @Test
    public void fileExist() {
        assertTrue(new File(test1).exists());
    }

    @Test
    public void readFile() throws IOException {
        Arrays.stream(Solution.getWords(test1)).forEach(word -> System.out.println(word));
    }

    @Test
    public void test1() throws IOException {
        System.out.println(Solution.getLine(Solution.getWords(test1)));
    }

    public void a(String ... words) {
        System.out.println(words);
        if (words != null) {
            Arrays.stream(words).forEach(word -> System.out.println(word));
        }
    }

    @Test
    public void empty() {
        a(null);
        a(new String[0]);
        a(new String[] {"a", "ab", "abc"});
        System.out.println(new StringBuilder());
        System.out.println(new StringBuilder(""));
        System.out.println(new StringBuilder("abccba"));
    }
}