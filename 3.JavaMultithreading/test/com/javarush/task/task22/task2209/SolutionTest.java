package com.javarush.task.task22.task2209;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 02.03.18
 */
public class SolutionTest {
    private String[] words = {"Киев", "Нью-Йорк", "Амстердам", "Вена", "Мельбурн"};
    //private String[] words = {"Киев", "Нью-Йорк", "Амстердам", "Вена", "Мельбурн", "Амстердам"};

    @Test
    public void utilIndex() throws Solution.TaskException {
        assertThat(Solution.Util.indexOf('а'), is(0));
        assertThat(Solution.Util.indexOf('А'), is(0));
        assertThat(Solution.Util.indexOf('я'), is(32));
        assertThat(Solution.Util.indexOf('Я'), is(32));
    }

    @Test(expected = Solution.TaskException.class)
    public void utilIndexException() throws Solution.TaskException {
        Solution.Util.indexOf('Z');
    }

    @Test
    public void readFile() throws IOException {
        File f = new File("test/com/javarush/task/task22/task2209/data/test1.txt");
        assertThat(Solution.getWords(f.getAbsolutePath()), arrayContaining(words));
    }

    @Test
    public void emptyStringBuilder() {
        assertThat(Solution.getLine().toString(), is(""));
    }

    public void print(Solution.Point[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    @Test
    public void init() throws Solution.TaskException {
        Solution.init(words);
        print(Solution.map);
    }
}