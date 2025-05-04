package org.yhc.programming.pattern.two_pointers;

/**
 * Statement -
 * Given a string, s, return TRUE if it is a palindrome; otherwise, return FALSE.
 * A phrase is considered a palindrome if it reads the same backward as forward after converting all uppercase letters to lowercase and removing any characters that are not letters or numbers.
 * Only alphanumeric characters (letters and digits) are taken into account.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        //String input = "kaYak";
        String input = "Madam, in Eden, Im Adam";

        boolean result = isValidPalindrome(input);
        System.out.println("Provide input - "+ input + " ,is it valid palindrome - " + result);
    }

    private static boolean isValidPalindrome(String input) {
        int left = 0, right = input.length() - 1;

        while(left < right){
            while(left < right && !Character.isLetterOrDigit(input.charAt(left))){
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(input.charAt(right))){
                right--;
            }

            if(Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
