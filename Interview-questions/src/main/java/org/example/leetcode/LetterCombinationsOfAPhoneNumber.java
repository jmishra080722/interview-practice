package org.example.leetcode;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digit = "23";
        List<String> letters = letterCombinations(digit);
        System.out.println(letters);
    }

    private static List<String> letterCombinations(String  digits) {
        Map<Character, String> map = Map.of(
                '2', "abc",
                '3', "def",
                '4',"ghi",
                '5', "jkl",
                '6',"mno",
                '7',"pqrs",
                '8', "tuv",
                '9', "wxyz"
        );
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()){
            return result;
        }

        backtrack(0, "", digits, result, map);

        return result;
    }

    private static void backtrack(int position, String currStr, String digits, List<String> result, Map<Character, String> map) {
        if(currStr.length() == digits.length()){
            result.add(currStr);
            return;
        }
        String str = map.getOrDefault(digits.charAt(position), "");
        for(int i=0; i< str.length(); i++){
            backtrack(position+1, currStr+str.charAt(i), digits, result, map);
        }
    }
}
