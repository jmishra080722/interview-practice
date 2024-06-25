package org.example.stream.june_24;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateElements {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> set  = new HashSet<>();
        myList.stream()
                .forEach(n-> {
                    if(!set.contains(n)){
                        set.add(n);
                    }else{
                        System.out.println(n+ " is the duplicate element ");
                    }

                });

    }
}
