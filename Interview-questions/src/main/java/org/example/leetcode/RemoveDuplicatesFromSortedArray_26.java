package org.example.leetcode;

import org.example.leetcode150.Util;

public class RemoveDuplicatesFromSortedArray_26 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        Util.print(nums);
        int k = removeDuplicates(nums);
        System.out.println(k);
        Util.print(nums);
    }

    private static int removeDuplicates2(int[] nums) {
        int index = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    private static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];
        int j = 1;
        for(int i = 1; i< nums.length; i++){
                if(nums[i] == nums[i-1]){
                    continue;
                }else {
                    result[j] = nums[i];
                    j++;
                }
        }
        for(int i = 0; i< result.length; i++){
            nums[i] = result[i];
        }
        return j;
    }
}
