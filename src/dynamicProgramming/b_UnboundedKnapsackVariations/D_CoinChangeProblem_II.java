package dynamicProgramming.b_UnboundedKnapsackVariations;

import java.util.Arrays;

public class D_CoinChangeProblem_II {

    public static void main(String[] args) {

        int[] coins = {2};
        int amount = 3;
        int n = coins.length;

        int[][] t = new int[n + 1][amount + 1];

        Arrays.fill(t[0], Integer.MAX_VALUE - 1);
        for (int i=1; i<=n; i++){
            t[i][0] = 0;
        }

        for (int j=1; j<=amount; j++){
            if (j % coins[0] == 0)
                t[1][j] = j / coins[0];
            else
                t[1][j] = Integer.MAX_VALUE - 1;
        }


        for (int i=2; i<=n; i++){
            for (int j=1; j<=amount; j++){

                if (coins[i-1] <= j)
                    t[i][j] = Math.min(t[i][j-coins[i-1]] + 1 , t[i-1][j]);

                else
                    t[i][j] = t[i-1][j];

            }
        }

        int res = t[n][amount];
        System.out.println((res==Integer.MAX_VALUE - 1) ? -1 : res);
    }

}
