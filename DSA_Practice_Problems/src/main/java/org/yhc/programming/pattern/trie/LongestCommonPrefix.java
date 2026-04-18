package org.yhc.programming.pattern.trie;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println("Longest common prefix: "+ longestCommonPrefix(strs));
    }

    /**
     *  Vertical scanning - scan column by column across all strings
     *  O(N * M) where N - number of strings and M - length of shortest string
     *  Space - O(1)
     */
    private static String longestCommonPrefix(String[] strs){

        if(strs == null || strs.length == 0) return "";


        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);

            //start from second string
            for (int j = 1; j < strs.length; j++) {
                //Check bounds OR mismatch - If at any point characters mismatch → stop immediately
                if(i >= strs[j].length() || strs[j].charAt(i) != ch){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
