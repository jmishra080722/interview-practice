package org.example.uber.section2;


import java.util.*;


/*
You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
Define a pair (u, v) which consists of one element from the first array and one element from the second array.
Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 */
public class FindKPairsWithSmallestSums {

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,9};
        int k = 3;

        List<List<Integer>> list = kSmallestPairs(nums1, nums2, k);
        for (List<Integer> pair : list) {
            System.out.println(pair);
        }
    }

    private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
       if (nums1.length == 0 || nums2.length == 0 || k == 0){
           return result;
       }
       //Priority queue will hold arrays of sum and index of the array elements
       PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

       //Put sum of 0th element of nums1 and all elements of nums2 and there indexes in PQ
       for(int j = 0; j< Math.min(k, nums2.length); j++){
           minHeap.offer(new int[]{nums1[0] + nums2[j], 0, j});
       }
       //Read from PQ
       while (k > 0 && !minHeap.isEmpty()){
           int[] current = minHeap.poll();
           int i = current[1];
           int j = current[2];
           result.add(Arrays.asList(nums1[i], nums2[j]));
           k--;
           if( i + 1 < nums1.length){
               minHeap.offer(new int[]{nums1[i+1] + nums2[j], i + 1, j});
           }
       }
       return result;
    }
}
