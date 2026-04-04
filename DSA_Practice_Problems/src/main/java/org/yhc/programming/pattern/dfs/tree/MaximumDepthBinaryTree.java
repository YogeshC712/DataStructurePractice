package org.yhc.programming.pattern.dfs.tree;

public class MaximumDepthBinaryTree {
    public static void main(String[] args) {
        Integer[] nums = {4, 2, 7, 1, null, 6, 9, null, 8, null, null, null, null, null, null};
        TreeNode root = TreeNode.buildTree(nums);

        System.out.println("Maximum depth of Tree is: " + dfs(root));
    }

    private static int dfs(TreeNode node){
        //base condition - The max depth of an empty tree is 0.
        if(node == null){
            return 0;
        }

        // get the maximum depth of the left and right subtrees
        int left = dfs(node.left);
        int right = dfs(node.right);

        return Math.max(left, right) + 1;
    }
}
