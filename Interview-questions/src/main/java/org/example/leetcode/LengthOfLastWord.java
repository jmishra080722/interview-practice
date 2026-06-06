package org.example.leetcode;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        int length = lengthOfLastWord(s);
        System.out.println(length);
    }
    public static int lengthOfLastWord(String s){
        if(s.isEmpty()){
            return 0;
        }
        s = s.trim();
        String[] strs = s.split(" ");
        return strs[strs.length-1].length();
    }
}
