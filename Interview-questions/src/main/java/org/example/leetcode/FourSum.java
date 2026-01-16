package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        /*int[] nums = {1,0,-1,0,-2,2};
        int target = 0;*/
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> quadruplets = fourSumRecursion(nums, target);
        System.out.println(quadruplets);
    }

    private static List<List<Integer>> fourSumRecursion(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result  = new ArrayList<>();
        List<Integer> quad = new ArrayList<>();

        //As this is 4 sum so initial value is 4
        kSum(4, 0, nums, (long)target, result, quad);
        return result;
    }

    private static void kSum(int k, int start, int[] nums, long target, List<List<Integer>> result, List<Integer> quad) {
        if(k != 2){
            for(int i = start; i< nums.length-k+1; i++){
                if(i > start && nums[i] == nums[i-1]){
                    continue;
                }
                quad.add(nums[i]);
                kSum(k-1, i + 1, nums, target - nums[i], result, quad);
                quad.remove(quad.size()-1);
            }
        }else{
            int left = start;
            int right = nums.length-1;
            while (left < right){
                long sum = (long) nums[left] + nums[right];
                if(sum < target){
                    left++;
                }else if(sum > target){
                    right--;
                }else {
                    quad.add(nums[left] );
                    quad.add(nums[right]);
                    result.add(new ArrayList<>(quad));
                    quad.remove(quad.size()-1);
                    quad.remove(quad.size()-1);
                    left++;
                    while (left <  right && nums[left] == nums[left-1]){
                        left++;
                    }
                }
            }
        }
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i< nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            long tempTarget = (long)target - nums[i];
            List<List<Integer>> triple = findTripletes(i+1, tempTarget, nums);
            for(int m = 0; m<triple.size(); m++){
                List<Integer> temp = new ArrayList<>(triple.get(m));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }

    private static List<List<Integer>> findTripletes(int i, long tempTarget, int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for(int start = i; start< nums.length-1; start++){
            if(start > i && nums[start] == nums[start-1]){
                continue;
            }
            int j = start+1;
            int k = nums.length-1;
            while (j < k){
                long sum = (long)nums[start] + nums[j]+ nums[k];

                if(sum < tempTarget){
                    j++;
                }else if(sum > tempTarget){
                    k--;
                }else {
                    result.add(Arrays.asList(nums[start],nums[j], nums[k] ));
                    j++;
                    while (j<k && nums[j] == nums[j-1]){
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
