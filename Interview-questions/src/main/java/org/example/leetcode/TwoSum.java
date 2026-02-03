package org.example.leetcode;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] results = twoSum(nums, target);
        print(results);
    }

    public static void print(int[] nums){
        for(int n: nums){
            System.out.print(n+" ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){  // {3,2,4};
            int rem = target  - nums[i];
            if(map.containsKey(rem)){
                return new int[]{map.get(rem), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
