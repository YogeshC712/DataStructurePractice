package org.yhc.programming.pattern.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementMonotonicStack {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 2, 4, 3};

        System.out.println("Array of next greater element - " + Arrays.toString(nextGreaterElement(nums)));
    }

    private static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                result[stack.peek()] = nums[i];
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
