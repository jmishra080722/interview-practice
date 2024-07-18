package org.example.uber.section1;

import java.util.HashSet;
import java.util.Set;

//4. Find out all palindromic substrings  from a given string.
// eg: aabbaacabcadadad
public class FindAllPalindromicSubString {
    public static void main(String[] args) {
        String str = "aabbaacabcadadad";
        Set<String> palindromes = findAllPalindrome(str);
        System.out.println(palindromes);
    }

    private static Set<String> findAllPalindrome(String str) {
        Set<String> palindromes = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            for (int j = i; j < str.length(); j++){
                String subStr = str.substring(i, j+1);
                if(isPalindrome(subStr)){
                    palindromes.add(subStr);
                }
            }
        }
        return palindromes;
    }

    private static boolean isPalindrome(String subStr) {
        int left = 0;
        int right = subStr.length() -1;
        while (left < right){
            if(subStr.charAt(left) != subStr.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
