package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        Random random = new Random();
        IntStream.range(0, 10)
                .forEach(index -> map.put("surname" + index, Math.abs(random.nextInt() % 1000)));
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        List<String> keys = map.keySet().stream().collect(Collectors.toList());
        keys.stream()
                .filter(key -> map.get(key) <= 500)
                .forEach(map::remove);
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = Solution.createMap();
        map.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("\n---Delete---\n");
        removeItemFromMap(map);

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}