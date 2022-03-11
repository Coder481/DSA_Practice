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
 * Problem is solved using Memoized approach in DP using matrix and recursion
 */

public class B_LCS_Memoized {

    static int[][] t ;
    public static void main(String[] args) {

        String x = "abcdgh";
        String y = "abcdghfa";

        int n = x.length();
        int m = y.length();

        t = new int[n+1][m+1];

        for (int[] row : t)
            Arrays.fill(row,-1);

        int lcsLength = LCS(x,y,n,m);

        System.out.println(lcsLength);
    }

    private static int LCS(String x, String y, int n, int m) {

        if (n==0 || m==0)
            return 0;

        if (t[n][m] != -1)
            return t[n][m];

        if (x.charAt(n-1) == y.charAt(m-1))
            return t[n][m] = 1 + LCS(x,y,n-1,m-1);

        else
            return t[n][m] = Math.max(LCS(x,y,n,m-1), LCS(x,y,n-1,m));

    }

}
