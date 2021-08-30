package binarySearch;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Sorted matrix means that the rows and the columns of the matrix are sorted
 *
 * Ex:
 *          10  20  30  40
 *          15  25  35  45
 *          27  29  37  48
 *          32  33  39  50
 *
 */
public class SearchElementInSortedMatrix {

    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input size of matrix
        print("Enter size of matrix (nXm) with whiteSpace:");
        String[] sizeInp = sc.nextLine().split("\\s+");

        n = Integer.parseInt(sizeInp[0]);
        m = Integer.parseInt(sizeInp[1]);

        Integer[][] arr = new Integer[n][m];

        // Take input elements of matrix
        for (int i=0; i<n; i++){
            print("Enter elements of "+(i+1)+" row:");
            String[] enteredArr = sc.nextLine().split("\\s+");
            for (int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(enteredArr[j]);
            }
        }

        // Take input the element for searching
        print("Enter the element you want to search:");
        int key = sc.nextInt();

        // Searching the element
        Pair<Integer,Integer> keyIndexes = searchInMatrix(arr,key);

        // Showing the result of searching
        int i = keyIndexes.getKey();
        int j = keyIndexes.getValue();
        String msg = (i == -1) ? key+" not found in above matrix!" :
                key+" in the above matrix found at position ("+ (i+1) + "," + (j+1) + ")";
        printLn(msg);
    }

    private static Pair<Integer, Integer> searchInMatrix(Integer[][] arr, int key) {

        int i = 0;
        int j = m - 1;

        while ((i>=0 && i<n) && (j>=0 && j<m)){

            int element = arr[i][j];

            if (element == key)
                return new Pair<>(i,j);
            else if (element > key)
                j--;
            else if (element < key)
                i++;

        }

        return new Pair<>(-1,-1);
    }

    private static void printLn(String s){
        System.out.println(s);
    }
    private static void print(String s){
        System.out.print(s);
    }
}
