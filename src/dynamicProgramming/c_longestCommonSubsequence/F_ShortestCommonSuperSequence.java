package dynamicProgramming.c_longestCommonSubsequence;

import java.util.Arrays;

/**
 * Problem Statement:
 *      We have to combine two strings such that the resultant string
 *      contains bot the two input strings as subsequences and have
 *      minimum length.
 */
public class F_ShortestCommonSuperSequence {

    public static void main(String[] args) {

        String x = "AGGTAB";
        String y = "GXTXAYB";

        int m = x.length();
        int n = y.length();

        int[][] t = new int[m+1][n+1];

        Arrays.fill(t[0],0);
        for(int i = 1; i<=m; i++)
            t[i][0] = 0;

        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){

                if (x.charAt(i-1) == y.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];

                else
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);

            }
        }

        System.out.println(m + n - t[m][n]);

    }

}
