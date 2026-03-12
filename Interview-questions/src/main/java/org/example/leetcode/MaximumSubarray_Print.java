package org.example.leetcode;

public class MaximumSubarray_Print {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int sum = maxSubArrayPrint(nums);
        System.out.println(sum);
    }

    private static int maxSubArrayPrint(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        int start = 0;
        int end = 0;
        int tempStart = 0;

        for(int i = 1; i< nums.length; i++){
            if(nums[i] > currentSum + nums[i]){
                currentSum = nums[i];
                tempStart = i;
            }else {
                currentSum = currentSum + nums[i];
            }

            if(currentSum > maxSum){
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        System.out.println("Max Sum: "+maxSum);
        System.out.println("Sub Array: ");
        for(int i = start; i<= end; i++){
            System.out.print(nums[i]+", ");
        }
        return maxSum;
    }
}
