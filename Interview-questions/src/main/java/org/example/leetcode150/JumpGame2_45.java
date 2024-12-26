package org.example.leetcode150;


//Q: 45. Jump Game II
//URL: https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150
public class JumpGame2_45 {

    public static void main(String[] args) {
        int[] nums = {1,2};
        int numOfJumps = numOfJumps(nums);
        System.out.println(numOfJumps);
    }

    private static int numOfJumps(int[] nums) {

        int target = nums.length-1;
        int coverage = 0;
        int lastJumpIndex = 0;
        int totalNumOfJumps = 0;
        if(nums.length ==1){
            return totalNumOfJumps;
        }
        for(int i = 0; i<= target; i++){  //2,3,1,1,4
            coverage = Math.max(coverage, i + nums[i]);

            if(lastJumpIndex == i){
                lastJumpIndex = coverage;
                totalNumOfJumps++;
                if(coverage >= target){
                    return totalNumOfJumps;
                }
            }
        }
        return totalNumOfJumps;
    }
}
