package com.kworld.problems.string;

import static com.kworld.util.Util.logger;

/**
 * Find Minimum Edit to String to match with 2nd String
 * 1. Character to insert
 * 2. Character to delete
 * 3. Character to replace
 */
public class MinimumEditString {
    public static void main(String[] args) {
        //logger.info("Enter 1st String : ");
        String str1 = "Kunal";//Util.scanner.next();
        //System.out.printf("Enter 2nd String : ");
        String str2 = "Kunir";//Util.scanner.next();

        logger.info(String.format("%nDistance using recursion/brute force : %d", new MinimumEditString().distanceRecusive(str1, str2, str1.length(), str2.length())));
        logger.info(String.format("%nDistance using DP : %d", new MinimumEditString().distanceDP(str1, str2, str1.length(), str2.length())));
    }

    private int distanceRecusive(String str1, String str2, int len1, int len2) {
        if(len1 == 0)
            return len2;
        if(len2 == 0)
            return len1;
        if(str1.charAt(len1 - 1) == str2.charAt(len2 - 1)){
            return distanceRecusive(str1, str2, len1 - 1, len2 - 1);
        } else {
            int x = 1 + distanceRecusive(str1, str2, len1 - 1, len2);
            int y = 1 + distanceRecusive(str1, str2, len1, len2 - 1);
            int z = 1 + distanceRecusive(str1, str2, len1 - 1, len2 - 1);

            return Math.min(x, Math.min(y, z));
        }
    }

    private int distanceDP(String str1, String str2, int len1, int len2) {
        int edit [][] = new int [len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++)
            edit[i][0] = i;
        for (int i = 0; i <= len2; i++)
            edit[0][i] = i;
        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <= len2; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    edit[i][j] = edit[i-1][j-1];
                else{
                    int x = 1 + edit[i-1][j];
                    int y = 1 + edit[i][j-1];
                    int z = 1 + edit[i-1][j-1];
                    edit[i][j] = Math.min(x, Math.min(y, z));
                }
            }
        }
        return edit[len1][len2];
    }
}
