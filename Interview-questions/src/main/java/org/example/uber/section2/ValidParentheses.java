package org.example.uber.section2;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String input = "((())){}[{{()}}]";
        boolean valid = validateParenthesis(input);
        System.out.println(valid);
    }

    private static boolean validateParenthesis(String input) {
        Stack<Character> stack = new Stack<>();
        boolean result = true;
        for(char c : input.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if(stack.isEmpty() || c!= stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

    /*private static boolean validateParenthesis(String input) {
        Stack<Character> parenthesisStack = new Stack<>();
        boolean valid = true;
        for(char c: input.toCharArray()){
            if(parenthesisStack.isEmpty()){
                parenthesisStack.push(c);
            }else{
                if(c == ')' ||  c == '}'  ||  c == ']'){
                    Character c1 = parenthesisStack.pop();
                    if(c == ')' && c1 != '('){
                        valid = false;
                    }if(c == '}' && c1 != '{'){
                        valid = false;
                    }if(c == ']' && c1 != '['){
                        valid = false;
                    }
                }else {
                    parenthesisStack.push(c);
                }
            }
        }
        if(!parenthesisStack.isEmpty()){
            valid = false;
        }
        return valid;
    }*/
}
