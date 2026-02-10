package org.example.leetcode;

import java.util.Stack;

public class LongestValidParentheses_32 {
    public static void main(String[] args) {
        String s = "(()";
        int length = longestValidParenthesis2(s);
        System.out.println(length);
    }

    private static int longestValidParenthesis2(String s) {
        int max = 0;
        int open = 0;
        int close = 0;
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            }else {
                close++;
            }
            if(open == close){
                int len = open + close;
                max = Math.max(max, len);
            }else if(close > open){
                open = close =0;
            }
        }

        open = close =0;
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            }else {
                close++;
            }
            if(open == close){
                int len = open + close;
                max = Math.max(max, len);
            }else if(open > close){
                open = close =0;
            }
        }
        return max;
    }

    private static int longestValidParenthesis(String s) {
        int max = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for(int i=0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else {
                    int len = i - st.peek();
                    max = Math.max(len, max);
                }
            }
        }
    return max;
    }
}
