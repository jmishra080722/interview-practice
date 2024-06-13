package org.example.leetcode150;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
*/

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7 };
        int k = 3;
        Util.print(nums);
        rotate2(nums, k);
        Util.print(nums);
    }

    private static void rotate(int[] nums, int k) {
        int len = nums.length;
        while (k > 0){
            int temp = nums[len-1];
            for(int i=0; i<len; i++){
                int temp2=  nums[i];
                nums[i] = temp;
                temp = temp2;
            }
            k--;
        }
    }

    private static void rotate2(int[] nums, int k) {
        int len = nums.length;
        k = k%len;   //Ensure that k should be less than len;

        //TODO: 1, 2, 3, 4, 5, 6, 7 -> 5, 6, 7,1,2 ,3 ,4
        reverse(nums, 0 , len-1);  //1, 2, 3, 4, 5, 6, 7 -> 7, 6, 5,4 ,3 ,2 ,1
        reverse(nums, k, len-1);   //7, 6, 5, 4 ,3 ,2 ,1 -> 7, 6, 5, 1, 2, 3, 4
        reverse(nums, 0, k-1);   //7, 6, 5, 1, 2, 3, 4 -> 5, 6, 7, 1, 2, 3, 4,
    }

    private static void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
