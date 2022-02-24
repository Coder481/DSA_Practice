package dynamicProgramming.a_ZeroOneKnapsackVariations;

import java.util.Arrays;

/**
 *  Problem Statement
 *          We have to apply + or - sign
 *          before every element of the array
 *          such that the resultant value
 *          will equal to target "sum"
 *
 *          Example:    arr = {1,1,2,3}     sum = 1
 *
 *          Possible ways to add signs
 *                  {+1 -1 -2 +3},  {-1 +1 -2 +3},  {+1 +1 +2 -3}
 *                  all the expressions have result equal to "sum" i.e., 1
 *
 *                  So how many ways are possible : 3 (output)
 *
 */
public class F_TargetSum {

    public static void main(String[] args) {

        int[] arr = {1,1,2,3};
        int sum = 1;

        int res = solve(arr,sum);

        System.out.println(res);
    }

    private static int solve(int[] arr, int diff) {

        int sum = Arrays.stream(arr).sum();

        if ((sum + diff )%2 != 0) return 0;

        int s = (sum + diff) / 2;

        return countSubsets(arr,s);
    }

    private static int countSubsets(int[] arr, int sum) {
        int n = arr.length;

        int[][] t = new int[n + 1][sum + 1];

        Arrays.fill(t[0],0);
        for (int i = 0; i <= n; i++)
            t[i][0] = 1;


        for (int i=1; i<=n; i++){
            for (int j=1; j<=sum; j++){
                if (arr[i-1] <= j)
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
            }
        }

        return t[n][sum];
    }

}
