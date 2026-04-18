package org.yhc.programming.pattern.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsKProblem {
    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        System.out.println("Total number of subarray with sum k[" + "] is: " + prefixSum(nums, 7));
    }

    private static int prefixSum(int[] nums, int k){
        int subArrCount = 0;
        // Map: prefix_sum -> frequency; Initialize with sum 0
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);

        int prefixSum = 0;
        for (int num: nums) {
            prefixSum += num;

            // Check if there's a prefix sum that makes current subarray sum = k
            // If sum - k exists, then subarray from that point to current has sum k
            subArrCount += prefixMap.getOrDefault(prefixSum - k, 0);

            // Record current prefix sum in our frequency map
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }
        return subArrCount;
    }
}
