package org.yhc.programming.pattern.slidingwindow;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] nums = {2,1,5,1,3,2};
        int k = 3;

        System.out.println("Max subarray sum of window size "+ k + " is: " + maxSubArraySum(nums, k));
    }

    private static int maxSubArraySum(int[] nums, int k){
        //state - which should be of O(1)
        int currentWindowSum = 0;

        int maxSum = Integer.MIN_VALUE;
        int start = 0;

        //Keep expanding the window
        for (int end = 0; end < nums.length; end++) {
            currentWindowSum += nums[end];

            //Fixed window
            if(end - start + 1 == k){
                maxSum = Math.max(maxSum, currentWindowSum);

                //contract the window
                currentWindowSum -= nums[start];
                start++;
            }
        }
        return maxSum;
    }

    /**
     * Template for Fixed sliding window
     * public int fixedLengthSlidingWindow(int[] nums, int k) {
     *     // choose appropriate data structure
     *     // Map<Integer, Integer> state = new HashMap<>();
     *     int start = 0;
     *     int max = 0;
     *     for (int end = 0; end < nums.length; end++) {
     *         // extend window
     *         // add nums[end] to state in O(1) time
     *         if (end - start + 1 == k) {
     *             // INVARIANT: size of the window is k here.
     *             max = Math.max(max, contents of state);
     *             // contract window
     *             // remove nums[start] from state in O(1) time
     *             start++;
     *         }
     *     }
     *     return max;
     * }
     */
}
