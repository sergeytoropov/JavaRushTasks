package com.javarush.task.task25.task2514;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 12.03.18
 */
public class SolutionTest {

    @Test
    public void run() {
        IntStream.range(0, 5000).forEach(index -> {
            Thread thread = new Thread(new Solution.YieldRunnable(index));
            thread.start();
        });
    }
}