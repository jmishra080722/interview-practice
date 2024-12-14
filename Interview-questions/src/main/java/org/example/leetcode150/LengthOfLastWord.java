package org.example.leetcode150;


//Q. 58. Length of Last Word
//URL: https://leetcode.com/problems/length-of-last-word/?envType=study-plan-v2&envId=top-interview-150
public class LengthOfLastWord {
    public static void main(String[] args) {

        String s ="a";
        int len = lengthOfLastWord(s);
        System.out.println(len);

    }

    private static int lengthOfLastWord(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i>=0 ; i--){
            String s1 = String.valueOf(s.charAt(i));
            if(s1.equals(" ")){
                return sb.length();
            }
            sb.append(s1);
        }
        return sb.length();
    }
}
