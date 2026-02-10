package org.example.leetcode;

import org.example.leetcode150.Util;

public class NextPermutation_31 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        Util.print(nums);
        nextPermutation(nums);
        Util.print(nums);
    }


    private static void nextPermutation(int[] nums) {
        int i = nums.length - 2; //i started from 2nd last as we compare this with last element as well
        //Go back till first decreasing number found from right
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        //swap that number with just greater number form right side
        if(i >= 0){
            int j = nums.length - 1;
            while(j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i, j);
        }
        //Reverse all the number right from that number
        reverse(nums, i+1);
    }

    private static void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
