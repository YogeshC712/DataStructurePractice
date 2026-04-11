package org.yhc.programming.pattern.bfs.tree;

import org.yhc.programming.helperds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderSum {

    public static void main(String[] args) {
        Integer[] nums = {1, 3, 4, null, 2, 7, null, 8};
        TreeNode root = TreeNode.buildTree(nums);

        List<Integer> bfs = levelOrderSum(root);
        System.out.println("Level order sum is : "+bfs);
    }

    private static List<Integer> levelOrderSum(TreeNode node){
        if(node == null) return new ArrayList<>();

        List<Integer> nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            // start of a new level here
            int levelSize = queue.size();
            int sum = 0;

            // process all nodes in the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;

                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }

            // we are at the end of the level, add the sum of the nodes to the output list
            nodes.add(sum);
        }
        return nodes;
    }
}
