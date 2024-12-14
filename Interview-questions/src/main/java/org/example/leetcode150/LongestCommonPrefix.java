package org.example.leetcode150;


//Q: 14. Longest Common Prefix
//URL: https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String commonPrefix = commonPrefix(strs);
        System.out.println(commonPrefix);
    }

    private static String commonPrefix(String[] strs) {
        String result = "";
        int shortestLen = Integer.MAX_VALUE;
        if(strs.length == 1){
            return strs[0];
        }

        for(int i = 0; i< strs.length; i++){
            shortestLen = Math.min(shortestLen, strs[i].length());
        }

        while(shortestLen>0){
            result = strs[0].substring(0, shortestLen);
            for(int i=1; i<strs.length; i++){
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
