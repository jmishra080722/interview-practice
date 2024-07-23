package org.example.uber.section2;

import org.example.uber.inheritance.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
 */
public class FIndAllAnagrams {

    public static void main(String[] args) {
        String[] inputs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> groupedAnagrams = groupAnagrams(inputs);
        System.out.println(groupedAnagrams);
    }

    private static List<List<String>> groupAnagrams(String[] inputs) {
        if(inputs == null || inputs.length == 0){
            return  new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str: inputs){
            String frequencyString = getFrequencyString(str);
            if(!map.containsKey(frequencyString)){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(frequencyString, list);
            }else {
                map.get(frequencyString).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    private static String getFrequencyString(String str) {
        
        int[] freqArr = new int[26];
        
        for(char c1: str.toCharArray() ){
            freqArr[c1 - 'a']++;
        }
        
        StringBuilder freqStringBuilder = new StringBuilder("");
        
        char charSeq='a';
        for(int val: freqArr){
            freqStringBuilder.append(charSeq);
            freqStringBuilder.append(val);
            charSeq++;
        }
        return freqStringBuilder.toString();
    }
}
