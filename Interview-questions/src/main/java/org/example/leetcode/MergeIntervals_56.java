package org.example.leetcode;

import org.example.leetcode150.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_56 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] combinedInterval = merge(intervals);
        for(int[] interval: combinedInterval){
            Util.print(interval);
            System.out.println();
        }
    }

    private static int[][] merge(int[][] intervals) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i< intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);
            }else {
                res.add(Arrays.asList(start, end));
                start = intervals[i][0];
                end= intervals[i][1];
            }
        }
        res.add(List.of(start, end));

        int[][] ans = new int[res.size()][res.get(0).size()];
        for(int i = 0; i< res.size(); i++){
            for(int j = 0; j< res.get(0).size() ; j++){
                ans[i][j] = res.get(i).get(j);
            }
        }
        return ans;
    }
}
