package dynamicProgramming.c_longestCommonSubsequence;

import java.util.Arrays;

/**
 * Problem Statement:
 *              We have to print the longest common super sequence
 *              between two strings
 *
 *              Example:
 *              x = "acbcf", y = "abcdaf"
 *              op : "acbcdaf"
 */
public class J_PrintShortestCommonSuperSequence {

    public static void main(String[] args) {

        String str1 = "acbcf";
        String str2 = "abcdaf";

        int m = str1.length();
        int n = str2.length();

        int[][] t = new int[m+1][n+1];

        Arrays.fill(t[0],0);
        for(int i = 1; i<=m; i++)
            t[i][0] = 0;

        // filling the matrix
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){

                if (str1.charAt(i-1) == str2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];

                else
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);

            }
        }


        // getting the LCS string
        int i = m, j = n;
        StringBuilder res = new StringBuilder();

        while (i>0 && j>0){
            if (str1.charAt(i-1) == str2.charAt(j-1)){
                res.append(str1.charAt(i - 1));
                i--;
                j--;
            }
            else {
                if (t[i][j-1] > t[i-1][j]) {
                    res.append(str2.charAt(j-1));
                    j--;
                }
                else {
                    res.append(str1.charAt(i-1));
                    i--;
                }
            }
        }

        while (i>0){
            res.append(str1.charAt(i-1));
            i-=1;
        }

        while (j>0){
            res.append(str2.charAt(j-1));
            j-=1;
        }

        // print the LCS
        System.out.println(res.reverse());

    }


}
