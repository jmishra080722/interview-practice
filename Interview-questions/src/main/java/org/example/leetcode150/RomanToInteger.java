package org.example.leetcode150;

import java.util.Map;
//  13. Roman to Integer
//  URL: https://leetcode.com/problems/roman-to-integer/?envType=study-plan-v2&envId=top-interview-150
public class RomanToInteger {
    public static void main(String[] args) {
        String roman = "LVIII";
        int num = romanToInt(roman);
        System.out.println(num);
    }

    private static int romanToInt(String roman) {
        int num = 0;
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        for(int i = 0; i< roman.length()-1 ; i++){
            if(map.get(roman.charAt(i)) >= map.get(roman.charAt(i+1))){
                num  += map.get(roman.charAt(i));
            }
            else{
                num  -= map.get(roman.charAt(i));
            }
        }
        num += map.get(roman.charAt(roman.length()-1));

        return num;
    }
}
