package org.yhc.programming.pattern.dfs;

public class MaximumValueInTree {
    public static void main(String[] args) {
        Integer[] nums = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeNode.buildTree(nums);

        System.out.println("Maximum value is: " + dfs(root));
    }

    private static int dfs(TreeNode node){
        //base condition - An empty subtree has a maximum value of negative infinity.
        if(node == null){
            return Integer.MIN_VALUE;
        }

        //The subtree rooted at a leaf node has a maximum value equal to the value of the leaf node.
        if(node.left == null && node.right == null){
            return node.val;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        return Math.max(node.val, Math.max(left, right));
    }
}
