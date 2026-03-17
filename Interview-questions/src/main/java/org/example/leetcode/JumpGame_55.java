package org.example.leetcode;

public class JumpGame_55 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 0};
        boolean isPossible = canJump2(nums);
        System.out.println(isPossible);
    }

    private static boolean canJump2(int[] nums) {
        int target = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(i+nums[i] >= target){
                target = i;
            }
        }
        return target == 0;
    }

    private static boolean canJump(int[] nums) {
        int target = nums.length-1;
        int lastJumpedIndex = 0;
        int totalNumOfJump = 0;
        int coverage = 0;
        if(nums.length == 1){
            return true;
        }

        for(int i = 0; i< nums.length; i++){
            coverage = Math.max(coverage, i + nums[i]);

            if(lastJumpedIndex == i){
                totalNumOfJump++;
                lastJumpedIndex = coverage;
                if(coverage >= target){
                    return true;
                }
            }
        }
        return false;
    }
}
