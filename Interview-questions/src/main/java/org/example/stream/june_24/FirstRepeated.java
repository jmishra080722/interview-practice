package org.example.stream.june_24;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeated {
    public static void main(String[] args) {
        String input = "Java Articles are AwesomeJ";

        Character c1 = input.chars()
                .mapToObj(c -> Character.valueOf((char) c))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
        System.out.println(c1);
    }
}
