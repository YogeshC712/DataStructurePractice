package org.yhc.programming.pattern.bfs.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    public static void main(String[] args) {
        Integer[] nums = {4, 2, 7, 1, 3, 6, 9, null, 5, null, 2};
        TreeNode root = TreeNode.buildTree(nums);

        List<List<Integer>> bfs = zigzagLevelOrder(root);
        System.out.println("Zigzag Level order : "+bfs);
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode node){
        List<List<Integer>> result = new ArrayList<>();
        if(node == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        boolean leftToRight = true;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            LinkedList<Integer> nodes = new LinkedList<>();

            // process all nodes at this level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();

                if(leftToRight){
                    // add the node to the back of the list
                    nodes.addLast(currNode.val);
                }else{
                    // add the node to the front of the list
                    nodes.addFirst(currNode.val);
                }

                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            // we've processed all nodes at the current level add them to the output list and toggle leftToRight to prepare for the next level
            result.add(new ArrayList<>(nodes));
            leftToRight = !leftToRight;
        }

        return result;
    }
}
