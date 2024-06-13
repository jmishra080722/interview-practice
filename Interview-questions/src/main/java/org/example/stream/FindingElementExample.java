package org.example.stream;

import java.util.Arrays;
import java.util.List;

public class FindingElementExample {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10, -11);
        //Find any number divisible by 3
        Integer num = nums.stream().filter(n -> n % 3 == 0).findAny().orElse(0);
        System.out.println(num);

        //Find first number divisible by 2
        num = nums.stream().filter(n -> n%2 ==0).findFirst().get();
        System.out.println(num);
    }
}
