package org.example.stream.june_24;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,};
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).mapToObj(n -> Integer.valueOf(n))
                .forEach(n -> set.add(n));

        if(nums.length == set.size()){
            System.out.println("No duplicate");
        }else{
            System.out.println("Some duplicates present");
        }
    }
}
