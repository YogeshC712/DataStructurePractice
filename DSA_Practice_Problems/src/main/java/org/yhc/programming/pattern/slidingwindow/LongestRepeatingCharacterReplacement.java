package org.yhc.programming.pattern.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String str = "BBABCCDD";
        int k = 2;

        System.out.println("Longest Repeating Character Replacement for K["+ k + "] is: " + longestRepeatingCharacterReplacement(str, k));
    }

    private static int longestRepeatingCharacterReplacement(String s, int k){
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(ch));

            while ((end - start + 1) - maxFreq > k){
                char s_ch = s.charAt(start);
                freqMap.put(s_ch, freqMap.get(s_ch) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
