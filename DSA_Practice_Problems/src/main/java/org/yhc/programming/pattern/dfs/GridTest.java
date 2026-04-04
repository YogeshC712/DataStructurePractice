package org.yhc.programming.pattern.dfs;

public class GridTest {
    public static void main(String[] args) {
        int[][] grid =
                {{1,1,1},
                {2,2,2},
                {3,3,3}};

        int rows = grid.length;
        int cols = grid[0].length;

        for (int[] ints : grid) {
            for (int c = 0; c < cols; c++) {
                System.out.print(ints[c] + "  ");
            }
            System.out.println("");
        }
    }
}
