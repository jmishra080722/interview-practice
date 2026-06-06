package org.example.leetcode;

import org.example.leetcode150.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval_57 {
    public static void main(String[] args) {

        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};//{{1,3},{6,9}};
        //int[][] intervals = {{1,3}, {2, 6}, {8, 10}, {15, 18}};
        int[] newInterval = {4,8};//{2,5};
        int[][] combinedInterval = insertInterval(intervals, newInterval);
        for(int[] interval: combinedInterval){
            Util.print(interval);
            System.out.println();
        }
    }

    private static int[][] insertInterval(int[][] intervals, int[] newInterval) {

       if(intervals == null || intervals.length == 0){
            return new int[][]{newInterval};
        }

        List<int[]> temp1 = new ArrayList<>();
        boolean added = false;

        for(int[] interval: intervals){
            if(!added && newInterval[0] < interval[0]){
                temp1.add(newInterval);
                added = true;
            }
            temp1.add(interval);
        }

        //If newInterval is larger than all interval, than add it at last.
        if(!added){
            temp1.add(newInterval);
        }

        //Merge overlapping intervals
        List<int[]> merge = new ArrayList<>();
        int start = temp1.get(0)[0];
        int end = temp1.get(0)[1];

        for(int i = 1; i<temp1.size(); i++){
            int[] current = temp1.get(i);
            if(current[0] <= end){
                end = Math.max(end, current[1]);
            }else{
                merge.add(new int[]{start, end});
                start = current[0];
                end = current[1];
            }
        }
        merge.add(new int[]{start, end});

        return merge.toArray(new int[merge.size()][]);
    }

    private static int[][] insertInterval1(int[][] intervals, int[] newInterval) {
        int[][] temp = new int[intervals.length + 1][intervals[0].length];
        boolean added = false;
        for(int i = 0; i< temp.length; i++){
            if(!added && i < intervals.length && intervals[i][0] > newInterval[0]){
                temp[i][0] = newInterval[0];
                temp[i][1] = newInterval[1];
                added = true;
            }else {
                if(!added){
                    temp[i][0] = intervals[i][0];
                    temp[i][1] = intervals[i][1];
                }else {
                    temp[i][0] = intervals[i-1][0];
                    temp[i][1] = intervals[i-1][1];
                }

            }
        }


        List<List<Integer>> list = new ArrayList<>();
        int start = temp[0][0];
        int end = temp[0][1];
        for(int i = 1; i<temp.length; i++){
            if(temp[i][0] <= end){
                end = Math.max(end, temp[i][1]);
            }else {
                list.add(Arrays.asList(start, end));
                start = temp[i][0];
                end = temp[i][1];
            }
        }
        list.add(Arrays.asList(start, end));

        int[][] res = new int[list.size()][list.get(0).size()];
        for(int i=0; i< list.size(); i++){
            for(int j = 0; j< list.get(0).size(); j++){
                res[i][j] = list.get(i).get(j);
            }
        }
        return res;
    }

}
