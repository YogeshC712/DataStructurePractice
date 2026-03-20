package org.yhc.programming.pattern.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[][] testCases = {
                {-1, 0, 1, 2, -1, -4},
                {1, 2, 3, 4, 5},
                {0, 0, 0, 0},
                {-4, -1, -1, 0, 1, 2, 2},
                {-10, -7, -3, -1, 0, 3, 7, 10},
                {-3, -5, -7, -9}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            System.out.println("\nTest Case " + (i + 1) + ":\n\tInput: " + Arrays.toString(nums));
            List<List<Integer>> result = threeSum(nums);
            System.out.print("\tOutput: ");
            System.out.println(result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> results = new ArrayList<>();

        // Sort array to enable two-pointer technique and handle duplicates. this will help to ignore adjacent duplicate values
        //{-1, 0, 1, 2, -1, -4} => {-4, -1, -1, 0, 1, 2}
        Arrays.sort(nums);

        // Fix the first element and use two pointers for the remaining two. From 0 till third last element
        for (int pivot = 0; pivot < nums.length - 2; pivot++) {
            //As it is sorted, all the values in nums after this will be greater than 0. We can break the loop to avoid unnecessary calculation
            if(nums[pivot] > 0){
                break;
            }

            // Skip duplicate values for the first element to avoid duplicate triplets
            if(pivot > 0 && nums[pivot] == nums[pivot - 1]){
                continue;
            }

            // Initialize two pointers for the remaining subarray
            int left = pivot + 1;
            int right = nums.length - 1;

            // Use two-pointer technique to find pairs that sum to -nums[pivot]
            while (left < right){
                int total = nums[pivot] + nums[left] + nums[right];

                if(total < 0){
                    // Sum too small, move left pointer right to increase sum
                    left++;
                } else if (total > 0) {
                    // Sum too large, move right pointer left to decrease sum
                    right--;
                }else {
                    // Found a valid triplet
                    results.add(Arrays.asList(nums[pivot], nums[left], nums[right]));

                    // Skip all duplicate values to avoid duplicate triplets
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }

                    // Move both pointers to continue searching
                    left++;
                    right--;
                }
            }
        }
        return results;
    }
}
