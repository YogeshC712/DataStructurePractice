package org.yhc.programming.pattern.two_pointers;

/**
 * Statement -
 * Given a string, s, return TRUE if it is a palindrome; otherwise, return FALSE.
 * A phrase is considered a palindrome if it reads the same backward as forward after converting all uppercase letters to lowercase and removing any characters that are not letters or numbers.
 * Only alphanumeric characters (letters and digits) are taken into account.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String[] testCases = {
                "A man, a plan, a canal: Panama",
                "race a car",
                "1A@2!3 23!2@a1",
                "No 'x' in Nixon",
                "12321"
        };

        for (String test : testCases) {
            System.out.println("\tString: " + test);
            boolean result = isValidPalindrome(test);
            System.out.println("\n\tResult: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    private static boolean isValidPalindrome(String input) {
        int left = 0, right = input.length() - 1;

        while(left < right){
            //To ignore non-alphanumeric character on left side
            while(left < right && !Character.isLetterOrDigit(input.charAt(left))){
                left++;
            }
            //To ignore non-alphanumeric character on right side
            while(left < right && !Character.isLetterOrDigit(input.charAt(right))){
                right--;
            }
            //Return false if any check not matches.
            if(Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
