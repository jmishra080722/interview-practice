package org.example.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};//{10,20,30,40,50,60,70,80,90};
        int target = 1;
        int closestSum = threeSumClosest( nums, target) ;
        System.out.println(closestSum);
    }

    private static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i< nums.length-2; i++){
            int j = i + 1;
            int k = nums.length-1;
            while (j < k ){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > target){
                    k--;
                }else if(sum < target){
                    j++;
                }else {
                    return target;
                }

                int diffToTarget = Math.abs(sum-target);
                if(diffToTarget < minDiff){
                    result = sum;
                    minDiff = diffToTarget;
                }
            }
        }
        return result;
    }
}
