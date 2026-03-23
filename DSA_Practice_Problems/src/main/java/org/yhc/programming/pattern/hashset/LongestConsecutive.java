package org.yhc.programming.pattern.hashset;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = {100, 14, 20, 10, 13, 12, 11};
        System.out.println("Longest Consecutive length is: " + longestConsecutive(nums));
    }

    /**
     * Pattern: HashSet + sequence expansion
     * Pseudocode -
     *         1. Put all numbers in HashSet
     *         2. For each number:
     *               if (num - 1 not in set) → start sequence
     *                   count length while (num + 1 exists)
     *         3. Track max length
     *
     * @param nums
     * @return
     */
    private static int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();

        // Step 1: Add all elements
        for (int num: nums) {
            set.add(num);
        }

        int maxLength = 0;
        // Step 2: Check for sequence starts
        for (int num: nums) {
            // Only start if it's the beginning of sequence
            if(!set.contains(num - 1)){
                int currNum = num;
                int currLength = 1;

                // Expand sequence
                while(set.contains(currNum + 1)){
                    currNum++;
                    currLength++;
                }
                maxLength = Math.max(currLength, maxLength);
            }
        }
        return maxLength;
    }
}
