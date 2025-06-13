package org.yhc.programming.pattern.mergeintervals;

import java.util.Arrays;
import java.util.LinkedList;

/*
Given a sorted list of nonoverlapping intervals and a new interval, your task is to insert the new interval
into the correct position while ensuring that the resulting list of intervals remains sorted and nonoverlapping.
Each interval is a pair of nonnegative numbers, the first being the start time and the second being the end time of the interval.
Constraints:
    0 <= existing_intervals.length <= 10^4
    existing_intervals[i].length, new_interval.length == 2
    0 <= start time < end time <= 10^4
    The list of intervals is sorted in ascending order based on the start time
 */
public class InsertInterval {

    public static void main(String[] args) {
        int[][] input = {{1, 2}, {3, 4}, {5, 8}, {9, 15}};
        int[] newInterval = {16, 17};
        //[[1,2],[3,4],[5,8],[9,15]] , [16,17]

        int[][] result = insertInterval(input, newInterval);
        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] insertInterval(int[][] input, int[] newInterval) {
        LinkedList<int[]> result = new LinkedList<>();

        int start_ni = newInterval[0];
        int end_ni = newInterval[1];
        int n = input.length;

        int i = 0;
        while (i <= n - 1 && input[i][0] <= start_ni){
            result.add(input[i]);
            i++;
        }

        if(i > 0 && start_ni <= result.getLast()[1]){
            result.getLast()[1] = Integer.max(result.getLast()[1], end_ni);
        }else{
            result.add(newInterval);
        }

        for (int j = i; j < n; j++) {
            if(input[j][0] <= result.getLast()[1]){
                result.getLast()[1] = Integer.max(result.getLast()[1], input[j][1]);
            }else{
                result.add(input[j]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
