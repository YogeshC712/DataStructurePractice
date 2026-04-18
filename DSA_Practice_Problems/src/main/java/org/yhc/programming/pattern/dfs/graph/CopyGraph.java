package org.yhc.programming.pattern.dfs.graph;

import java.util.*;

public class CopyGraph {
    public static void main(String[] args) {
        IntGraphNode node1 = new IntGraphNode(1);
        IntGraphNode node2 = new IntGraphNode(2);
        IntGraphNode node3 = new IntGraphNode(3);
        IntGraphNode node4 = new IntGraphNode(4);

        node1.setNeighbors(new IntGraphNode[]{node2, node4});
        node2.setNeighbors(new IntGraphNode[]{node1, node3});
        node3.setNeighbors(new IntGraphNode[]{node2, node4});
        node4.setNeighbors(new IntGraphNode[]{node1, node3});

        Map<Integer, List<Integer>> graph = copyGraph(node1);

        System.out.println("Copy graph is: "+ graph);
    }

    private static Map<Integer, List<Integer>> copyGraph(IntGraphNode node){
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        if(node != null){
            dfs(node, adjList);
        }
        return adjList;
    }

    private static void dfs(IntGraphNode node, Map<Integer, List<Integer>> adjList){
        if(adjList.containsKey(node.value)){
            return;
        }
        /*List<Integer> neighbors = new ArrayList<>();
        for (IntGraphNode neighbor: node.neighbors) {
            neighbors.add(neighbor.value);
        }*/
        List<Integer> neighbors = Arrays.stream(node.neighbors)
                .map(n -> n.value)
                .toList();
        adjList.put(node.value, neighbors);

        for (IntGraphNode neighbor: node.neighbors) {
            dfs(neighbor, adjList);
        }
    }
}

class IntGraphNode{
    int id;
    int value;
    IntGraphNode[] neighbors;

    public IntGraphNode(int value){
        this.value = value;
    }

    public void setNeighbors(IntGraphNode[] neighbors){
        this.neighbors = neighbors;
    }
}
