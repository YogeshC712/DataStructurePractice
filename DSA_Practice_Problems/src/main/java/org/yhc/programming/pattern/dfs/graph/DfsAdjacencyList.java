package org.yhc.programming.pattern.dfs.graph;

import java.util.*;

public class DfsAdjacencyList {
    private static final Map<Integer, List<Integer>> adjList = Map.of(
            1, List.of(2, 4),
            2, List.of(1, 3),
            3, List.of(2, 4),
            4, List.of(1, 3, 5),
            5, List.of(4)
    );
    private static  final Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        dfs(adjList);
    }

    private static void dfs(Map<Integer, List<Integer>> adjList){
        if(adjList == null || adjList.isEmpty()) return;

        for (int node: adjList.keySet()) {
            System.out.println("Node: " + node);

            if(!visited.contains(node)){
                dfsHelper(node);
            }
        }
    }

    private static void dfsHelper(int node){
        if(visited.contains(node)){
            return;
        }
        visited.add(node);

        for (int neighbor: adjList.getOrDefault(node, new ArrayList<>())) {
            System.out.println("Neighbor : "+ neighbor);
            dfsHelper(neighbor);
        }
    }
}
