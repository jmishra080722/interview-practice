package org.example.leetcode;

import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String roman = "IV";
        int num = convertToInt(roman);
        System.out.println(num);
    }

    private static int convertToInt(String roman) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        int num = 0;
        for(int i = 0; i< roman.length()-1; i++ ){
            if(map.get(roman.charAt(i)) >= map.get(roman.charAt(i+1))){
                num +=map.get(roman.charAt(i));
            }else {
                num -= map.get(roman.charAt(i));
            }
        }
        num += map.get(roman.charAt(roman.length()-1));
        return num;
    }
}
