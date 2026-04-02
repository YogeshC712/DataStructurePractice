package org.yhc.programming.pattern.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 7, 9, 15, 30};
        int target = 7;

        System.out.println("Is the target [" + target + "] exist in input at index: " + binarySearch(nums, target));
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
