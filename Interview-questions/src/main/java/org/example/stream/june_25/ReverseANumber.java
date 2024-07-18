package org.example.stream.june_25;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseANumber {
    public static void main(String[] args) {
        int num = 12345;
        int rev = reverse1(num);
        System.out.println(rev);

        rev = reverse2(num);
        System.out.println(rev);
    }

    private static int reverse2(int num){

        String numStr = String.valueOf(num);
        String collect = numStr.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        (n) -> {
                            Collections.reverse(n);
                            return n.stream();
                        }
                ))
                .map(str -> String.valueOf(str))
                .collect(Collectors.joining());

        return Integer.valueOf(collect);
    }

    private static int reverse1(int num){
        int rev = 0;
        int rem = 0;

        while(num != 0){
            rem = num%10;
            rev = rev * 10 + rem;
            num = num/10;
        }
        return rev;
    }
}
