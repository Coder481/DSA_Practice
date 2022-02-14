package dynamicProgramming.a_ZeroOneKnapsackVariations;

import java.util.Arrays;

public class C_Minimum_Subset_Sum_Diff {

    public static void main(String[] args) {

        int[] arr = {1,6,11};

        int sum = Arrays.stream(arr).sum();

        boolean[] res = subsetSum(arr,sum);

        int end = sum / 2;

        for (int i=end; i>=0; i--){
            if (res[i]){
                System.out.println(sum - 2*i);
                break;
            }
        }
    }

    private static boolean[] subsetSum(int[] arr, int sum) {
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

        return t[n];
    }

}
