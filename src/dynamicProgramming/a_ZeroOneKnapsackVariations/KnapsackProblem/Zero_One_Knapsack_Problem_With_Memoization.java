package dynamicProgramming.a_ZeroOneKnapsackVariations.KnapsackProblem;

import java.util.Arrays;

public class Zero_One_Knapsack_Problem_With_Memoization {

    static int[][] t ;

    public static void main(String[] args) {

        int[] wt = {3,4,6,5};
        int[] val = {2,3,1,4};

        int W = 8;
        int n = 4;

        t = new int[n+2][W+2];

        for (int[] row : t)
            Arrays.fill(row,-1);

        int maxProfit = knapsack(wt,val,W,n);

        System.out.println(maxProfit);
    }

    private static int knapsack(int[] wt, int[] val, int W, int n) {

        if (n==0 || W==0)
            return 0;

        if (t[n][W] != -1)
            return t[n][W];

        if (wt[n-1] <= W)
            return t[n][W] = Math.max(val[n-1]+knapsack(wt, val, W-wt[n-1], n-1),knapsack(wt, val, W, n-1));
        else if (wt[n-1] > W)
            return t[n][W] = knapsack(wt, val, W, n-1);

        return 0;
    }

}
