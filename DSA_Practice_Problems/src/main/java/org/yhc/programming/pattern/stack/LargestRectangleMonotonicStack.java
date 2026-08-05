package org.yhc.programming.pattern.stack;

import java.util.Stack;

public class LargestRectangleMonotonicStack {
    public static void main(String[] args) {
        int[] heights = {2,8,5,6,2,3};
        System.out.println("Largest Rectangle Histogram using Monotonic Increasing Stack - " + largestRectangle(heights));
    }

    private static int largestRectangle(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        int i = 0;
        while (i < n){

            if(stack.isEmpty() || heights[i] > heights[stack.peek()]){
                stack.push(i);
                i++;
            }else {
                int top = stack.pop();
                int right = i - 1;
                int left = stack.isEmpty() ? -1 : stack.peek();
                int currArea = heights[top] * (right - left);
                maxArea = Math.max(maxArea, currArea);
            }
        }

        while(!stack.isEmpty()){
            int top = stack.pop();
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            int currArea = heights[top] * width;
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }
}
