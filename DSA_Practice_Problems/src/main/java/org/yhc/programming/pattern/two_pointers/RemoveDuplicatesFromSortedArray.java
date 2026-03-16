package org.yhc.programming.pattern.two_pointers;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("Final length:" + result);
    }

    private static int removeDuplicates(int[] nums) {
        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {
            if(nums[fast] != nums[slow]){
                slow++;

                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
