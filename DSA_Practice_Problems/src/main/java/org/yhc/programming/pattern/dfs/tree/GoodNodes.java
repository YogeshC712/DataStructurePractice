package org.yhc.programming.pattern.dfs.tree;

import java.util.ArrayList;
import java.util.List;

public class GoodNodes {
    public static void main(String[] args) {
        Integer[] nums = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeNode.buildTree(nums);

        System.out.println("The tree has number of Good nodes : " + goodNodes(root));
        System.out.println("The tree has Good nodes : " + goodNodesList(root));
    }

    private static int goodNodes(TreeNode node){
        return dfs(node, Integer.MIN_VALUE);
    }
    private static int dfs(TreeNode node, int maxVal){
        //base condition - The number of good nodes in an empty tree is 0.
        if(node == null){
            return 0;
        }

        int count = 0;
        if(node.val >= maxVal){
            //good node found, update count and max_
            count += 1;
            maxVal = node.val;
        }

        // recurse and pass down updated max_ to the left and right children
        int left = dfs(node.left, maxVal);
        int right = dfs(node.right, maxVal);

        // return the number of good nodes in the subtree rooted at the current node
        return count + left + right;
    }

    private static List<Integer> goodNodesList(TreeNode node){
        List<Integer> nodes = new ArrayList<>();
        dfs1(node, Integer.MIN_VALUE, nodes);
        return nodes;
    }

    private static void dfs1(TreeNode node, int maxVal, List<Integer> nodes){
        //base condition - The number of good nodes in an empty tree is 0.
        if(node == null){
            return;
        }

        if(node.val >= maxVal){
            //good node found, add it to global list and max_
            nodes.add(node.val);
            maxVal = node.val;
        }

        // recurse and pass down updated max_ to the left and right children
        dfs1(node.left, maxVal, nodes);
        dfs1(node.right, maxVal, nodes);
    }
}
