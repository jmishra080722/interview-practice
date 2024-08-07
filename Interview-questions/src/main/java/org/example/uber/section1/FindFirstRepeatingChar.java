package org.example.uber.section1;


import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

//1. Find the first repeating char in a given string without using collection or string method.
// Example "Hello world", l is the answer
public class FindFirstRepeatingChar {

    public static void main(String[] args) {
        String str = "Hello world";
        String result = findFirstReapitingCharInString2(str);
        if(!result.isEmpty()){
            System.out.println("First repeating char in \""+str+"\" is "+result);
        }else {
            System.out.println("There is no repeating char is the given string: "+str);
        }
    }

    private static String findFirstReapitingCharInString2(String str) {
        Character c1 = str.chars()
                .mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entity -> entity.getValue() >1)
                .map(entity -> entity.getKey())
                .findFirst()
                .orElse(null);
        return c1.toString();
    }

    private static String findFirstReapitingCharInString(String str) {

        int len = str.length();
        str = str.toLowerCase();
        for (int i = 0; i< len; i++){
            char c = str.charAt(i);
            for(int j=i+1; j<len; j++){
                if(c == str.charAt(j)){
                    return String.valueOf(c);
                }
            }
        }
        return "";
    }
}
