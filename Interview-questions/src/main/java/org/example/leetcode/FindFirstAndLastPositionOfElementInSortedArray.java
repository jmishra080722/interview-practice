package org.example.leetcode;

import org.example.leetcode150.Util;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] result = searchRange(nums, target);
        Util.print(result);
    }

    private static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private static int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right){
            int mid = left + (right - left )/2;
            if(target == nums[mid]){
                index = mid;
                left = mid+1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return index;
    }

    private static int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(target == nums[mid]){
                index = mid;
                right = mid - 1;
            }else if(target < nums[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return index;
    }


    //Time complexity O(n)
    private static int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int position = -1;
        while(left <= right){
            int mid = left + ( right - left ) / 2;
            if(target == nums[mid]){
                position = mid;
                break;
            }
            if(target >= nums[left] && target < nums[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        int start = position;
        int end = position;
        while (start >= 1 && nums[start] == nums[start - 1] ){
            start--;
        }
        while (end != -1 && end < nums.length-1 && nums[end] == nums[end+1]){
            end++;
        }
        return new int[]{start, end};
    }
}
