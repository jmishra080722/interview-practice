package org.example.leetcode150;

public class RemoveDuplicatesfromSortedArray2 {
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

   /* int j = 1;
        for (int i = 1; i < nums.length; i++) {
        if (j == 1 || nums[i] != nums[j - 2]) {
            nums[j++] = nums[i];
        }
    }
        return j;*/

}
