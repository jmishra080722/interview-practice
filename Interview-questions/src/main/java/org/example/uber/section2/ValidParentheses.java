package org.example.uber.section2;

import java.util.Stack;

/*
* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
*/

public class ValidParentheses {

    public static void main(String[] args) {
        String input = "((())){}[{{()}}]";
        boolean valid = validateParenthesis(input);
        System.out.println(valid);
    }

    private static boolean validateParenthesis(String input) {
        Stack<Character> stack = new Stack<>();
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
