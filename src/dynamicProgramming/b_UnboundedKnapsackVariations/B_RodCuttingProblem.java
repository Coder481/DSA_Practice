package dynamicProgramming.b_UnboundedKnapsackVariations;

import java.util.Arrays;

public class B_RodCuttingProblem {

    public static void main(String[] args) {

        int[] length = {1,2,3,4};
        int[] price = {2,3,1,4};

        int N = 4;
        int size = length.length;

        int[][] t = new int[size + 1][N + 1];

        Arrays.fill(t[0],0);
        for(int i=1; i<size+1; i++)
            t[i][0] = 0;


        for (int i=1; i<size+1; i++)
            for(int j=1; j<N+1; j++){

                if (length[i-1] <= j)
                    t[i][j] = Math.max( (price[i-1] + t[i][j-length[i-1]]), t[i-1][j] );

                else
                    t[i][j] = t[i-1][j];
            }

        System.out.println(t[size][N]);
    }



}
