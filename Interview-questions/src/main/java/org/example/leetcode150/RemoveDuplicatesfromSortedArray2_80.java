package org.example.leetcode150;

/*
* Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element
* appears at most twice. The relative order of the elements should be kept the same.
Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first
* part of the array nums.
* More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
* It does not matter what you leave beyond the first k elements. Return k after placing the final result in the first k slots of nums.
Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
* */
//Q: 80. Remove Duplicates from Sorted Array II
//URL: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
public class RemoveDuplicatesfromSortedArray2_80 {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        Util.print(arr);
        System.out.println(removeDuplicates(arr));
        Util.print(arr);


    }

    private static int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i=1; i< nums.length; i++){
            if(index == 1 || nums[i] != nums[index-2]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
