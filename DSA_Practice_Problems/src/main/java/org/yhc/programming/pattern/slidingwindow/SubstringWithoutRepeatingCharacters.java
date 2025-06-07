package org.yhc.programming.pattern.slidingwindow;

import java.util.HashMap;

/*
Given a string, str, return the length of the longest substring without repeating characters.

Constraints:
    1 <= str.length < 10^5
    str consists of English letters, digits, symbols, and spaces.
 */
public class SubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String[] inputs = {
                "abcabcbb",
                "pwwkew",
                "bbbbb",
                "ababababa",
                "",
                "ABCDEFGHI",
                "ABCDEDCBA",
                "AAAABBBBCCCCDDDD"
        };

        for (int i = 0; i < inputs.length; i++) {
            int len = longestSubstringWithoutRepeatingCharacters(inputs[i]);
            System.out.print(i + 1);
            System.out.println("\tInput string: " + inputs[i]);
            System.out.println("\n\tLength of longest string: "+ len);
            System.out.println();
        }
    }

    private static int longestSubstringWithoutRepeatingCharacters(String input){
        //Check the length of the input
        if(input.length() == 0) return 0;

        var n = input.length();
        var windowStart = 0;
        var windowLen = 0;
        var longest = 0;
        var i = 0;

        //Map - to capture the latest index of each char
        HashMap<Character, Integer> lastSeenAt = new HashMap<>();

        //Traverse input string char by char
        for(i = 0; i < n; i++){
            var currentChar = input.charAt(i);
            //If char is not available - that means new entry
            if(!lastSeenAt.containsKey(currentChar)){
                lastSeenAt.put(currentChar, i);
            }else{

                var index = lastSeenAt.get(currentChar);
                //It means this char appeared before. Check whether appear before/after windowStart
                if(index >= windowStart){
                    windowLen = i - windowStart;

                    //check if current longest substring is less than current windowLen, if yes then update
                    if(longest < windowLen){
                        longest = windowLen;
                    }
                    //update the window starting point to exclude the duplicate character
                    windowStart = index + 1;
                }

                //replace the last occurrence of the currentChar in hashmap
                lastSeenAt.replace(currentChar, i);
            }
        }

        //update the longest substring's length and starting index
        if(longest < i - windowStart){
            longest = i - windowStart;
        }

        return longest;
    }
}
