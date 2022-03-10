package dynamicProgramming.c_longestCommonSubsequence;

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
 * Problem is solved using Recursion
 */
public class A_LCS_Recursive {

    public static void main(String[] args) {

        String x = "abcdgh";
        String y = "abedfhr";

        int n = x.length();
        int m = y.length();

        int lcsLength = LCS(x,y,n,m);

        System.out.println(lcsLength);
    }

    private static int LCS(String x, String y, int n, int m) {

        if (n==0 || m==0)
            return 0;

        if (x.charAt(n-1) == y.charAt(m-1))
            return 1+LCS(x,y,n-1,m-1);

        else
            return Math.max(LCS(x,y,n,m-1), LCS(x,y,n-1,m));

    }

}
