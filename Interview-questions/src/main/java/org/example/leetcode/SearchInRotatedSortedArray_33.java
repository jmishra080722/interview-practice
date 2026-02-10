package org.example.leetcode;

public class SearchInRotatedSortedArray_33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int index = search2(nums, target);
        System.out.println(index);
    }

    private static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int mid = left + (right - left) /2;
            if(target == nums[mid]){
                return mid;
            }

            //Left half is sorted
            if (nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            } else {  //Right half is sorted
                if(target > nums[mid] && target <= nums[right]){
                    left = mid+1;
                }else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }

    private static int search(int[] nums, int target) {
        int k = 0;
        int  result = -1;
        while(k < nums.length-1 && nums[k] < nums[k+1]){
            k++;
        }
        if(target == nums[k]){
            result = k;
        }else if(target >= nums[0] && target < nums[k]){
            for(int i = 0; i< k; i++){
                if(target == nums[i]){
                    result = i;
                    break;
                }
            }
        }else {
            for(int i = k+1; i< nums.length; i++){
                if(nums[i] == target){
                    result = i;
                    break;
                }
            }
        }
        return result;
    }
}
