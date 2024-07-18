package org.example.uber.section2;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstUniqueCharacterInString {

    public static void main(String[] args) {
        String input = "loveleetcode";

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
            System.out.println("Index is: "+ input.indexOf(c1));
        }else {
            System.out.println("-1");
        }


    }
}
