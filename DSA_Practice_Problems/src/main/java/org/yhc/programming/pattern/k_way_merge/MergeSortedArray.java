package org.yhc.programming.pattern.k_way_merge;

import java.util.Arrays;

/*
Problem -
Given two sorted integer arrays, nums1 and nums2, and the number of data elements in each array,m and n,
implement a function that merges the second array into the first one. You have to modify nums1 in place.

Solution - Backward Traversal
1. Initialize two pointers that point to the last data elements in both arrays.
2. Initialize a third pointer that points to the last index of nums1
3. Traverse nums1 from the end using the third pointer and compare the values corresponding to the first two pointers.
4. Place the larger of the two values at the third pointer’s index.
5. Repeat the process until the two arrays are merged.

Time Complexity -
The time complexity is O(n+m), where n and m are the counts of initialized elements in the two arrays.

Space Complexity -
The space complexity is O(1) because we only use the space required for three indices.
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {23, 33, 35, 41, 44, 47, 56, 91, 105, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {32, 49, 50, 51, 61, 99};
        int n = 9;
        int m = 6;

        int[] nums3 = mergeSortedArray(nums1, n, nums2, m);
        System.out.println(Arrays.toString(nums3));
    }

    private static int[] mergeSortedArray(int[] nums1, int n, int[] nums2, int m) {
        int p1 = n - 1;
        int p2 = m - 1;

        for(int p = n+m-1; p >= 0; p--){
            //p2 will be the first exhausted
            if(p2 < 0){
                break;
            }
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1];
                p1 -= 1;
            }else{
                nums1[p] = nums2[p2];
                p2 -= 1;
            }
        }
        return nums1;
    }
}
