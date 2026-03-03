package org.example.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams_49 {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List< List<String>> anagrams = groupAnagrams(strs);
        System.out.println(anagrams);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            String frequencyString  = getFrequencyString(s);
            if(!map.containsKey(frequencyString)){
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(frequencyString, list);
            }else {
                map.get(frequencyString).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }

    private static String getFrequencyString(String s) {

        int[] freqArr = new int[26];

        for(char c: s.toCharArray()){
            freqArr[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        char charSeq = 'a';
        for(int val: freqArr){
            if(val != 0){
                sb.append(charSeq);
                sb.append(val);
            }
            charSeq++;
        }
        return sb.toString();
    }


}
