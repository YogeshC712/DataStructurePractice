package org.yhc.programming.pattern.two_pointers;

import java.util.Arrays;

/*
Problem statement -
Given an array, colors, which contains a combination of the following three elements:

0 (Representing red)
1 (Representing white)
2 (Representing blue)

Sort the array in place so that the elements of the same color are adjacent, and the final order is: red (0), then white (1), and then blue (2).
Note: You are not allowed to use any built-in sorting functions. The goal is to solve this efficiently without extra space.

Solution/approach -

1. start and current: These pointers will initially point to the first index of the colors array.
2. end: This pointer will initially point to the last index of the colors array.

3. We start by iterating over the colors array until the current pointer exceeds the end pointer, i.e., current <= end. During this iteration, we perform the following three conditions:
    Condition 1: If colors[current] is 0:
        The current pointer points to red. Swap the elements of colors[current] and colors[start]. This ensures the red element is placed at the beginning of the array.
        Next, increment both the start and current pointers one position forward. Moving start ensures that the next red element will occupy the correct position.
    Condition 2: If colors[current] is 1:
        The element (white) is already in its correct section (middle of the array), so no swapping is required.
        Increment the current pointer by 1 to analyze the next element.
    Condition 3: If colors[current] is 2:
        The current pointer points to blue. Swap the elements of colors[current] and colors[end]. This pushes the blue element to the end of the array.
        Next, decrement the end pointer one position backward to reduce the section for blue elements.

Time Complexity -
The time complexity of this solution is O(n) since we’re only traversing the array once.

Space complexity -
The space complexity of this solution is O(1) since no extra space is used.
 */
public class SortColors {
    public static void main(String[] args) {
        int[] colors = {2, 1, 1, 0, 1, 0, 2};

        int[] output = sortColors(colors);
        System.out.println(Arrays.toString(output));
    }

    private static int[] sortColors(int[] colors) {
        int start = 0;
        int current = 0;
        int end = colors.length - 1;

        while(current <= end){
            if(colors[current] == 0){
                swap(colors, start, current);

                start++;
                current++;
            }else if(colors[current] == 2){
                swap(colors, end, current);

                end--;
            }else{
                current++;
            }
        }
        return colors;
    }

    private static void swap(int[] colors, int start, int current) {
        int temp = colors[start];
        colors[start] = colors[current];
        colors[current] = temp;
    }
}
