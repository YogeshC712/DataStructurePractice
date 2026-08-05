package org.yhc.programming.pattern.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperaturesMonotonicStack {
    public static void main(String[] args) {
        int[] nums = {65, 70, 68, 60, 55, 75, 80, 74};

        //1,4,3,2,1,1,0,0
        System.out.println("Array of next greater element - " + Arrays.toString(nextWarmerDay(nums)));
    }

    private static int[] nextWarmerDay(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 0);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                int index = stack.pop();
                result[index] = i - index;
            }

            stack.push(i);
        }
        return result;
    }
}
