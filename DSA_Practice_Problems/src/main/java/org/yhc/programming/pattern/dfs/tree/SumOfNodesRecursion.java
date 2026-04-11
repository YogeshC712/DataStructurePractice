package org.yhc.programming.pattern.dfs.tree;

import org.yhc.programming.helperds.TreeNode;

public class SumOfNodesRecursion {
    public static void main(String[] args) {
        Integer[] nums = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeNode.buildTree(nums);

        System.out.println("Sum of nodes is: " + dfs(root));
    }

    private static int dfs(TreeNode node){
        //base condition - empty subtree
        if(node == null){
            return 0;
        }

        //base case - leaf node
        if(node.left == null || node.right == null){
            return node.val;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        return node.val + left + right;
    }
}
