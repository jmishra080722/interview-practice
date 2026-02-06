package org.example.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class FindTheIndexOfTheFirstOccurrenceInAString_28 {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issi";
        int firstIndex = strStr(haystack, needle);
        System.out.println(firstIndex);
        System.out.println("---------------");
        HashSet<Integer> set = new HashSet<>();
        int[] arr = {1, 2,2, 3, 4, 4};
        Arrays.stream(arr)
                .filter(n -> !set.add(n)).forEach(System.out::println);
        String str= "ashish";
        Map<Character, Long> result = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        result.entrySet().stream().filter(e -> e.getValue() > 1).forEach(System.out::println);
    }

    private static int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }

        for(int i = 0; i<= haystack.length()-needle.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                int j = 0;
                while (j < needle.length() && i + j < haystack.length()
                && haystack.charAt(i+j) == needle.charAt(j)){
                    j++;
                }
                if(j == needle.length()){
                    return i;
                }

            }
        }
        return -1;
    }
}
