package org.yhc.programming.pattern.prefixsum;

import java.util.Arrays;
import java.util.Set;

public class VowelsCountInSubstring {

    public static void main(String[] args) {
        String word = "prefixsum";
        int[][] queries = {{0, 2}, {1, 4}, {3, 5}};

        System.out.println("Number of Vowels in given ranges: " + Arrays.toString(vowelStrings(word, queries)));
    }

    private static int[] vowelStrings(String word, int[][] queries) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int[] prefix = new int[word.length() + 1];

        // Part 1: create the prefix sum array
        for(int i = 1; i <= word.length(); i++){
            boolean isVowel = vowels.contains(word.charAt(i - 1));
            prefix[i] = prefix[i - 1] + (isVowel ? 1 : 0);
        }

        // Part 2: calculate the number of vowels in each query
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = prefix[right + 1] - prefix[left];
        }
        return result;
    }
}
