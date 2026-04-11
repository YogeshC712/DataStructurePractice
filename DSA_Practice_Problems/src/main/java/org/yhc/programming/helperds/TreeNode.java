package org.yhc.programming.helperds;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    //TODO - need to correct the logic for input - [4,1,5,null,null,3,6]
    public static TreeNode buildTree(Integer[] arr){
        if(arr.length == 0 || arr[0] == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length){
            TreeNode current = queue.poll();

            if(arr[i] != null){
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
                i++;
            }

            if(i < arr.length && arr[i] != null){
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}
