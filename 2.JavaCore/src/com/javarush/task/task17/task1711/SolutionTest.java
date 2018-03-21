package com.javarush.task.task17.task1711;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 20.03.18
 */
public class SolutionTest {

    private void print() {
        System.out.println("--- allPeople ---");
        Solution.allPeople.stream().forEach(System.out::println);
    }

    @Test
    public void create() {
        Solution.main(new String[] {"-c", "Toropov Sergey", "м", "22/10/1978", "Иванова Рая", "ж", "11/01/1971"});
        print();
    }

    @Test
    public void update() {
        Solution.main(new String[] {"-u", "0", "Toropov Sergey", "м", "22/10/1978", "1", "Иванова Рая", "ж", "11/01/1971"});
        print();
    }

    @Test
    public void delete() {
        Solution.main(new String[] {"-d", "1", "0"});
        print();
    }

    @Test
    public void info() {
        Solution.main(new String[] {"-d", "0", "1"});
    }
}