package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static String getQuery(Map<String, String> params) {
        return params.keySet().stream()
                .map(key -> {
                    String value = params.get(key);
                    return value != null ? " and " + key + " = '" + value + "'" : ""; })
                .filter(key -> !"".equals(key))
                .reduce("",  (acc, element) -> acc + element)
                .replaceFirst(" and ", "");
    }
}
