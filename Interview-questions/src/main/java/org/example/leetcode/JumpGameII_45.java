package org.example.leetcode;

public class JumpGameII_45 {
    public static void main(String[] args) {
        int[] nums = {2,4,1,2, 3, 1 ,1 , 2};
        int numOfJump = jump(nums);
        System.out.println(numOfJump);
    }

    private static int jump(int[] nums) {
        int target = nums.length-1;
        int lastJumpedIndex = 0;
        int totalNumOfJump = 0;
        int coverage = 0;

        if(nums.length == 1){
            return totalNumOfJump;
        }

        for(int i = 0; i <= target; i++){
            coverage = Math.max(coverage, i+nums[i]);

            if(lastJumpedIndex == i){
                lastJumpedIndex = coverage;
                totalNumOfJump++;
                if(coverage >= target){
                    return totalNumOfJump;
                }
            }
        }
        return totalNumOfJump;
    }
}
