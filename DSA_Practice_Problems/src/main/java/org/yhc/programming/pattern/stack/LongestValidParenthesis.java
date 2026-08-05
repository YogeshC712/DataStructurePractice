package org.yhc.programming.pattern.stack;

import java.util.Stack;

public class LongestValidParenthesis {

    public static void main(String[] args) {
        String s = "((()()())";
        System.out.println("Longest length of valid Stack : " + longestValidParenthesis(s));
    }

    private static int longestValidParenthesis(String s){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
