package org.example.leetcode150;


//42. Trapping Rain Water
// URL: https://leetcode.com/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-interview-150
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        int water = trapWater(height);
        System.out.println(water);
    }

    private static int trapWater(int[] height) {
        int n = height.length;
        int totalWater = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];


        for(int i =0 ; i< n ; i++){
            if(i ==0 ){
                leftMax[i] = height[i];
                rightMax[n-1] = height[n-1];
            }else{
                leftMax[i] = Math.max(height[i], leftMax[i-1]);  //This will compare with left index of the current index
                rightMax[n-1 - i] = Math.max(height[n - i - 1], rightMax[n - i]);   //rightMax[n - i] : This is actually rightMax[n - i - 1 + 1]. Bcz this will compare with right index of the current index
            }
        }

        for(int i = 0; i< n; i++){
            totalWater = totalWater + Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return totalWater;
    }

}
