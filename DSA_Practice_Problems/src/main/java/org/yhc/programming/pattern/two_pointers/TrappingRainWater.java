package org.yhc.programming.pattern.two_pointers;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {3, 4, 1, 2, 2, 5, 1, 0, 2};
        int water = trappingWater(height);

        System.out.println("Trapped water: "+ water);
    }

    private static int trappingWater(int[] height){
        int water = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right){
            //Process the side with the smaller max boundary
            if(leftMax < rightMax){
                left++;

                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            }else {
                right--;

                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }
        return water;
    }
}
