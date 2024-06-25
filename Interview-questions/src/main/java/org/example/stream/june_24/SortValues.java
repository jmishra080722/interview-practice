package org.example.stream.june_24;

import org.example.leetcode150.Util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortValues {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        List<Integer> sorted = myList.stream().sorted().collect(Collectors.toList());
        Util.printList(sorted);
    }
}
