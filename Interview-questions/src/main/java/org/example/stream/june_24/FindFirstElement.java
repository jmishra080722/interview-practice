package org.example.stream.june_24;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirstElement {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        Optional<Integer> first = myList.stream()
                .findFirst();
        System.out.println(first.get());
    }
}
