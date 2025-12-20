package org.example.byteByteGo;

public class Palindrome {
    public static void main(String[] args) {
        String s = "Ashish";//"a dog! a panic in a pagoda.";
        boolean isPalindrome = isPalindrome(s);
        System.out.println(isPalindrome);
    }

    private static boolean isPalindrome(String input) {
        int left = 0;;
        int right = input.length()-1;
        while(left < right){

            // Skip non-alphanumeric characters from the left.
            while (left < right && !Character.isLetterOrDigit(input.charAt(left))){
                left++;
            }
            //// Skip non-alphanumeric characters from the right.
            while (left < right && !Character.isLetterOrDigit(input.charAt(right))){
                right--;
            }

            if(Character.toLowerCase(input.charAt(left))  !=
                    Character.toLowerCase(input.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
