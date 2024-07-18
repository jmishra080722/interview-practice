package org.example.stream.june_25;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class SecondLargestInArray {

    public static void main(String[] args) {
        int[] arr = {1,2,5,6,3,2};

        int largest = 0;
        int secondLargest = 0;
        for(int n: arr){
            if(largest < n && secondLargest < n){
                secondLargest = largest;
                largest = n;
            }else if(largest > n && secondLargest < n){
                secondLargest = n;
            }
        }
        System.out.println( "largest "+largest +" , secondLargest: "+secondLargest);

        /*OptionalInt first = Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> b -a)
                .skip(1)
                .mapToInt(Integer::intValue)
                .findFirst();
        System.out.println(first.getAsInt());*/
    }
}
