package com.javarush.task.task21.task2108;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static com.javarush.task.task21.task2108.Solution.*;
import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 21.07.17
 */
public class SolutionTest {

    @Test
    public void equal() {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Arrays.stream(tree.getBranches()).forEach(branch -> {
            System.out.print(Integer.toHexString(branch.hashCode()) + ", ");
        });
        System.out.println();

        Arrays.stream(clone.getBranches()).forEach(branch -> {
            System.out.print(Integer.toHexString(branch.hashCode()) + ", ");
        });
        System.out.println();

        assertThat(tree, equalTo(clone));
    }

    @Test
    public void hashString() {
        String s = "abc";
        String s2 = String.valueOf(s);

        System.out.println(s);
        System.out.println(s2);

        assertThat(s, equalTo(s2));

    }
}