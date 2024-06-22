package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample1 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        //find length of each string
        List<Integer> collect = words.stream().map(s -> s.length()).collect(Collectors.toList());
        System.out.println(collect);
    }
}
