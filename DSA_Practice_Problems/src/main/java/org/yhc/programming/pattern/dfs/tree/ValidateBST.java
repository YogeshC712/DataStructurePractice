package org.yhc.programming.pattern.dfs.tree;

import org.yhc.programming.helperds.TreeNode;

public class ValidateBST {
    public static void main(String[] args) {
        Integer[] nums = {4,1,5,null,null,3,6};
        TreeNode root = TreeNode.buildTree(nums);

        System.out.println("Validate the Binary Search Tree : " + validateBST(root));
    }

    private static boolean validateBST(TreeNode node){
        return dfs(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean dfs(TreeNode node, long min, long max){
        //base condition - An empty tree is a valid binary search tree.
        if(node == null){
            return true;
        }

        // check if the current node's value is within the valid range
        if(node.val <= min || node.val >= max){
            return false;
        }

        // recurse and pass down updated max_ to the left and right children
        boolean left = dfs(node.left, min, node.val);
        boolean right = dfs(node.right, node.val, max);

        // return the number of good nodes in the subtree rooted at the current node
        return left && right;
    }
}
