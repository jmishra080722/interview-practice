package org.example.byteByteGo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TripletSumAdvance {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(0, -1, 2, -3, 1));

        ArrayList<ArrayList<Integer>> triplets =
                findTriplets(nums);
        System.out.println(triplets);
    }

    private static ArrayList<ArrayList<Integer>> findTriplets(ArrayList<Integer> nums) {
        int n = nums.size();
        ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();

        //Sort the input
        Collections.sort(nums);
        for(int i = 0; i < n; i++){
            //Optimization: triplets consisting of only positive numbers will never sum
            if(nums.get(i) > 0){
                break;
            }

            // To avoid duplicate triplets, skip 'a' if it's the same as the previous
            // number.
            if(i > 0 && nums.get(i).equals(nums.get(i - 1)) ){
                continue;
            }

            //Find all pairs that sum to a target of -a i.e -nums.get(i)
            ArrayList<ArrayList<Integer>> pairs =
                    findAllPairs(nums, i+1, -nums.get(i));
            for(ArrayList<Integer> pair : pairs){
                ArrayList<Integer> triplet = new ArrayList<>();
                triplet.add(nums.get(i));
                triplet.addAll(pair);
                triplets.add(triplet);
            }


        }

        return triplets;
    }

    private static ArrayList<ArrayList<Integer>> findAllPairs(ArrayList<Integer> nums, int start, int target) {
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        int left = start;
        int right = nums.size()-1;
        while (left < right){
            int sum = nums.get(left) + nums.get(right);
            if(sum == target){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(nums.get(left));
                pair.add(nums.get(right));
                pairs.add(pair);
                left = left+1;

                while (left < right && nums.get(left).equals(nums.get(left - 1))){
                    left = left+1;
                }
            } else if (sum < target) {
                left = left+1;
            }else {
                right = right -1;
            }
        }


        return pairs;
    }
}
