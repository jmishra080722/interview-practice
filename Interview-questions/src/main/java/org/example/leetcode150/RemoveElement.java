package org.example.leetcode150;
/*
* Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
* The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
* Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
* Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
* The remaining elements of nums are not important as well as the size of nums.
* Return k.
* */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        Util.print(nums);
        System.out.println(removeElement(nums, val));
        Util.print(nums);

    }

    private static int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        int count = 0;
        for(int i=0; i<=last; i++){
            if(nums[i] == val){
                if(nums[last] != val){
                    nums[i] = nums[last];
                }else {
                    nums[last] = 0;
                }
                count++;
                last--;
                i--;
            }
        }
        return nums.length- count;
    }
    private static int removeElement2(int[] nums, int val) {
       int index = 0;
       for(int i=0; i< nums.length; i++){
           if(nums[i] != val){
               nums[index] = nums[i];
               index++;
           }
       }
       return index;
    }
}
