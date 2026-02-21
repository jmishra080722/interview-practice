package org.example.leetcode;

import javax.crypto.spec.PSource;
import java.util.*;

public class CombinationSumII_40 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> combinationSum = combinationSum2(candidates, target);
        System.out.println(combinationSum);
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> current = new ArrayList<>();
        dfs(candidates, target, 0, 0, current, result);

        /*Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs1(candidates, target, 0, current, result);*/
        return new ArrayList<>(result);
    }

    private static void dfs(int[] candidates, int target, int idx, int total, List<Integer> current, Set<List<Integer>> result) {
        if(target == total){
            result.add(List.copyOf(current));
            return;
        }

        if(idx >= candidates.length || total > target){
            return;
        }

        current.add(candidates[idx]);
        dfs(candidates, target, idx+1, total+candidates[idx], current, result);
        current.remove(current.size()-1);
        dfs(candidates, target, idx+1, total, current, result);
    }

    private static void dfs1(int[] arr, int target, int start,
                            List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < arr.length; i++) {

            // Skip duplicates
            if (i > start && arr[i] == arr[i - 1]) continue;

            if (arr[i] > target) break;

            current.add(arr[i]);
            dfs1(arr, target - arr[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }



}
