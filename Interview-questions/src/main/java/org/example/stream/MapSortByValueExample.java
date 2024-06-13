package org.example.stream;

import java.util.*;

public class MapSortByValueExample {
    public static void main(String[] args) {
        // Original map
        Map<Integer, String> integerStringMap = new HashMap<>();
        integerStringMap.put(1, "One");
        integerStringMap.put(2, "Two");
        integerStringMap.put(3, "Three");
        integerStringMap.put(4, "Four");
        integerStringMap.put(5, "Five");

        // Sort the map by values
        Map<Integer, String> sortedMap = sortByValue(integerStringMap);

        // Print the sorted map
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Method to sort a map by its values
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
