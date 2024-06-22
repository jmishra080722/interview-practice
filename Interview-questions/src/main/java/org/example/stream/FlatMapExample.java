package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        List<Character> collect = words.stream().flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
