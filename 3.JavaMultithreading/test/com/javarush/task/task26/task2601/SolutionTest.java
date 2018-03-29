package com.javarush.task.task26.task2601;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 29.03.18
 */
public class SolutionTest {
    @Test
    public void sort() throws Exception {
        Integer[] array = new Integer[] {10, 11, 2, 22, 16, 13, 10, 10};
        Arrays.sort(array);
        Arrays.stream(array).forEach(System.out::println);
        System.out.println("\n --- \n");
        array = Solution.sort(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    @Test
    public void math() {
        int a = 3;
        System.out.println(Math.round(10d/a));
        System.out.println(10d/a);
    }
}