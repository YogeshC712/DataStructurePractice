package org.yhc.programming.pattern.two_pointers;

public class ContainerMaxWater {
    public static void main(String[] args) {
        int[] heights = {3, 4, 1, 2, 2, 4, 1, 3, 2};
        System.out.println("Container with Max area is: "+ maxArea(heights));
    }

    private static int maxArea(int[] heights){
        //Two pointer technique
        int left = 0;
        int right = heights.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (left < right){
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int currArea = width * height;
            maxArea = Math.max(maxArea, currArea);

            //Greedy algorithm
            if(heights[left] < heights[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}
