package zzz_codingChallenges.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        int k = 4;
        shiftGrid(arr, k);
    }

    private static List<List<Integer>> shiftGrid(int[][] grid, int k) {

        System.out.println("Before Shift");
        printGrid(grid);


        for(int i=1; i<=k; i++)
            shiftGrid(grid);

        System.out.println("After Shift");
        printGrid(grid);

        return gridToList(grid);
    }

    private static List<List<Integer>> gridToList(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for (int[] ints : grid) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < n; j++)
                subList.add(ints[j]);
            res.add(subList);
        }
        return res;
    }

    private static int[][] createTempGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] temp = new int[m][n];
        for(int i=0; i<m; i++)
            System.arraycopy(grid[i], 0, temp[i], 0, n);
        return temp;
    }


    private static void shiftGrid(int[][] grid){

        int[][] temp = createTempGrid(grid);
        int m = temp.length, n = temp[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0)
                    grid[i][j] = temp[m-1][n-1];
                else if(i != 0 && j == 0)
                    grid[i][j] = temp[i-1][n-1];
                else
                    grid[i][j] = temp[i][j-1];
            }
        }
    }

    private static void printGrid(int[][] grid) {
        for(int[] e : grid){
            for(int i : e)
                System.out.print(i+" ");
            System.out.println();
        }
    }
}
