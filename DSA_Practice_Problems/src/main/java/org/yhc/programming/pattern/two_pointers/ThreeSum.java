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
        //{-1, 0, 1, 2, -1, -4} => {-4, -1, -1, 0, 1, 2}

        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0){
                break; //because all the values in nums after this will be greater than 0 as it is sorted. We can skip the calc
            }

            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int total = nums[i] + nums[left] + nums[right];

                if(total < 0){
                    left++;
                } else if (total > 0) {
                    right--;
                }else {
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }

        return results;
    }

    /*private static List<List<Integer>> threeSum(int[] nums) {
        //Sort the array, that will help to ignore adjacent duplicate values
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        //From 0 till third last element
        for (int pivot = 0; pivot < n - 2; pivot++) {
            //We are breaking the flow because after this all values will be ( > 0 ) in sorted array
            if(nums[pivot] > 0){
                break;
            }

            //to ignore adjacent duplicate values
            if(pivot > 0 && nums[pivot] == nums[pivot - 1]){
                continue;
            }

            // Use two-pointer technique
            int low = pivot + 1, high = n - 1;
            while(low < high){
                int sum = nums[pivot] + nums[low] + nums[high];

                if(sum < 0){
                    low++;
                } else if (sum > 0) {
                    high--;
                }else {
                    // Found a triplet
                    result.add(Arrays.asList(nums[pivot], nums[low], nums[high]));
                    low++;
                    high--;

                    // Skip duplicates for low and high pointers
                    while (low < high && nums[low] == nums[low - 1]){
                        low++;
                    }
                    while (low < high && nums[high] == nums[high + 1]){
                        high--;
                    }
                }
            }
        }
        return result;
    }*/
}
