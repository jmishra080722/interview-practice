package org.example.leetcode;

public class ContainerWithMostWater {
   /* 08045471090
    08069290890
    support.realmetechlife@flipkart.com*/

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }

    private static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right){
            maxArea = Math.max(maxArea, Math.min( height[left],  height[right]) * ( right - left) );
            if( height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}
