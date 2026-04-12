package org.yhc.programming.pattern.backtracking;

import org.yhc.programming.helperds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumBacktracking {
    public static void main(String[] args) {
        Integer[] nums = {4, 2, 2, 1, 8, 3, null, 2, 5, 4, 3, 2, 8};
        int target = 11;
        TreeNode root = TreeNode.buildTree(nums);

        System.out.println("All available Paths are: " + pathSum(root, target));
    }

    private static List<List<Integer>> pathSum(TreeNode root, int target){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(root, new ArrayList<>(), 0, target, result);
        return result;
    }

    private static void backtrack(TreeNode node, ArrayList<Integer> path, int total, int target, List<List<Integer>> result) {
        if(node == null) return;

        path.add(node.val);
        total += node.val;

        // KEY STEP 2 - Pruning
        // current sum exceeds target, so pop to remove the current node from the path. Return to backtrack to previous node on the call stack
        if(total > target){
            path.remove(path.size() - 1);
            return;
        }

        if(node.left == null && node.right == null){
            // add the path to the result. Note we have to make a copy (new ArrayList<>(path)) of the path since future recursive calls modify path
            if(total == target){
                result.add(new ArrayList<>(path));
            }
        }else {
            backtrack(node.left, path, total, target, result);
            backtrack(node.right, path, total, target, result);
        }

        // KEY STEP 1
        // we have finished exploring all paths containing the current node, so pop to remove the current node from the path. Return to backtrack to previous node on the call stack.
        path.remove(path.size() - 1);
    }
}
