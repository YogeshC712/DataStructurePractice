package org.yhc.programming.pattern.binarysearch;

public class RotatedSortedArrayBinarySearch {
    public static void main(String[] args) {
        int[] nums = {8,9,10,12,16,17,1,2,3};
        int target = 3;

        System.out.println("Is the target [" + target + "] exist in input at index: " + rotatedSortedBinarySearch(nums, target));
    }

    private static int rotatedSortedBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){
                //left half sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                //right half sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
