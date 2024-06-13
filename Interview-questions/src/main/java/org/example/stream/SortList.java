package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortList {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "strawberry", "orange", "grape");

        List<String> sortedList = strings.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());

        System.out.println(sortedList);

    }
}
