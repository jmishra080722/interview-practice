package org.example.leetcode150;

import java.util.LinkedHashMap;

public class RemoveDuplicatesfromSortedArray {

    public static void main(String[] args) {
        int[] arr = {1,1,2};
        Util.print(arr);
        System.out.println(removeDuplicates(arr));
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
