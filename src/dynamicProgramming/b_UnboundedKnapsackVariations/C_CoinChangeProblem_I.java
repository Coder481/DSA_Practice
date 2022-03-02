package dynamicProgramming.b_UnboundedKnapsackVariations;

import java.util.Arrays;

public class C_CoinChangeProblem_I {


    public static void main(String[] args) {

        int[] coins = {2};
        int sum = 3;

        int res = countWays(coins,sum);

        System.out.println(res);
    }

    private static int countWays(int[] coins, int amount) {
        int n = coins.length;

        int[][] t = new int[n + 1][amount + 1];

        Arrays.fill(t[0],0);
        for (int i = 0; i <= n; i++)
            t[i][0] = 1;


        for (int i=1; i<=n; i++){
            for (int j=1; j<=amount; j++){
                if (coins[i-1] <= j)
                    t[i][j] = t[i][j-coins[i-1]] + t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
            }
        }

        return t[n][amount];
    }


}
