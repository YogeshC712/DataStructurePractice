package org.yhc.programming.ds.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "(){({})}";
        System.out.println("Stack is valid? : " + isValidParenthesis(s));

        AtomicInteger a = new AtomicInteger(0);
        int i = a.incrementAndGet();
    }

    private static boolean isValidParenthesis(String s){
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if(mapping.containsKey(c)){
                if(stack.isEmpty() || stack.peek() != mapping.get(c)){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
