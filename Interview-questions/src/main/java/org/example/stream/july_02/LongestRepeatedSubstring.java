package org.example.stream.july_02;

import java.util.Arrays;

public class LongestRepeatedSubstring {


    public static void main(String[] args) {
        String text = "banana";
        String result = longestRepeatedSubstring(text);
        System.out.println("Longest repeated substring: " + result);
    }


    // Function to find the longest repeated substring
    public static String longestRepeatedSubstring(String text) {
        int n = text.length();
        int[] suffixArray = buildSuffixArray(text);
        int[] lcpArray = buildLCPArray(text, suffixArray);

        int maxLength = 0;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (lcpArray[i] > maxLength) {
                maxLength = lcpArray[i];
                index = suffixArray[i];
            }
        }

        return text.substring(index, index + maxLength);
    }

    // Function to build the suffix array
    private static int[] buildSuffixArray(String text) {
        int n = text.length();
        Suffix[] suffixes = new Suffix[n];

        for (int i = 0; i < n; i++) {
            suffixes[i] = new Suffix(i, text.substring(i));
        }

        Arrays.sort(suffixes, (a, b) -> a.suffix.compareTo(b.suffix));

        int[] suffixArray = new int[n];
        for (int i = 0; i < n; i++) {
            suffixArray[i] = suffixes[i].index;
        }

        return suffixArray;
    }


    // Function to build the LCP array
    private static int[] buildLCPArray(String text, int[] suffixArray) {
        int n = text.length();
        int[] lcp = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            rank[suffixArray[i]] = i;
        }

        int h = 0;
        for (int i = 0; i < n; i++) {
            if (rank[i] > 0) {
                int j = suffixArray[rank[i] - 1];
                while (i + h < n && j + h < n && text.charAt(i + h) == text.charAt(j + h)) {
                    h++;
                }
                lcp[rank[i]] = h;
                if (h > 0) {
                    h--;
                }
            }
        }

        return lcp;
    }








    // Helper class to store suffixes and their indices
    private static class Suffix {
        int index;
        String suffix;

        Suffix(int index, String suffix) {
            this.index = index;
            this.suffix = suffix;
        }
    }

}
