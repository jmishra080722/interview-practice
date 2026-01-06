package org.example.leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        int x = -121;
        System.out.println(isPalindrome(x));
    }

    private static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int original = x;
        int reverse = 0;
        while (x != 0){
            int unit = x%10;
            reverse = reverse*10 + unit;

            x = x/10;
        }
        return original == reverse;

    }
}
