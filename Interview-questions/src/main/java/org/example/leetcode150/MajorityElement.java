package org.example.leetcode150;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
*/
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    private static int majorityElement2(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int a: nums){
            int val = map.getOrDefault(a, 0) +1;
            if(val > nums.length/2){
                 return a;
            }
            map.put(a, val);
        }
        return 0;
    }

    private static int majorityElement(int[] nums) {
        int len = nums.length;
        int majority = len/2;
        Map<Integer, Integer> map = new HashMap<>();
        if(len == 1){
            return nums[0];
        }else{
            for (int a : nums) {
                if (!map.containsKey(a)) {
                    map.put(a, 1);
                } else {
                    int val = map.get(a) + 1;
                    if (val > majority) {
                        return a;
                    }
                    map.put(a, val);
                }
            }
        }
        return 0;
    }
}
