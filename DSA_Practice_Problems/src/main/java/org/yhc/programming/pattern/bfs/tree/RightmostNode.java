package org.yhc.programming.pattern.bfs.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightmostNode {

    public static void main(String[] args) {
        Integer[] nums = {1,2,5,3,null,null,4};
        TreeNode root = TreeNode.buildTree(nums);

        List<Integer> bfs = rightmostNode(root);
        System.out.println("Rightmost nodes for every level are : "+bfs);
    }

    private static List<Integer> rightmostNode(TreeNode node){
        if(node == null) return new ArrayList<>();

        List<Integer> nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            // start of a new level here
            int levelSize = queue.size();

            // process all nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                if(i == levelSize - 1){
                    nodes.add(curr.val);
                }

                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
        }
        return nodes;
    }
}
