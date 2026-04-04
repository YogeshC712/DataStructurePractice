package org.yhc.programming.pattern.dfs.graph;

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] grid = {
                {'X','X','X','X','O'},
                {'X','X','O','X','X'},
                {'X','X','O','X','O'},
                {'X','O','X','X','X'},
                {'X','O','X','X','X'}
        };
        System.out.println("Input grid is :  "+ Arrays.deepToString(grid));
        char[][] result = numberOfIsland(grid);
        System.out.println("Number of Island: "+ Arrays.deepToString(result));
    }

    private static char[][] numberOfIsland(char[][] grid){
        if(grid == null || grid.length == 0){
            return grid;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        // initialize the dfs for the first and last column
        for (int r = 0; r < rows; r++) {
            if(grid[r][0] == 'O'){
                dfs(grid, r, 0, rows, cols);
            }
            if(grid[r][cols - 1] == 'O'){
                dfs(grid, r, cols - 1, rows, cols);
            }
        }

        // initialize the dfs for the first and last row
        for (int c = 0; c < cols; c++) {
            if(grid[0][c] == 'O'){
                dfs(grid, 0, c, rows, cols);
            }
            if(grid[rows - 1][c] == 'O'){
                dfs(grid, rows - 1, c, rows, cols);
            }
        }

        // change the "O"s that are not marked as "S" to "X"s and the "S"s back to "O"s
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                //Found start of first Island
                if(grid[r][c] == 'O'){
                    grid[r][c] = 'X';
                }
                if(grid[r][c] == 'S'){
                    grid[r][c] = 'O';
                }
            }
        }
        return grid;
    }

    // recursive function to find all the "O"s that are reachable from the border and mark them as "S"
    private static void dfs(char[][] grid, int r, int c, int rows, int cols){

        // return immediately if the cell is out of bounds or is not an "O"
        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != 'O'){
            return;
        }

        //Mark visited cell 'S' as safe
        grid[r][c] = 'S';

        // explore the neighboring cells
        dfs(grid, r + 1, c, rows, cols);
        dfs(grid, r - 1, c, rows, cols);
        dfs(grid, r, c + 1, rows, cols);
        dfs(grid, r, c - 1, rows, cols);
    }
}
