package dynamicProgramming.a_ZeroOneKnapsackVariations;

import java.util.Arrays;

public class D_Count_Of_Subset_Sum {

    public static void main(String[] args) {

        int[] arr = {2,3,5,6,8,10};
        int sum = 10;

        int res = subsetSum(arr,sum);

        System.out.println(res);
    }

    private static int subsetSum(int[] arr, int sum) {
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
