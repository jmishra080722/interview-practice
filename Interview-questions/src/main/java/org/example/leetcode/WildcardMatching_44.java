package org.example.leetcode;

public class WildcardMatching_44 {
    public static void main(String[] args) {
        String s = "aa";
        String p = "*";
        boolean matched = isMatch(s, p);
        System.out.println(matched);
    }

    private static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int[][] cacheMemo = new int[sLen][pLen];
        for(int sIndex = 0; sIndex < sLen; sIndex++){
            for(int pIndex = 0; pIndex < pLen; pIndex++){
                cacheMemo[sIndex][pIndex] = -1;
            }
        }

        int output = dp(s, p, sLen-1, pLen-1, cacheMemo);
        return output > 0 ? true : false;
    }

    private static int dp(String s, String p, int sIndex, int pIndex,  int[][] cacheMemo) {
       //When everything match
       if(sIndex < 0  && pIndex < 0){
            return 1;
        }

       //When pattern is finished but string is not
        if(sIndex >= 0 && pIndex < 0){
            return 0;
        }

        //When string is finished but pattern is not
        if(sIndex < 0 && pIndex >=0){
            //Check if all remaining char of pattern is '*' or not
            for(int index = pIndex; index >=0; index--){
                if(p.charAt(index) != '*'){
                    return 0;
                }
            }
            return 1;
        }

        //Check if upto this point its match or not.
        if(cacheMemo[sIndex][pIndex] != -1){
            return cacheMemo[sIndex][pIndex];
        }

        //When there is char match or '?' present in pattern
        if((s.charAt(sIndex) == p.charAt(pIndex)) || (p.charAt(pIndex) == '?')){
            cacheMemo[sIndex][pIndex] = dp(s, p, sIndex - 1, pIndex - 1, cacheMemo);
            return cacheMemo[sIndex][pIndex];
        }

        //When there is a '*'present in the pattern
        if(p.charAt(pIndex) == '*'){
            if((dp(s, p, sIndex - 1, pIndex, cacheMemo) == 1) ||
                    (dp(s, p, sIndex, pIndex - 1, cacheMemo) == 1)){
                cacheMemo[sIndex][pIndex] = 1;
            }else {
                cacheMemo[sIndex][pIndex] = 0;
            }
            return cacheMemo[sIndex][pIndex];
        }

        return 0;
    }
}
