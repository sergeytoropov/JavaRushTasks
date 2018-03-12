package com.javarush.task.task25.task2511;

import org.junit.Test;

import java.util.Collections;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 12.03.18
 */
public class SolutionTest {

    @Test
    public void run() {
        Solution solution = new Solution(new TimerTask() {
            @Override
            public void run() {
                throw new RuntimeException("ABCD");
            }
        });

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(solution);
    }

    @Test
    public void test() {
        String answer = Collections.nCopies(5,  "*").stream().reduce("", (acc, element) -> acc = acc + element);
        System.out.println(answer);
    }
}