package org.example.leetcode;

public class RemoveElement_27 {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int k = removeElement1(nums, val);
        System.out.println(k);
    }

    private static int removeElement1(int[] nums, int val) {
        int index = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
        print(nums);
        return index;
    }

    private static int removeElement(int[] nums, int val) {
        int last = nums.length-1;
        for(int i = 0; i<=last ; i++){
            if(nums[i] == val){
                nums[i] = nums[last];
                nums[last] = 0;
                last--;
                i--;
            }
        }
        return last+1;
    }
    private static void print(int[] nums){
        for(int i = 0; i< nums.length; i++){
            System.out.print(nums[i]+" , ");
        }
        System.out.println();
    }
}


/*
*  for(int i = 0; i< nums.length; i++){
            System.out.print(nums[i]+" , ");
        }
        System.out.println();*/
