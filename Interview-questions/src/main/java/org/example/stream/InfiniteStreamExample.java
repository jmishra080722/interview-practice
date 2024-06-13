package org.example.stream;

import java.util.UUID;
import java.util.stream.Stream;

public class InfiniteStreamExample {
    public static void main(String[] args) {
        //Generate fibonacci series of 10 num
        //General method
       /* int i1 = 0, i2=1;
        System.out.print(i1+", "+i2);
        for (int i = 2; i < 10; i++){
            int i3 = i1 + i2;
            i1 = i2;
            i2 = i3;
            System.out.print(" , "+i3);
        }*/

        //Using infinite stream: iterate generate ordered value
        int[] arr = {0, 1};
        Stream.iterate(arr, a -> {
           int next = arr[0] + arr[1];
           arr[0] = arr[1];
           arr[1] = next;
           return a;
        }).limit(10).map(a -> a[0]).forEach(System.out::println);

        //generate does not generate ordered values
        Stream.generate(UUID::randomUUID).limit(4).forEach(System.out::println);
    }
}
