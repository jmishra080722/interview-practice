package org.example.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations_II_47 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> permutations = permute2(nums);
        System.out.println(permutations);
    }

    private static List<List<Integer>> permute2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack2(result, used, nums, new ArrayList<>());
        return result;
    }

    private static void backtrack2(List<List<Integer>> result, boolean[] used, int[] nums, ArrayList<Integer> tempList) {
        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0; i< nums.length; i++){
            if(used[i] ){
                continue;
            }
            // duplicate handling
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }

            used[i] = true;
            tempList.add(nums[i]);
            backtrack2(result, used, nums, tempList);

            //backtrack
            used[i] = false;
            tempList.remove(tempList.size() - 1);

        }

    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, 0, nums);
        return new ArrayList<>(result);
    }

    private static void backtrack(List<List<Integer>> result, int index, int[] nums) {

        if(index == nums.length){
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        Set<Integer> seen = new HashSet<>();

        for(int i = index; i< nums.length; i++){
            /*if(i > index && nums[i] == nums[i-1]){
                continue;
            }*/
            if(seen.contains(nums[i])){
                continue;
            }
            seen.add(nums[i]);
            swap(nums, index, i);
            backtrack(result, index+1, nums);
            swap(nums, index, i);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
