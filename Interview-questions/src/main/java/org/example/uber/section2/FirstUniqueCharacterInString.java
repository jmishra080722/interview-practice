package org.example.uber.section2;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
//Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
public class FirstUniqueCharacterInString {

    public static void main(String[] args) {
        String input = "loveleetcode";

        int index = indexOfFirstNonRepetingChar(input);
        System.out.println(index);

    }

    private static int indexOfFirstNonRepetingChar(String input) {
        Character c1 = input.chars()
                .mapToObj(c -> Character.toLowerCase(Character.valueOf((char)c)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entity -> entity.getValue() == 1)
                .map(entity -> entity.getKey())
                .findFirst()
                .orElse(null);

        System.out.println(c1);
        if(c1 != null){
            return input.indexOf(c1);
        }else {
            return -1;
        }

    }
}
