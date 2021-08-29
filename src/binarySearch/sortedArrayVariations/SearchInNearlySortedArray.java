package binarySearch.sortedArrayVariations;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * In Nearly Sorted Array, any item at index i can be found at index i-1, i, i+1
 *  Example
 *          Nearly Sorted Array 5 10 30 20 40
 *          Purely Sorted Array 5 10 20 30 40
 */
public class SearchInNearlySortedArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        print("Enter elements of sorted array(only integers):");

        String[] a = sc.nextLine().split("\\s+");

        print("Enter the element to found(only integer)");

        int element = sc.nextInt();

        List<Integer> arr = Arrays.stream(a).map(Integer::parseInt)
                .collect(Collectors.toList());

        int position = search(arr,element);

        String msg = (position == -1) ? element + " not found" : element + " found at position "+(position+1);
        printLn(msg);
    }

    private static int search(List<Integer> arr, int ele){

        int start = 0;
        int end = arr.size() - 1;

        while (start<=end){

            // used [ start + (end-start)/2 ] to reduce risk of Integer overflow
            // in case of array with large number of elements
            int mid = start + (end-start)/2;

            if (arr.get(mid) == ele)
                return mid;
            if (mid-1>=start && arr.get(mid-1)==ele)
                return mid-1;
            if (mid+1<=end && arr.get(mid+1)==ele)
                return mid+1;

            if (ele < arr.get(mid))
                end = mid - 2;
            else if (ele > arr.get(mid))
                start = mid + 2;

        }

        return -1;
    }

    private static void printLn(String s){
        System.out.println(s);
    }
    private static void print(String s){
        System.out.print(s);
    }

}
