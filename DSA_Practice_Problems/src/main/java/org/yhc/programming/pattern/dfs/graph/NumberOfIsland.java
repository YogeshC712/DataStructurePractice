package org.yhc.programming.pattern.dfs.graph;

import java.util.Arrays;

public class NumberOfIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 0, 1, 0}
        };
        System.out.println("Input grid is :  "+ Arrays.deepToString(grid));
        int result = numberOfIsland(grid);
        System.out.println("Number of Island: "+ result);
    }

    private static int numberOfIsland(int[][] grid){
        if(grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                //Found start of first Island
                if(grid[r][c] == 1){
                    count++;
                    dfs(grid, r, c, rows, cols);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, int r, int c, int rows, int cols){
        //Mark visited cell 0
        grid[r][c] = 0;

        if(r + 1 < rows && grid[r + 1][c] == 1){
            dfs(grid, r + 1, c, rows, cols);
        }
        if(r > 0 && grid[r - 1][c] == 1){
            dfs(grid, r - 1, c, rows, cols);
        }
        if(c + 1 < cols && grid[r][c + 1] == 1){
            dfs(grid, r, c + 1, rows, cols);
        }
        if(c > 0 && grid[r][c - 1] == 1){
            dfs(grid, r, c - 1, rows, cols);
        }
        return;
    }
}
