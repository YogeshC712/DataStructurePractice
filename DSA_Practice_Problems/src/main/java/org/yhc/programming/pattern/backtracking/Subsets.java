package org.yhc.programming.pattern.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> result;
    public int[] nums;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subsets subsets = new Subsets();
        List<List<Integer>> output = subsets.subsets(nums);

        System.out.println("Output: " + output);
    }

    private List<List<Integer>> subsets(int[] nums){
        this.nums = nums;
        result = new ArrayList<>();

        dfs(0, new ArrayList<>());
        return result;
    }

    private void dfs(int index, List<Integer> path){
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        //include
        path.add(nums[index]);
        dfs(index + 1, path);

        //exclude
        path.remove(path.size() - 1);
        dfs(index + 1, path);
    }
}
