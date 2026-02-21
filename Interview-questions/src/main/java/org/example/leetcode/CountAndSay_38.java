package org.example.leetcode;

public class CountAndSay_38 {
    public static void main(String[] args) {
        int n = 4;
        String output = countAndSay(n);
        System.out.println(output);
    }

    private static String countAndSay(int n) {
        String result = "";
        int c = 1;
        while (c <= n){
            result = count(c, result);
            c++;
        }
        return result;
    }

    private static String count(int n, String result) {
        if(result.isEmpty()){
            return "1";
        }
        int numOfTimes = 1;
        char[] chars = result.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i< chars.length; i++){
            if(chars[i-1] == chars[i]){
                numOfTimes++;
            }else {
                sb.append(numOfTimes).append(chars[i-1]);
                numOfTimes = 1;
            }
        }
        sb.append(numOfTimes).append(chars[chars.length-1]);

        return sb.toString();
    }
}
