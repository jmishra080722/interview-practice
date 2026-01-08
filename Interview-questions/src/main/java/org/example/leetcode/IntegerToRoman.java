package org.example.leetcode;

public class IntegerToRoman {
    public static void main(String[] args) {
        int num = 3749;
        String romanValue = intToRoman1(num);
        System.out.println(romanValue);

    }

    private static String intToRoman1(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int i = 0;
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
       while (num > 0){
           if(num >= nums[i]){
               int count = num/nums[i];
               String temp = rom[i].repeat(count);
               sb.append(temp);
               num = num%nums[i];
           }
           i++;
       }
        return sb.toString();
    }

    private static String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int i = 0;
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        while (num > 0 && i < n){
            if(num >= nums[i]){
                num = num- nums[i];
                sb.append(rom[i]);
            }else {
                i++;
            }
        }
        return sb.toString();
    }
}
