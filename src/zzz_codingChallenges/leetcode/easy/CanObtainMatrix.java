package zzz_codingChallenges.leetcode.easy;

/**
 * The logic is that rotate target matrix 3 times and check every time that the two matrices are equal or not.
 *
 * Logic to rotate a matrix by 90 degree:
 * * First transpose a matrix
 */
public class CanObtainMatrix {

    public static void main(String[] args) {
        int[][] a = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        int[][] b = new int[][]{{1,1,1},{0,1,0},{0,0,0}};
        if(areMatricesEqual(a,b)){
            System.out.println(true);
            return;
        }

        for(int i=1; i<=3; i++){
            rotate(b);
            if(areMatricesEqual(a,b)){
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }

    private static void rotate(int[][] b) {
        transpose(b);
        swap(b);
    }

    private static boolean areMatricesEqual(int[][] a, int[][] b){
        int n = a.length;
        int m = a[0].length;

        for(int i=0; i<=n-1; i++)
            for(int j=0; j<=m-1; j++)
                if(a[i][j] != b[i][j]) return false;

        return true;
    }

    private static void swap(int[][] arr){
        int n = arr.length;
        int times = (n / 2) - 1;

        for(int i=0; i<=n-1; i++){
            for(int j=0; j<=times; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][n-1-j];
                arr[i][n-1-j] = temp;
            }
        }
    }

    private static void transpose(int[][] arr){
        for(int i=0; i<=arr.length-1; i++){
            for(int j=i+1; j<=arr[i].length-1; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
}
