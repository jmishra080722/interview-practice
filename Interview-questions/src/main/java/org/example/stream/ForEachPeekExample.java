package org.example.stream;

import java.util.stream.Stream;

public class ForEachPeekExample {
    public static void main(String[] args) {
        Stream<Integer> nums = Stream.of(1,2,3,4,5,6,7,8,9,10);
        //peek is intermediate operation
        Integer[] largeNumbers = (Integer[]) nums.filter(i -> i > 5)
                .peek(System.out::println).toArray();

        //forEach is terminal operation
        System.out.println("==================");
        nums = Stream.of(1,2,3,4,5,6,7,8,9,10);  //We have to initialize this
                                                        // because its already consumed
        nums.filter(i -> i<7)
                .forEach(n -> System.out.println(n));
    }
}
