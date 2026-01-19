package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> parentheses = generateParentheses(n);
        System.out.println(parentheses);
    }

    private static List<String> generateParentheses(int n) {
        List<String > result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(n == 0){
            result.add("");
            return result;
        }

        int openCount = 0;
        int closeCount = 0;
        backtracking(sb, n, openCount, closeCount, result);
        return result;
    }

    private static void backtracking(StringBuilder sb, int n, int openCount, int closeCount, List<String> result) {
        if(openCount == n && closeCount == n){
            result.add(sb.toString());
            return;
        }
        if(openCount < n){
            sb.append("(");
            backtracking(sb, n, openCount+1, closeCount, result);
            sb.deleteCharAt(sb.length()-1);
        }

        if(closeCount < openCount){
            sb.append(")");
            backtracking(sb, n, openCount, closeCount+1, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
