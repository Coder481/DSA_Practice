package dynamicProgramming.c_longestCommonSubsequence;

import java.util.Arrays;

/**
 * Problem Statement:
 *          We have to print the longest common subsequence
 *          between two strings
 *
 *          Example
 *              x = "abcde", y="acdfeh"
 *              to print: "acde"
 */
public class E_Print_LCS {

    public static void main(String[] args) {

        String x = "abcde";
        String y = "acdfeh";

        int m = x.length();
        int n = y.length();

        int[][] t = new int[m+1][n+1];

        Arrays.fill(t[0],0);
        for(int i = 1; i<=m; i++)
            t[i][0] = 0;

        // filling the matrix
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){

                if (x.charAt(i-1) == y.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];

                else
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);

            }
        }


        // getting the LCS string
        int i = m, j = n;
        StringBuilder res = new StringBuilder();

        while (i>0 && j>0){
            if (x.charAt(i-1) == y.charAt(j-1)){
                res.append(x.charAt(i - 1));
                i--;
                j--;
            }
            else {
                if (t[i][j-1] > t[i-1][j])
                    j--;
                else
                    i--;
            }
        }

        // print the LCS
        System.out.println(res.reverse());

    }

}
