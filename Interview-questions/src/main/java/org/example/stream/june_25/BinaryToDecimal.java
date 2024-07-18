package org.example.stream.june_25;

public class BinaryToDecimal {
    public static void main(String[] args) {
        int binary = 101011;  // 43
        int decimal = 0;
        int rem = 0;
        int i =0 ;
        while(binary != 0){
            rem = binary %10;
            binary = binary/10;
            decimal = (int) (decimal + rem * Math.pow(2,  i));
            i++;
        }
        System.out.println(decimal);
    }
}
