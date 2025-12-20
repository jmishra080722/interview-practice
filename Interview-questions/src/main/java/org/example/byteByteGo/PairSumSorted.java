package org.example.byteByteGo;

import java.util.ArrayList;
import java.util.Arrays;

//git command to see the repository name
public class PairSumSorted {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(-5, -2, 3, 4, 6));
        int sum = 7;
        ArrayList<Integer> resultIndex = findIndexes(nums, sum);
        System.out.println(resultIndex);
    }

    private static ArrayList<Integer> findIndexes(ArrayList<Integer> nums, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int right = nums.size()-1;
        int val = 0;
        while (left < right){
            val = nums.get(left) + nums.get(right);
            if(val == sum){
                result.add(left);
                result.add(right);
                break;
            } else if(val < sum){
                left++;
            }else {
                right--;
            }
        }
        return result;
    }
}
