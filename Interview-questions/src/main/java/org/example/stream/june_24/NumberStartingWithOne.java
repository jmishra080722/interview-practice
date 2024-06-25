package org.example.stream.june_24;

import java.util.Arrays;
import java.util.List;

public class NumberStartingWithOne {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32, 12);

        myList.stream()
                .map(n -> String.valueOf(n))
                .filter(n-> n.startsWith("1"))
                .forEach(System.out::println);

    }
}
