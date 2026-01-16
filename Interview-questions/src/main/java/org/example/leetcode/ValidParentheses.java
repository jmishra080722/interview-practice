package org.example.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "[[[]";
        boolean isValidParenthesis = isValid(s);
        System.out.println(isValidParenthesis);
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()%2 !=0){
            return false;
        }
        if(s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']'){
            return false;
        }
        if(s.charAt(s.length()-1) == '(' || s.charAt(s.length()-1) == '{' || s.charAt(s.length()-1) == '['){
            return false;
        }
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c =='[') {
                stack.push(']');
            }else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
