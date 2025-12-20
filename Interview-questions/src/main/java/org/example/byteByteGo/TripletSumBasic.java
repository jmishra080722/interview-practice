package org.example.byteByteGo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

//https://bytebytego.com/courses/coding-patterns/two-pointers/triplet-sum
public class TripletSumBasic {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(0, -1, 2, -3, 1));
        ArrayList<ArrayList<Integer>> triplets = findTriplet(nums);
        System.out.println(triplets);
    }

    private static ArrayList<ArrayList<Integer>> findTriplet(ArrayList<Integer> nums) {
        HashSet<ArrayList<Integer>> triplets = new HashSet<>();
        int n = nums.size();
        for(int i =0; i< n; i++){
            for(int j = i+1; j< n ; j++){
                for(int k = j+1; k < n; k++){
                    if(nums.get(i)+ nums.get(j)+nums.get(k) == 0) {
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(nums.get(i));
                        triplet.add(nums.get(j));
                        triplet.add(nums.get(k));
                        Collections.sort(triplet);
                        triplets.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(triplets);
    }
}
