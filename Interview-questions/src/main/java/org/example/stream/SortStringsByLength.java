package org.example.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortStringsByLength {
    public static void main(String[] args) {
        // List of strings to be sorted
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "strawberry", "orange", "grape");

        // Sort the list by the length of each string using streams and method reference
        List<String> sortedStrings = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        // Print the sorted list
        sortedStrings.forEach(System.out::println);
    }
}
