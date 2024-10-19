package org.example.leetcode150;

//Question: 238. Product of Array Except Self:
//Link:  https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150
public class ProductOfArrayExceptItself {

    public static void main(String[] args) {
        int[] input = {2,3,4,5};
        int[] result = productOfOtherElements(input);
        for(int p: result){
            System.out.print(p+", ");
        }
    }

    private static int[] productOfOtherElements(int[] input) {
        int len = input.length;
        int[] productOfAllLeftElements = new int[len];
        productOfAllLeftElements[0] = 1;
        for(int i= 1 ; i< len; i++){
            productOfAllLeftElements[i] = productOfAllLeftElements[i-1] * input[i - 1];
        }

        int[] productOfALlRightElements = new int[len];
        productOfALlRightElements[len -1] = 1;
        for(int i = len-2; i>=0; i--){
            productOfALlRightElements[i] = productOfALlRightElements[i + 1] * input[i + 1];
        }

        int[] result = new int[len];
        for(int i = 0; i< len; i++){
            result[i] = productOfAllLeftElements[i]  *  productOfALlRightElements[i];
        }
        return result;
    }
}
