package org.yhc.programming.pattern.bfs.tree;

import org.yhc.programming.helperds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsTraversal {
    public static void main(String[] args) {
        Integer[] nums = {4,2,7,1,3,6,9};
        TreeNode root = TreeNode.buildTree(nums);

        List<Integer> bfs = bfsTraversal(root);
        System.out.println("BFS Traversal: "+bfs);

        List<List<Integer>> levels = levelOrder(root);
        System.out.println("Level order nodes are: " + levels);
    }

    private static List<Integer> bfsTraversal(TreeNode node){
        List<Integer> list = new ArrayList<>();
        if(node == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            TreeNode front = queue.poll();
            list.add(front.val);

            if(front.left != null){
                queue.offer(front.left);
            }
            if(front.right != null){
                queue.offer(front.right);
            }
        }
        return list;
    }

    private static List<List<Integer>> levelOrder(TreeNode node){
        List<List<Integer>> result = new ArrayList<>();
        if(node == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            // number of nodes at the current level
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                currentLevel.add(curr.val);

                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            // we have finished processing all nodes at the current level
            result.add(currentLevel);
        }
        return result;
    }
}
