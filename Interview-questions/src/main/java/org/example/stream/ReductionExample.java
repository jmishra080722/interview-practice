package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.IntBinaryOperator;

public class ReductionExample {

    public static void main(String[] args) {
        //Find sum of number of array
        int[] arr = {2, 3,4 ,5 };
        int sum = 0;
        for(int i: arr){
            sum +=i;
        }
        System.out.println("Sum is : "+sum);

        //Use Stream reduction function
        int newSum = Arrays.stream(arr).reduce(0,  ( left,  right) ->left + right);
        int mul = Arrays.stream(arr).reduce(1, (left, right) -> left * right);
        System.out.println("Sum is : "+newSum);
        System.out.println("Multiplication is : "+mul);

        //Find the number of characters in the sentence
        String sentence =  "This is stream reduction example learn well";
        List<String> words =Arrays.asList(sentence.split(" "));
        //reduce with two args
        Integer numOfChars = words.stream().map(str -> str.length()).reduce(0, (i, j) -> i + j);
        System.out.println("Number of characters in the sentence is: "+numOfChars);
        //reduce with one args
        Optional<Integer> optionalNumOfChars = words.stream().map(str -> str.length()).reduce((i, j) -> i + j);
        System.out.println("Number of characters in the sentence is: "+optionalNumOfChars.orElse(0));
    }
}
