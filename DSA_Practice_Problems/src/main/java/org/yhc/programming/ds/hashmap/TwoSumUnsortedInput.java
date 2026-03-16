package org.yhc.programming.ds.hashmap;

import java.util.*;

public class TwoSumUnsortedInput {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;

        System.out.println("Is target available in nums? : "+ Arrays.toString(twoSum(nums, target)));
    }

    private static int[] twoSum(int[] nums, int target){
        //Map<value, index>
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
