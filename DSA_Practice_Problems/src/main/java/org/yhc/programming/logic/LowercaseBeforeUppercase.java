package org.yhc.programming.logic;

import java.util.HashSet;
import java.util.Set;

public class LowercaseBeforeUppercase {
    public static int countValidChars(String s) {
        // Stores lowercase letters seen before uppercase
        Set<Character> valid = new HashSet<>();

        // Stores letters that became invalid (uppercase appeared)
        Set<Character> invalid = new HashSet<>();

        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                char lower = ch;

                // Only add if not already invalidated
                if (!invalid.contains(lower)) {
                    valid.add(lower);
                }

            } else if (Character.isUpperCase(ch)) {
                char lower = Character.toLowerCase(ch);

                // Mark this character as invalid
                invalid.add(lower);

                // Remove from valid set if present
                valid.remove(lower);
            }
        }

        return invalid.size();
    }

    public static void main(String[] args) {
        String s1 = "aaAbcCBc";
        //String s2 = "xyzXYZabcABC";

        System.out.println(countValidChars(s1)); // Output: 2
        //System.out.println(countValidChars(s2)); // Output: 6
    }
}
