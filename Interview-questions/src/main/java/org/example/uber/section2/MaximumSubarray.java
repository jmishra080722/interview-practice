package org.example.uber.section2;

//Given an integer array nums, find the
//sub array with the largest sum, and return its sum.
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = findMAxSumOfSubArray(nums);
        System.out.println(maxSum);
    }

    private static int findMAxSumOfSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentMaxSum = nums[0];

        for(int i = 1; i< nums.length; i++){
            currentMaxSum = Math.max(nums[i] , currentMaxSum +nums[i]);
            maxSum = Math.max(currentMaxSum, maxSum);
        }
        return maxSum;
    }
}
