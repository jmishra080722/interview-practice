package org.example.leetcode;

public class SearchInsertPosition_35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        int index = searchInsert(nums, target);
        System.out.println(index);
    }

    private static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(target == nums[mid]){
               return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
