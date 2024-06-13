package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LimitSkipExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //First two even number
        List<Integer> evenNums = nums.stream()
                .filter(n -> n % 2 == 0)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(evenNums);

        //Find all odd number except first two
        nums.stream()
                .filter(n -> n % 2 != 0)
                .skip(2)
                .forEach(System.out::println);
    }
}
