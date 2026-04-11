package org.yhc.programming.pattern.dfs.tree;

import org.yhc.programming.helperds.TreeNode;

public class PathSum {
    public static void main(String[] args) {
        Integer[] nums = {4, 2, 7, 1, 3, 6, 9};
        int target = 17;
        TreeNode root = TreeNode.buildTree(nums);

        System.out.println("Is Path sum of given target available : " + dfs(root, target));
    }

    private static boolean dfs(TreeNode node, int target){
        //base condition - If our current node is None, then our subtree is empty and there's no path from the current node to a leaf that sums to the target.
        if(node == null){
            return false;
        }

        //base condition - if we reach a leaf node, check if the target is equal to the leaf node's value
        //If our current node is a leaf node, then we check if the target is equal to the leaf node's value. If it is, then there's a path from the current node to a leaf that sums to the target.
        if(node.left == null && node.right == null){
            return node.val == target;
        }

        // check if there's a path from the current node to a leaf that sums to target
        boolean left = dfs(node.left, target - node.val);
        boolean right = dfs(node.right, target - node.val);

        return left || right;
    }
}
