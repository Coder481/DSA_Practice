package dynamicProgramming.c_longestCommonSubsequence;

import java.util.Arrays;

/**
 * Problem Statement:
 *              We have to find length of a subsequence of the given string
 *              that is palindrome and have maximum length.
 *
 *              Example:
 *                      s = "agbcba"
 *                      op = 5 (abcba)
 */
public class H_LongestPalindromicSubsequence {

    public static void main(String[] args) {

        String s = "agbcba";
        StringBuilder b = new StringBuilder(s);
        String y = b.reverse().toString();

        int m = s.length();
        int n = y.length();

        int[][] t = new int[m+1][n+1];

        Arrays.fill(t[0],0);
        for (int i=1; i<=m; i++)
            t[i][0] = 0;

        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){

                if (s.charAt(i-1) == y.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];

                else
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);

            }
        }

        System.out.println(t[m][n]);


    }

}
