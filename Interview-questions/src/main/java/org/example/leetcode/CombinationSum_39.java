package org.example.leetcode;

import java.util.*;

public class CombinationSum_39 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> uniqueCombinations = combinationsSum(candidates, target);
        System.out.println(uniqueCombinations);
    }

    private static List<List<Integer>> combinationsSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        depthFirstSearch(candidates, 0, target, 0, result, current);
        return result;
    }

    private static void depthFirstSearch(int[] candidates, int idx, int target,
                                         int total, List<List<Integer>> result, List<Integer> current) {
        if(idx >= candidates.length || total > target){
            return;
        }
        if(total == target){
            result.add(List.copyOf(current));
            return;
        }

        current.add(candidates[idx]);
        depthFirstSearch(candidates, idx, target, total+candidates[idx], result, current);
        current.remove(current.size()-1);
        depthFirstSearch(candidates, idx+1, target, total, result, current);
    }

    private static List<List<Integer>> combinationsSum1(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> combination = new ArrayList<>();

        getAllCombinations(candidates, 0, target, combination, result);

        return new ArrayList<>(result);
    }

    private static void getAllCombinations(int[] candidates, int idx, int target, List<Integer> combination, Set<List<Integer>> result) {
        if( idx == candidates.length || target < 0){
            return;
        }
        if(target == 0){
            result.add(List.copyOf(combination));
            return;
        }

        combination.add(candidates[idx]);
        //Add Single time
        getAllCombinations(candidates, idx+1, target-candidates[idx], combination, result);

        //Add multiple time
        getAllCombinations(candidates, idx, target - candidates[idx], combination, result);

        //Do not add
        combination.remove(combination.size()-1);
        getAllCombinations(candidates, idx+1, target, combination, result);
    }
}
