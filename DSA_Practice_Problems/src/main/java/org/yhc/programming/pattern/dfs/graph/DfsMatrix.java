package org.yhc.programming.pattern.dfs.graph;

import java.util.HashSet;
import java.util.Set;

public class DfsMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0},
                {0, 1, 0},
                {1, 0, 0}
        };
        dfsMatrix(matrix);
    }

    private static void dfsMatrix(int[][] matrix){
        Set<String> visited = new HashSet<>();

        // up [-1 0], down [1, 0], left [0, -1], right [0, 1]
        int[][] directions = {{-1,0}, {1,0},{0,-1},{0,1}};

        dfs(0, 0, matrix, directions, visited);
    }

    private static void dfs(int r, int c, int[][] matrix, int[][] directions, Set<String> visited){
        String key = r + "," + c;

        if(visited.contains(key)){
            return;
        }

        // check if the cell is out of bounds
        if(r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length){
            return;
        }

        System.out.println("Key : "+ key);
        visited.add(key);
        for (int[] direction: directions) {
            dfs(r + direction[0], c + direction[1], matrix, directions, visited);
        }
    }
}
