package org.yhc.programming.pattern.characterfrequncy;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String input = "leetcodel";

        int index = firstNonRepeatingCharacter(input);
        System.out.println("Index of Non repeating character is: "+ index);
        System.out.println("Index of Non repeating character with HashMap is: "+ firstNonRepeatingCharacterUsingHashmap(input));
    }

    private static int firstNonRepeatingCharacter(String input) {
        int[] chars = new int[26];

        for (int i = 0; i < input.length(); i++) {
            chars[input.charAt(i) - 'a']++;
        }

        for (int i = 0; i < input.length(); i++) {
            if(chars[input.charAt(i) - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }

    private static int firstNonRepeatingCharacterUsingHashmap(String input) {
        Map<Character, Integer> seen = new HashMap<>();

        for (char c : input.toCharArray()) {
            seen.put(c, seen.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(seen.get(c) == 1){
                return i;
            }
        }

        return -1;
    }
}
