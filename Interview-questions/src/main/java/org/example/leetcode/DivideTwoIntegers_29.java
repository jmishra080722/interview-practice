package org.example.leetcode;

public class DivideTwoIntegers_29 {
    public static void main(String[] args) {
        int dividend = -1;
        int divisor = 1;
        int quotient = divide(dividend, divisor);
        System.out.println(quotient);
    }

    private static int divide(int dividend, int divisor) {
        // Edge case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to positive long to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;
        while (a >= b) {
            int count = 0;
            while (a >= (b << (count + 1))) {
                count++;
            }
            result += (1 << count);
            a -= (b << count);
        }

        return negative ? -result : result;
    }
}
