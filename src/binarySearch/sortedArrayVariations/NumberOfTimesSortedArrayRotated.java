package binarySearch.sortedArrayVariations;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * No duplicates allowed in this solution
 */
public class NumberOfTimesSortedArrayRotated {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        print("Enter elements of sorted array(only integers):");

        String[] a = sc.nextLine().split("\\s+");

        List<Integer> arr = Arrays.stream(a).map(Integer::parseInt)
                .collect(Collectors.toList());

        int count = getCount(arr);

        String msg = (count == -1) ? "Error" :  "Array rotated "+count+" times" ;
        printLn(msg);
    }

    private static int getCount(List<Integer> arr){

        int size = arr.size();

        int start = 0;
        int end = size - 1;


        while (start<=end){

            if (arr.get(start)<=arr.get(end))
                return size-start;

            int mid = start + (end-start)/2;

            int next = (mid + 1)%size;
            int prev = (mid + size - 1)%size;

            if (arr.get(mid)<=arr.get(next) && arr.get(mid)<=arr.get(prev))
                return size-mid;

            if (arr.get(start)<=arr.get(mid))
                start = mid + 1;
            else if (arr.get(mid)<=arr.get(end))
                end = mid - 1;
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
