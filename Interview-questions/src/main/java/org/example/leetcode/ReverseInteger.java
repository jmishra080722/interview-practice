package org.example.leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        int input = -987;
        int output = revers1(input);
        System.out.println(output);
    }

    private static int revers1(int x) {
        int result = 0;
        try{
            while (x != 0) {
                int unit = x%10;
                if (result > Integer.MAX_VALUE / 10 ||
                        (result == Integer.MAX_VALUE / 10 && unit > 7)) {
                    return 0;
                }
                if (result < Integer.MIN_VALUE / 10 ||
                        (result == Integer.MIN_VALUE / 10 && unit < -8)) {
                    return 0;
                }
                result = result*10 + unit;
                x = x/10;
            }
            return result;
        }catch (Exception e){
            return result;
        }
    }

    private static int revers(int input) {
        String s = String.valueOf(input);
        if(input < 0){
            s= s.substring(1);
        }
        char[] chars = s.toCharArray();
        int start = 0; int end = s.length()-1;
        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        String out = String.valueOf(chars);
        if(input < 0){
            out = "-"+out;
        }
        try {
             return Integer.parseInt(out);
        }catch (Exception e){
            return 0;
        }
    }
}
