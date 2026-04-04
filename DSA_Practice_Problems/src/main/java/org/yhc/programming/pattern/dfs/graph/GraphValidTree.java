package org.yhc.programming.pattern.dfs.graph;

import java.util.*;

public class GraphValidTree {
    public static void main(String[] args) {
        int[][] edges_valid = {
                {0,1},
                {1,2}
        };
        int[][] edges_cycle = {
                {0,1},
                {1,2},
                {2,0}
        };

        int[][] edges_disconnected = {
                {0,1},
                {2,3}
        };

        int nodes = 4;
        System.out.println("Is it a Graph valid tree: " + validTree(edges_disconnected, nodes));
    }

    private static boolean validTree(int[][] edges, int n){
        List<List<Integer>> adjList = new ArrayList<>();

        //Step 1 - create adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        //Step 2 - check cycles - Use DFS to check if the graph is a valid tree
        boolean[] visited = new boolean[n];
        if(hasCycle(adjList, 0, visited, -1)){
            return false;
        }

        //step 3 - check if all nodes visited (if the graph is disconnected then its invalid)
        for (boolean node: visited) {
            if(!node){
                return false;
            }
        }

        return true;
    }

    private static boolean hasCycle(List<List<Integer>> adjList, int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (int neighbor: adjList.get(node)) {
            if(visited[neighbor] && parent != neighbor){
                return true;
            }else if(!visited[neighbor] &&
                    hasCycle(adjList, neighbor, visited, node)){
                return true;
            }
        }
        return false;
    }
}
