package org.example.leetcode;

import java.util.Arrays;

public class FirstMissingPositive_41 {
    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        int missingNum = firstMissingPositiveNum2(nums);
        System.out.println(missingNum);
    }

    private static int firstMissingPositiveNum2(int[] nums) {
        for(int i =0; i< nums.length; i++){
            if(nums[i] < 0){
                nums[i] = 0;
            }
        }
        for(int i = 0; i< nums.length; i++){
            int val = Math.abs(nums[i]);
            if(val >= 1  && val <= nums.length){
                if(nums[val - 1] > 0){
                    nums[val - 1] = nums[val - 1] * -1;
                }else if(nums[val - 1] == 0){
                    nums[val - 1] = -1* (nums.length + 1);
                }
            }
            }
        for(int i = 0; i< nums.length; i++){
            if(nums[i] >=0 ){
                return i+1;
            }
        }
        return nums.length+1;
    }

    private static int firstMissingPositiveNum(int[] nums) {
        int firstMissingPositiveNum = 1;
        Arrays.sort(nums);
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == firstMissingPositiveNum){
                firstMissingPositiveNum++;
            }else if(nums[i] > firstMissingPositiveNum ){
                break;
            }
        }
        return firstMissingPositiveNum;
    }
}
