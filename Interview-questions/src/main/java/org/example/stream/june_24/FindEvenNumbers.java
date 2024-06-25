package org.example.stream.june_24;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.leetcode150.Util.print;
import static org.example.leetcode150.Util.printList;

public class FindEvenNumbers {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
        List<Integer> collect = list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        printList(collect);
    }
}
