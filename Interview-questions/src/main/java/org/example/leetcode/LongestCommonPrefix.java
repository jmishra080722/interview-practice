package org.example.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};

        String common = findCommonPrefix1(strs);
        System.out.println(common);
    }

    private static String findCommonPrefix1(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        int shortestLen = Math.min(first.length(), last.length());
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<shortestLen; i++){
            if(first.charAt(i) == last.charAt(i)){
                result.append(first.charAt(i));
            }else {
                return result.toString();
            }
        }
        return result.toString();
    }

    private static String findCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }

        int shortestLen = Integer.MAX_VALUE;
        //Find the smallest string in the list
        for(int i = 0; i< strs.length; i++){
            shortestLen = Math.min(shortestLen, strs[i].length());
        }
        String result = "";
        while (shortestLen > 0){
            result = strs[0].substring(0, shortestLen);
            for(int i = 1; i< strs.length; i++){
                if(!result.equals(strs[i].substring(0, shortestLen))){
                    result = "";
                    shortestLen--;
                    break;
                }
                if(i == strs.length-1){
                    return result;
                }
            }
        }
        return result;
    }
}
