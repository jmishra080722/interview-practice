package org.example.uber.section2;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int sum = 9;
        int[] result = findIndex(nums, sum);
        for(int n: result){
            System.out.println(n);
        }
    }


    private static int[] findIndex(int[] nums, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int rem = sum  - nums[i];
            if(map.containsKey(rem)){
                return new int[]{map.get(rem), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
