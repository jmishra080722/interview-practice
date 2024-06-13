package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 8, 12, 4};
        //Sum of even numbers
       int sum = Arrays.stream(nums)
                       .filter(n -> n%2 == 0)
                               .sum();
        System.out.println("Sum : "+sum);

        List<Integer> numList = Arrays.asList(6, 3, 5, 8, 12, 4);
        sum = numList.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n.intValue())
                .sum();
        System.out.println("Sum : "+sum);

        //print name not start with K in below list
        List<String> names = Arrays.asList("Jay", "Ashish", "Madhu", "Atharv", "Kapil");
        names.stream()
                .filter(name -> !name.startsWith("K"))
                .forEach(System.out::println);

        //Find name start with vowel
        List<String> fruits = Arrays.asList("apple", "mango", "orange");
        List<String> fruitsStartWithVowel = fruits.stream()
                .filter(name -> name.matches("^[aeiou].*"))
                .collect(Collectors.toList());
        System.out.println(fruitsStartWithVowel);
    }
}
