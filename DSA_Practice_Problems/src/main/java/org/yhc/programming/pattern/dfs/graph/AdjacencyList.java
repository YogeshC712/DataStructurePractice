package org.yhc.programming.pattern.dfs.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList {
    public static void main(String[] args) {
        int[][] edges = {
                {0,1},
                {1,2},
                {2,3},
                {3,0},
                {0,2}
        };
        int nodes = 4;
        System.out.println("Adjacency List: " + buildAdjList(edges, nodes));
    }

    private static Map<Integer, List<Integer>> buildAdjList(int[][] edges, int nodes){
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < nodes; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }
}
