package org.yhc.programming.pattern.dfs.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
                {1, 0, 1},
                {1, 0, 0},
                {0, 0, 1}
        };
        System.out.println("Flood fill input:  "+ Arrays.deepToString(image));
        int[][] result = floodFill(image, 1, 1, 2);
        System.out.println("Flood fill result: "+ Arrays.deepToString(result));
    }

    private static int[][] floodFill(int[][] image, Integer sr, Integer sc, Integer color){
        if (image == null || image.length == 0 || image[0].length == 0) return image;
        if (sr == null || sc == null || color == null) return image;
        int rows = image.length;
        int cols = image[0].length;
        if (sr < 0 || sr >= rows || sc < 0 || sc >= cols) return image;

        int originalColor = image[sr][sc];

        if(originalColor == color) return image;

        dfs(image, sr, sc, originalColor, color, rows, cols);

        return image;
    }

    private static void dfs(int[][] image, int r, int c, int originalColor, int color, int rows, int cols){
        if(image[r][c] == originalColor){
            image[r][c] = color;

            if(r >= 1){
                dfs(image, r - 1, c, originalColor, color, rows, cols);
            }
            if(r + 1 < rows){
                dfs(image, r + 1, c, originalColor, color, rows, cols);
            }
            if(c >= 1){
                dfs(image, r, c - 1, originalColor, color, rows, cols);
            }
            if(c + 1 < cols){
                dfs(image, r, c + 1, originalColor, color, rows, cols);
            }
        }
    }
}
