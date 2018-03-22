package com.javarush.task.task24.task2413;

import java.util.stream.IntStream;

/**
 * @author sergeytoropov
 * @since 29.08.17
 */
public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height + 2][width + 2];
    }

    public void setPoint(double x, double y, char c) {
        int iX = (int) Math.round(x);
        int iY = (int) Math.round(y);

        if (iX < 0 || iY < 0 || iY >= matrix.length || iX >= matrix[0].length) {
            return;
        }
        matrix[iY][iX] = c;
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }

    public void clear() {
        IntStream.range(0, matrix.length).forEach(i -> {
            IntStream.range(0, matrix[i].length).forEach(j -> {
                matrix[i][j] = 0;
            });
        });
    }

    public void print() {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}
