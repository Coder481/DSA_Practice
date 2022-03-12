package dynamicProgramming.c_longestCommonSubsequence;

import java.util.Arrays;

/**
 * Problem Statement:
 *          We have to find out the length of the
 *          longest common subsequence
 *          between two strings
 *
 *          Example
 *              x = "abcde", y="acdfeh"
 *              output: 4   ->  (acde)
 *
 * Problem is solved using Top-Down approach in DP
 */
public class C_LCS_TopDownDp {

    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "acdfeh";

        int m = text1.length();
        int n = text2.length();

        int[][] t = new int[m+1][n+1];

        Arrays.fill(t[0],0);
        for(int i = 1; i<=m; i++)
            t[i][0] = 0;

        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){

                if (text1.charAt(i-1) == text2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];

                else
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);

            }
        }

        System.out.println(t[m][n]);

    }

}
