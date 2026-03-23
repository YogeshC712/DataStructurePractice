package org.yhc.programming.pattern.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {9, 3, 7, 1, -2, 6, 8};

        System.out.println("Kth Largest elements are: " + Arrays.toString(kthLargestElements(nums, 3)));
    }

    /**
     * Step 1 - Create a min-heap that stores the first K elements of the array. These represent 'K' largest elements we have seen so far, with the smallest of the 'K' at the root of the heap.
     * Step 2 - Iterate through the remaining elements in the array.
     *              If the current element is larger than the root of the heap, pop the root and push the current element into the heap.
     *              Otherwise, continue to the next element.
     * @param nums
     * @param k
     * @return
     */
    private static int[] kthLargestElements(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if(minHeap.size() < k){
                minHeap.offer(num);
            }else if(num > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] kthLargestElements_anotherApproach(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // create a min-heap with the first K elements
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        // iterate through the remaining elements
        for (int i = k; i < nums.length; i++) {
            if(nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.stream().mapToInt(Integer::intValue).toArray();
    }
}
