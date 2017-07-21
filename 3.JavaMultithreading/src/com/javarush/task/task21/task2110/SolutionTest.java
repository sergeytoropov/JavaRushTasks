package com.javarush.task.task21.task2110;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 21.07.17
 */
public class SolutionTest {
    String path = "src/com/javarush/task/task21/task2110/";
    String zipFileName = "text.zip";
    String outputFileName = "text.txt";
    File file;

    @Before
    public void init() {
        file = new File(path + zipFileName);
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void exsistFile() {
        assertTrue(file.exists());
    }

    @Test
    public void canReadWrite() {
        assertTrue(file.canRead());
        assertTrue(file.canWrite());
    }

    @Test
    public void writeZipEntriesToFile() {
        Solution.writeZipEntriesToFile(path + zipFileName, path + outputFileName);
    }
}