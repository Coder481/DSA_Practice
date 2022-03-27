package dynamicProgramming.c_longestCommonSubsequence;

import java.util.Arrays;

/**
 * Problem Statement:
 *              We have to find out how many insertion and deletion steps are
 *              required to convert a string into another one.
 *
 *              Example:
 *                   let x = "heap" , y = "pea"
 *
 *                   step1. delete "h" and "p" from string x
 *                          x becomes "ea"
 *                   step2. insert "p" at start of x
 *                          x becomes "pea"
 *
 *                   so, insertion required = 1
 *                       deletion required = 2
 *
 *   Solving problem with Memoized DP using matrix and recursion
 *
 */

public class G_Min_InsertionDeletion_For_xTOy {

    static int[][] t;

    public static void main(String[] args)
    {
        String word1 = "heap";
        String word2 = "pea";
        int m = word1.length();
        int n = word2.length();

        t = new int[m+1][n+1];


        for(int[] arr : t)
            Arrays.fill(arr,-1);

        int lcs = LCS(word1,word2,m,n);

        int insertion = m - lcs;
        int deletion = n - lcs;

        System.out.println(insertion+" "+deletion);

    }

    private static int LCS(String x,  String y, int m,  int n){

        if(n==0||m==0)
            return 0;

        if(t[m][n] != -1)
            return t[m][n];

        if(x.charAt(m-1)==y.charAt(n-1))
            return t[m][n] = 1 + LCS(x,y,m-1,n-1);

        else
            return t[m][n] = Math.max(LCS(x,y,m,n-1),LCS(x,y,m-1,n));

    }


}
