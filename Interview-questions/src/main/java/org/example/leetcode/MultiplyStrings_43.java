package org.example.leetcode;

import java.util.stream.IntStream;

public class MultiplyStrings_43 {
    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "99";
        String mul = multiply(num1, num2);
        System.out.println(mul);
    }

    private static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int[] reversedResult = new int[l1+l2];

        StringBuilder sb1 = new StringBuilder(num1).reverse();
        StringBuilder sb2 = new StringBuilder(num2).reverse();

        for(int i = 0; i < l1 ; i++){
            for(int j = 0;  j < l2; j++){
                int n1 = Integer.parseInt(String.valueOf(sb1.charAt(i)));
                int n2 = Integer.parseInt(String.valueOf(sb2.charAt(j)));
                int digit = n1 * n2;
                reversedResult[i + j] += digit;
                reversedResult[i + j  + 1] += reversedResult[i + j] / 10;
                reversedResult[i + j] = reversedResult[i+j] %10;
            }
        }
        int[] res = IntStream.range(0, reversedResult.length)
                .map(i -> reversedResult[reversedResult.length - 1 - i])
                .toArray();
        int begin = 0;
        for(int i=0; i< res.length; i++){
            if(res[i] != 0){
                begin = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = begin; i< res.length; i++){
            sb.append(res[i]);
        }

        return sb.toString();
    }
}
