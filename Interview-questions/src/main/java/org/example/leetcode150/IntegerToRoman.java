package org.example.leetcode150;


// 12. Integer to Roman
//URL: https://leetcode.com/problems/integer-to-roman/description/?envType=study-plan-v2&envId=top-interview-150
public class IntegerToRoman {
    public static void main(String[] args) {
        int num = 58;
        String roman = intToRoman(num);
        System.out.println(roman);
    }

    private static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"  };
        int i = 0;
        int n = nums.length;

        while (i < n && num >0){
            if(num >= nums[i]){
                num = num - nums[i];
                result.append(rom[i]);
            }else{
                i++;
            }
        }
        return result.toString();
    }

}
