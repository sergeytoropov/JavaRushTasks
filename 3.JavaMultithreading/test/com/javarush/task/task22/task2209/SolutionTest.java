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
    private String[] words5 = {"Киев", "Нью-Йорк", "Амстердам", "Вена", "Мельбурн", "Амстердам"};

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
        Solution.Algorithm algorithm = new Solution.Algorithm();
        algorithm.init(words);
        print(algorithm.getMap());
    }

    @Test
    public void root() throws Solution.TaskException {
        Solution.Algorithm algorithm = new Solution.Algorithm();
        algorithm.init(words);

        Solution.Point root = algorithm.root();
        assertThat(root, is(new Solution.Point(1, "Амстердам", 0, 13)));

        root = algorithm.root(root);
        assertThat(root, is(new Solution.Point(1, "Вена", 2, 0)));

        root = algorithm.root(root);
        assertThat(root, is(new Solution.Point(1, "Киев", 11, 2)));

        root = algorithm.root(root);
        assertThat(root, is(new Solution.Point(1, "Мельбурн", 13, 14)));

        root = algorithm.root(root);
        assertThat(root, is(new Solution.Point(1, "Нью-Йорк", 14, 11)));

        root = algorithm.root(root);
        assertThat(root, nullValue());
    }

    @Test
    public void run() {
        StringBuilder sb = Solution.getLine(words);
        System.out.println(sb.toString());
    }

    @Test
    public void run2() {
        StringBuilder sb = Solution.getLine(new String[] {"АА", "АА"});
        assertThat(sb.toString(), is("АА АА"));
    }

    @Test
    public void run3() {
        StringBuilder sb = Solution.getLine(new String[] {"АА", "АА", "ПП"});
        assertThat(sb.toString(), is("АА АА"));
    }

    @Test
    public void run4() {
        StringBuilder sb = Solution.getLine(new String[] {"АА", "АА", "АА", "АА"});
        assertThat(sb.toString(), is("АА АА АА АА"));
    }

    @Test
    public void run5() {
        StringBuilder sb = Solution.getLine(words5);
        assertThat(sb.toString(), is("Амстердам Мельбурн Нью-Йорк Киев Вена Амстердам"));
    }

    @Test
    public void run6() {
        StringBuilder sb = Solution.getLine(new String[] {"АА"});
        assertThat(sb.toString(), is("АА"));
    }

    @Test
    public void run7() {
        StringBuilder sb = Solution.getLine(new String[] {"АА", "АА", "АА", "АТ", "ТТ", "ТТ", "ТТ", "ТЯ", "ЯЯ", "ЯЯ", "ЯЯ"});
        assertThat(sb.toString(), is("АА АА АА АТ ТТ ТТ ТТ ТЯ ЯЯ ЯЯ ЯЯ"));
    }

    @Test
    public void run8() {
        StringBuilder sb = Solution.getLine(new String[] {"АА", "АА", "АА", "ИИ", "АТ", "ТТ", "ЙЙ", "ТТ", "ТТ", "ТЯ", "ЯЯ", "ЯЯ", "ЯЯ", "ЦЦ"});
        assertThat(sb.toString(), is("АА АА АА АТ ТТ ТТ ТТ ТЯ ЯЯ ЯЯ ЯЯ"));
    }

    @Test
    public void run9() {
        StringBuilder sb = Solution.getLine(new String[] {"АА", "АА", "АА", "АА", "АА", "АА", "АА", "АА", "АА", "ИИ", "АА", "ТТ", "ЙЙ", "ТТ", "ТТ", "ТЯ", "ЯЯ", "ЯЯ", "ЯЯ", "ЦЦ"});
        assertThat(sb.toString(), is("АА АА АА АА АА АА АА АА АА АА"));
    }

    @Test
    public void run10() {
        StringBuilder sb = Solution.getLine(new String[]{"АА", "АА", "АА", "АА", "АА", "АА", "АА", "АА", "АА", "ИИ", "АА", "ТТ", "ЙЙ", "ТТ", "ТТ", "ТЯ", "ЯЯ", "ЯЯ", "ЯЯ", "ЦЦ", "ЯА"});
        assertThat(sb.toString(), is("ТТ ТТ ТТ ТЯ ЯЯ ЯЯ ЯЯ ЯА АА АА АА АА АА АА АА АА АА АА"));
    }

    @Test
    public void run11() {
        StringBuilder sb = Solution.getLine(new String[] {"А"});
        assertThat(sb.toString(), is("А"));
    }

    @Test
    public void run12() {
        StringBuilder sb = Solution.getLine(new String[] {"А", "А", "И", "АИ", "Ц", "Ы"});
        assertThat(sb.toString(), is("А А АИ И"));
    }

    public static void main(String[] args) {
        // /Users/sergeytoropov/github/JavaRushTasks/3.JavaMultithreading/src/com/javarush/task/task22/task2209/test1.txt
        Solution.main(null);
    }
}