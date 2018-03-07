package com.javarush.task.task25.task2503;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();

        Arrays.stream(realOrder)
                .filter(position -> position >= 0)
                .sorted()
                .mapToObj(position ->
                    IntStream.range(0, realOrder.length)
                            .filter(index -> realOrder[index] == position)
                            .mapToObj(index -> values()[index])
                            .findFirst().get())
                .forEach(column -> result.add(column));

        return result;
    }


    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isShown() {
        return realOrder[ordinal()] >= 0 ? true : false;
    }

    @Override
    public void hide() {
        int position = realOrder[ordinal()];
        if (position >= 0) {
            realOrder[ordinal()] = -1;
            IntStream.range(0, realOrder.length).forEach(index -> {
                if (realOrder[index] > position) {
                    realOrder[index] = realOrder[index] - 1;
                }
            });
        }
    }
}
