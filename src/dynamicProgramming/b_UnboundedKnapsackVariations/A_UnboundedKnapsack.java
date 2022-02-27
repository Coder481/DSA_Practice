package dynamicProgramming.b_UnboundedKnapsackVariations;

import java.util.Arrays;

public class A_UnboundedKnapsack {

    public static void main(String[] args) {

        int[] wt = {3,4,6,5};
        int[] val = {2,3,1,4};

        int W = 8;
        int n = 4;

        int[][] t = new int[n + 2][W + 2];

        Arrays.fill(t[0],0);
        for(int i=1; i<n+1; i++)
            t[i][0] = 0;


        for (int i=1; i<n+1; i++)
            for(int j=1; j<W+1; j++){

                if (wt[i-1] <= j)
                    t[i][j] = Math.max( (val[i-1] + t[i][j-wt[i-1]]), t[i-1][j] );

                else
                    t[i][j] = t[i-1][j];
            }

        System.out.println(t[n][W]);
    }


}
