package org.example.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class SubstringWithConcatenationOfAllWords_30 {
    public static void main(String[] args) {
        String s = "a";
        String[] words = {"a","a"};
        List<Integer> indexes = findSubstring2(s, words);
        System.out.println(indexes);
    }

    private static List<Integer> findSubstring(String s, String[] words)  {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        Map<String, Integer> currentMap = new HashMap<>();

        int sLen = s.length();
        int n = words.length;
        int wordSize = words[0].length();
        int windowSize = n * wordSize;

        List<Integer> result = new ArrayList<>();

        for (int startPos = 0; startPos < wordSize; startPos++) {
            int start = startPos;

            while (start + windowSize <= sLen) {
                currentMap.clear();
                currentMap.putAll(frequencyMap);

                boolean match = true;

                for (int i = 0; i < n; i++) {
                    int idx = start + i * wordSize;

                    if (idx + wordSize > sLen) {
                        match = false;
                        break;
                    }

                    String currentWord = s.substring(idx, idx + wordSize);

                    if (!currentMap.containsKey(currentWord) || currentMap.get(currentWord) == 0) {
                        match = false;
                        break;
                    }

                    currentMap.put(currentWord, currentMap.get(currentWord) - 1);
                }

                if (match) {
                    result.add(start);
                }

                start += wordSize;
            }
        }
        return result;
    }

    private static List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int windowLen = wordLen * wordCount;

        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // We need wordLen different starting points
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (freqMap.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    // Shrink window if word count exceeds
                    while (windowMap.get(word) > freqMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // Match found
                    if (count == wordCount) {
                        result.add(left);

                        // Move window forward
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    // Reset window
                    windowMap.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        return result;
    }


}
