package org.yhc.programming.pattern.kadane;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int max = maxSubArray(nums);

        System.out.println("Maximum sum - " + max);
    }
    private static int maxSubArray(int[] nums) {
        //Kadane's Algorithm - Extend previous subArray OR start fresh from current element
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int num : nums) {
            //Extend previous subArray OR start fresh from current element
            currentSum = Math.max(num, num + currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
