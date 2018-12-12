package com.kworld.problems.string;

import static com.kworld.util.Util.logger;
import static com.kworld.util.Util.scanner;
/*
Check if Given String is Palindrome of Not
 */
public class Palindrome {
    public static void main(String[] args) {
    	logger.info("Enter String to check Palindrome : ");
        String str = scanner.nextLine();
        logger.info(String.format("%s is %s", str,  (checkPalindrome(str)) ? "Pelindrom" : "Not Pelindrom"));
    }

    private static boolean checkPalindrome(String str){
        for (int i = 0,len = str.length(); i<= len/2 ; i++){
            if(str.charAt(i) != str.charAt(len-i-1))
                return false;
        }
        return true;
    }
}











