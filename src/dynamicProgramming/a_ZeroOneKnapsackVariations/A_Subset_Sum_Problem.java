package dynamicProgramming.a_ZeroOneKnapsackVariations;

import java.util.Arrays;

public class A_Subset_Sum_Problem {

    public static void main(String[] args) {

        int[] arr = {2,3,7,8,10};
        int sum = 14;

        boolean res = subsetSum(arr,sum);

        System.out.println(res);
    }

    private static boolean subsetSum(int[] arr, int sum) {
        int n = arr.length;

        boolean[][] t = new boolean[n + 1][sum + 1];

        Arrays.fill(t[0],false);
        for (int i = 0; i <= n; i++)
            t[i][0] = true;


        for (int i=1; i<=n; i++){
            for (int j=1; j<=sum; j++){
                if (arr[i-1] <= j)
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
            }
        }

        return t[n][sum];
    }

}
