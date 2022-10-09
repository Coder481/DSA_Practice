package zzz_codingChallenges.leetcode.medium;

public class RotateImage {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Original");
        print(arr);

        transpose(arr);

        System.out.println("Transpose");
        print(arr);

        swap(arr);

        System.out.println("Final");
        print(arr);
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

    private static void print(int[][] arr){
        for(int i=0; i<=arr.length-1; i++){
            for(int j=0; j<=arr[i].length-1; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
