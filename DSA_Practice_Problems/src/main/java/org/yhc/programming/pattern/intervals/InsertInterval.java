package org.yhc.programming.pattern.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int[][] input = {{1, 3}, {4, 6}, {6, 7}, {8, 10}, {11, 15}};
        int[] newInterval = {5, 8};
        //[[1,2],[3,4],[5,8],[9,15]] , [16,17]

        int[][] result = insertInterval(input, newInterval);
        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();

        int i = 0;
        int n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]){
            merged.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        merged.add(newInterval);

        for (int j = i; j < n; j++) {
            merged.add(intervals[j]);
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
