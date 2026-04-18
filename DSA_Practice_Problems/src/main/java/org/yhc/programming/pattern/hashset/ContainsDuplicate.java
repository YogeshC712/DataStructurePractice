package org.yhc.programming.pattern.hashset;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        boolean duplicate = containsDuplicate(nums);

        System.out.println("Does it contains duplicate? " + duplicate);
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num: nums) {
            if(seen.contains(num)){
                return true;
            }
            seen.add(num);
        }

        return false;
    }
}
