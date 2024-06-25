package org.example.stream.june_24;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindMaxElement {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        Integer max = myList.stream().max((n1, n2) -> Integer.compare(n1, n2)).get();
        System.out.println(max);

    }
}
