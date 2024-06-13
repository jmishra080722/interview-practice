package org.example.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10, -11);
        boolean anyMultipleOfThree = nums.stream().anyMatch(n -> n % 3 == 0);
        System.out.println(anyMultipleOfThree);

        boolean ifAllMoreThanFive = nums.stream().allMatch(n -> n > 5);
        System.out.println(ifAllMoreThanFive);

        boolean ifAllPositive = nums.stream().noneMatch(n -> n < 0);
        System.out.println(ifAllPositive);
    }
}
