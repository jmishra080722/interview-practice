package org.example.leetcode;

import org.example.leetcode150.Util;

public class TrappingRainWater_42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int totalWater = trap(height);
        System.out.println(totalWater);

    }

    private static int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        int totalWater = 0;

        for(int i = 1; i< n; i++){
                leftMax[i] = Math.max(leftMax[i-1], height[i]);
                rightMax[n - 1 - i] = Math.max(rightMax[n - 1 - i + 1], height[n - 1 - i ]);
        }
        for(int i = 0; i < n; i++){
            totalWater = totalWater + (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return totalWater;
    }
}
