package com.javarush.task.task21.task2109;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static com.javarush.task.task21.task2109.Solution.*;
import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 21.07.17
 */
public class SolutionTest {

    @Test
    public void cloneA () throws CloneNotSupportedException {
        A a = new A(1, 3);
        A a2 = (A) a.clone();
        assertFalse(a.equals(a2));
        System.out.println(a);
        System.out.println(a2);
    }

    @Test(expected = CloneNotSupportedException.class)
    public void permitCloneB() throws CloneNotSupportedException {
        B b = new B(1, 3, "B");
        System.out.println(b);
        B b2 = (B) b.clone();
    }

    @Test
    public void cloneC() throws CloneNotSupportedException {
        C c = new C(1, 3, "C");
        C c2 = (C) c.clone();
        assertFalse(c.equals(c2));
        System.out.println(c);
        System.out.println(c2);
    }
}