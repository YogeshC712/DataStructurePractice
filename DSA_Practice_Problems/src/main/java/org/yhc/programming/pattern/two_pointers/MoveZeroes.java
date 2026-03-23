package org.yhc.programming.pattern.two_pointers;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] input = {2,0,0,4,0,9};
        System.out.println("Result after moving zeroes: " + Arrays.toString(moveZeroes(input)));
    }

    private static int[] moveZeroes(int[] input){
        int slow = 0;

        for (int fast = 0; fast < input.length; fast++) {
            //check for non-zero element to swap with zero
            if(input[fast] != 0){
                //Swap the elements
                int temp = input[slow];
                input[slow] = input[fast];
                input[fast] = temp;

                slow++;
            }
        }
        return input;
    }
}
