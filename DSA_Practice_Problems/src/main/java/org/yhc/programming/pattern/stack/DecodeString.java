package org.yhc.programming.pattern.stack;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String str = "3[a2[c]]";
        String decodeString = decodeString(str);

        System.out.println("Decoded string - " + decodeString);
    }

    private static String decodeString(String s){
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int currNum = 0;
        String currStr = "";

        for (char ch: s.toCharArray()) {

            if(ch == '['){
                //New sequence started
                strStack.push(currStr);
                numStack.push(currNum);

                currStr = "";
                currNum = 0;
            } else if (ch == ']') {
                //Sequence ended
                int num = numStack.pop();
                String prevStr = strStack.pop();
                currStr = prevStr + currStr.repeat(num);
            } else if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            }else {
                currStr += ch;
            }
        }
        return currStr;
    }
}
