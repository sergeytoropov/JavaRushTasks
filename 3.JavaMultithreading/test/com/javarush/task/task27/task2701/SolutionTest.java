package com.javarush.task.task27.task2701;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 29.03.18
 */
public class SolutionTest {
    @Test
    public void test() {
        assertTrue(Solution.isSubstringPresent("cat", "This is a cat"));
        assertFalse(Solution.isSubstringPresent("cat", "This is a dog"));
    }
}