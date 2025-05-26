package org.yhc.programming.pattern.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public static void main(String[] args) {
        int [][] input = {{3, 7}, {1, 5}, {4, 6}, {11, 15}, {10, 12}, {6, 8}};

        int[][] result =  mergeIntervals(input);
        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] mergeIntervals(int[][] input){
        /*
         * Step 1 - is to sort the list of intervals based on their start times.
         * This ensures that we are processing the intervals in the correct order, from the earliest start time to the latest,
         * to easily detect overlapping intervals as we move through the list.
         */
        Arrays.sort(input, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(input));

        // we initialize a result list and add the first interval from the sorted list to it
        LinkedList<int[]> output = new LinkedList<>();
        output.add(input[0]);

        // Next, we iterate through the remaining intervals in the input list, starting from the second one
        for (int i = 1; i < input.length; i++) {

            // If the current interval’s start time is less than or equal to the end time of the last interval in the result list
            if(input[i][0] <= output.getLast()[1]){
                // In this case, we merge them by updating the end time of the last interval in the result list to be the maximum of its current end time and the end time of the overlapping interval
                output.getLast()[1] = Integer.max(input[i][1], output.getLast()[1]);
            }else {
                // else, we simply add the current interval to the output list
                output.add(input[i]);
            }
        }
        return output.toArray(new int[output.size()][]);
    }
}
