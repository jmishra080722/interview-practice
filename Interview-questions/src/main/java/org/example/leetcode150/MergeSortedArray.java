package org.example.leetcode150;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        Util. print(nums1);
       // merge(nums1 , m, nums2, n);
        merge2(nums1 , m, nums2, n);
        Util.print(nums1);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0; i<n; i++){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    private static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1;
        int i = m-1;
        int j = n-1;
        while(j >=0){
            if(i>=0 && nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                k--;
                i--;
            }else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }


}
