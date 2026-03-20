package org.yhc.programming.pattern.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class PriorityQueuePractise {
    public static void main(String[] args) {
        //Min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        IntStream.of(9, 8, 3, 1, 5)
                .forEach(minHeap::offer);

        System.out.println("Peek the top of Min heap - " + minHeap.peek());
        minHeap.poll();
        System.out.println("Peek the top of Min heap after poll - " + minHeap.peek());

        //Max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        IntStream.of(9, 8, 3, 1, 5)
                .forEach(maxHeap::offer);

        System.out.println("Peek the top of Max heap - " + maxHeap.peek());
        maxHeap.poll();
        System.out.println("Peek the top of Max heap after poll - " + maxHeap.peek());

        //Min heap with custom comparator
        int[][] arr = {{3, 1}, {1, 5}, {4, 2}, {1, 9}, {5, 3}, {9, 4}, {2, 6}};
        Comparator<int[]> comparator = (a, b) -> {
            int compare = Integer.compare(a[0], b[0]);
            return (compare != 0) ? compare : Integer.compare(a[1], b[1]);
        };
        PriorityQueue<int[]> heap = new PriorityQueue<>(comparator);

        for (int[] tuple : arr){
            heap.offer(tuple);
        }

        System.out.println("Minimum tuple - " + Arrays.toString(heap.peek()));
        heap.poll();
        System.out.println("New Minimum tuple - " + Arrays.toString(heap.peek()));

    }
}
