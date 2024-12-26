package org.example.leetcode150;

//Q: 55. Jump Game
//URL: https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
public class JumpGame_55 {
    public static void main(String[] args) {

        int[] nums = {2,3,1,1,4};
        boolean result = canJump(nums);
        System.out.println(result);
    }

    private static boolean canJump(int[] nums) {

        int lastIndex = nums.length - 1;
        for(int i = nums.length - 2; i >=0; i--){
            if(i + nums[i] >= lastIndex){
                lastIndex = i;
            }
        }
        return lastIndex == 0;
    }
}
