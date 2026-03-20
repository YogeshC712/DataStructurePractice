package org.yhc.programming.pattern.prefixsum;

import java.util.Arrays;

public class PrefixSumProblem {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 6, 2, 5, 8};
        System.out.println("Prefix sum - " + Arrays.toString(prefixSum(nums)));
    }

    private static int[] prefixSum(int[] nums){
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        return prefix;

        //To calculate 2 -> 4 sum, we can use below formula
        //prefix[j + 1] - prefix[i] -> prefix[5] - prefix[2]
        //Prefix sum - [0, 1, 4, 8, 14, 16, 21, 29] hence, 2 to 4 sum is (16 - 4) = 12
    }
}
