package com.javarush.task.task24.task2413;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 01.03.18
 */
public class CanvasTest {
    Canvas canvas;

/*    @Before
    public void init() {
        canvas = new Canvas(6, 4);
    }*/

    @Test
    public void print() {
        canvas = new Canvas(6, 4);
        printMatrix(canvas.getMatrix());
    }

    public void printMatrix(char[][] m) {
        System.out.println("\n--- Start ---\n");
        for(int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n--- End ---\n");
    }

    @Test
    public void draw() {
        canvas = new Canvas(6, 4);
        int[][] m2 = new int[][] {{1, 2, 3, 4, 5, 6, 7, 8}};

        canvas.drawMatrix(1, 1, m2, '-');
        printMatrix(canvas.getMatrix());
    }

    @Test
    public void clear() {
        draw();
        canvas.clear();
        printMatrix(canvas.getMatrix());
    }
}