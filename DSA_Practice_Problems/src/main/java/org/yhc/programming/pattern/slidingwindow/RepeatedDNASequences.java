package org.yhc.programming.pattern.slidingwindow;

import java.util.*;

/*
Problem Statement -
Given a string, s, that represents a DNA sequence, return all the 10-letter-long sequences
(continuous substrings of exactly 10 characters) that appear more than once in s.
You can return the output in any order.

Constraints:
1 ≤ s.length ≤10^3
s[i] is either 'A', 'C', 'G', or 'T'.
 */
public class RepeatedDNASequences {

    public static void main(String[] args) {
        List<String> testCases = Arrays.asList(
                "AAAAACCCCC",
                "ACGTACGTAC",
                "GGGGGGGGGG"
        );

        for (int i = 0; i < testCases.size(); i++) {
            String s = testCases.get(i);
            System.out.println((i + 1) + ".\tInput: \"" + s + "\"");

            int output = findRepeatedDnaSequences(s);
            System.out.print("\n\tInitial Rolling Hash: " + output);

            System.out.println("-" + new String(new char[100]).replace('\0', '-') + "\n");
        }
    }

    private static int findRepeatedDnaSequences(String s) {
        //Dictionary - Mapping of DNA characters to numerical values
        Map<Character, Integer> toInt = new HashMap<>();
        toInt.put('A', 0);
        toInt.put('C', 1);
        toInt.put('G', 2);
        toInt.put('T', 3);

        //convert each character in the input string to corresponding number
        List<Integer> encodedSequence = new ArrayList<>();
        for (char c: s.toCharArray()) {
            encodedSequence.add(toInt.get(c));
        }

        //Rolling hash using polynomial hash
        //h0 = (c1 x 4^9) + (c2 x 4^8) + (c3 x 4^7)....+ (c10 x 4^0)
        var k = 10; // length of the sequence to check
        var a = 4;  // Base-4 encoding - 4 distinguished chars in sequence
        var h = 0;  //to store rolling hash value
        var a_k = 1;    //stores a^k for hash updates

        for (int i = 0; i < k; i++) {
            h = h * a + encodedSequence.get(i);
            a_k = a_k * a;
        }

        return h;
    }
}
