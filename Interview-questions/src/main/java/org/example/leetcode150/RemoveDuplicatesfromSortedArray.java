package org.example.leetcode150;

import java.util.LinkedHashMap;
/*Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
The remaining elements of nums are not important as well as the size of nums.
Return k.
*
* */
public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        Util.print(arr);
        System.out.println(removeDuplicates2(arr));
        Util.print(arr);
    }

    private static int removeDuplicates(int[] nums) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int count = 0;
        for(int i =0; i<nums.length; i++ ){
            int val = nums[i];
            if(!map.containsKey(val)){
                map.put(val, 1);
                nums[count] = val;
                count++;
            }
        }
        return count;
    }

    private static int removeDuplicates2(int[] nums) {
        int index = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
