package org.example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExampleTwo {
    public static void main(String[] args) {
        List<List<Integer>> listOfList= Arrays.asList(
               Arrays.asList(1,2, 3),
               Arrays.asList(4, 5,6),
                Arrays.asList(7, 8, 9)
        );
        //Print square of all elements in a single list
        List<Integer> collect = listOfList.stream()
                .flatMap(List::stream)
                //.map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
