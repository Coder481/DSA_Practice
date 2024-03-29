package array;

public class RotateImage {
    public void rotate(int[][] matrix) {

        transpose(matrix);

        swap(matrix);

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
