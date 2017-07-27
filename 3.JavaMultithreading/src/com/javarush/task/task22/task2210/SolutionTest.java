package com.javarush.task.task22.task2210;

import org.junit.Test;

import static org.hamcrest.Matchers.arrayContaining;
import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 26.07.17
 */
public class SolutionTest {
    @Test
    public void test() {
        assertThat(new String[] {"level22", "lesson13", "task01"}, arrayContaining(Solution.getTokens("level22.lesson13.task01", ".")));
    }
}