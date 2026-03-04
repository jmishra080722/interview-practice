package org.example.leetcode;

public class PowX_to_N_50 {
    public static void main(String[] args) {
        double x = 7;
        int n = 11;

        double result = myPow1(x, n);
        System.out.println(result);
    }

    private static double myPow1(double x, int n) {
        if(n < 0){
            n = -n;
            x = 1/x;
        }

        double power = 1.0;
        while (n !=0 ){
            if((n & 1) != 0){
                power = power * x;
            }
            x = x* x;
            n >>>=1;
        }
        return power;
    }

    private static double myPow(double x, int n) {
        double result = helper(x, Math.abs(n));
        return n>0 ? result : 1 / result;
    }

    private static double helper(double x, int n) {
        if(x == 0){
            return 0.0;
        }
        if(n == 0){
            return 1.0;
        }

        double result = helper(x, n/2);
        result = result * result;
        return n %2 == 0 ? result : x * result;
    }
}
