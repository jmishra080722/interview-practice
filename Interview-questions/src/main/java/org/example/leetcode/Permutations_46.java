package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations_46 {
    public static void main(String[] args) {
        int[] nums = {1 ,2, 3};
        List<List<Integer>> allPermutations = permute2(nums);
        System.out.println(allPermutations);
    }

    private static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack2(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack2(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums) {

        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int num: nums){
            if(tempList.contains(num)){
                continue;
            }
            tempList.add(num);
            backtrack2(result, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private static void backtrack(int[] nums, int index, List<List<Integer>> result) {
        if(index == nums.length){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return ;
        }
        for(int i = index; i< nums.length; i++){
            swap(nums, index, i);
            backtrack(nums, index + 1, result);
            swap(nums, index, i);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
