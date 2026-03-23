package org.yhc.programming.pattern.two_pointers;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1,3,4,6,8,10,13};
        int target = 5;

        System.out.println("Is target available in nums? : "+ Arrays.toString(twoSum(nums, target)));
    }

    private static int[] twoSum(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int currSum = nums[left] + nums[right];

            //found target
            if(currSum == target){
                return new int[]{left, right};
            }

            //Avoid unnecessary comparisons
            if(currSum < target){
                left += 1;
            }else{
                right -= 1;
            }
        }
        return new int[]{-1, -1};
    }
    /*private static boolean twoSum(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int currSum = nums[left] + nums[right];

            if(currSum == target){
                return true;
            }

            if(currSum < target){
                left += 1;
            }else{
                right -= 1;
            }
        }
        return false;
    }*/
}
