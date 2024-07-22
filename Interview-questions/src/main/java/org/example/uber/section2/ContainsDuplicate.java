package org.example.uber.section2;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//Given an integer array nums, return true if any value appears at least twice in the array,
// and return false if every element is distinct.
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        boolean duplicate = findDuplicate4(nums);
        System.out.println(duplicate);
    }

    private static boolean findDuplicate4(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums){
            if(set.contains(n)){
                return true;
            }else{
                set.add(n);
            }
        }
        return false;
    }

    private static boolean findDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }

    private static boolean findDuplicate2(int[] nums) {
        Long num = Arrays.stream(nums)
                .mapToObj(n -> Integer.valueOf(n))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entity -> entity.getValue() > 1)
                .map(entity -> entity.getValue())
                .findAny()
                .orElse(0L);
        if(num == 0L){
            return false;
        }else{
            return true;
        }
    }

    private static boolean findDuplicate(int[] nums) {
        for(int i = 0; i<nums.length; i++){
            for(int j= i+1; j< nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
