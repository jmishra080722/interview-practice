package org.example.leetcode150;


//Q: 274. H-Index
//URL: https://leetcode.com/problems/h-index/submissions/1491570121/?envType=study-plan-v2&envId=top-interview-150
public class HIndex_274 {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        int citation = hIndex(citations);
        System.out.println(citation);
    }

    private static int hIndex(int[] citations) {
        int n = citations.length;
        int[] arr = new int[n+1];

        //Count the number of occurrence of each element of array.
        // If element value is larger than length of arr, than increase the count of "number of array size".
        //Because any value which is larger than array size can not be the value of HIndex.
        for(int a: citations){
            if(a >= n){
                arr[n]++;
            }else {
                arr[a]++;
            }
        }

        //Now find the hindex, by checking the highest element for which, minimum that many number is greater or equals
        int count = 0;
        for(int i = n; i>=0; i--){
            count += arr[i];
            if(count >=i){
                return i;
            }
        }
        return 0;
    }
}
