package binarySearch;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MinimumDifferenceElementInSortedArray {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        print("Enter elements of sorted array(only integers):");

        String[] a = sc.nextLine().split("\\s+");

        print("Enter the element for minimum difference(only integer)");

        int element = sc.nextInt();

        List<Integer> arr = Arrays.stream(a).map(Integer::parseInt)
                .collect(Collectors.toList());

        int minDiffElement = getMinimumDifferenceElement(arr,element);

        String msg = (minDiffElement == -1) ? element + " not found" : "Minimum difference of " + element + " is with "+minDiffElement;
        printLn(msg);
    }

    private static int getMinimumDifferenceElement(List<Integer> arr, int ele){

        int start = 0;
        int end = arr.size() - 1;

        while (start<=end){

            // used [ start + (end-start)/2 ] to reduce risk of Integer overflow
            // in case of array with large number of elements
            int mid = start + (end-start)/2;

            int midEle = arr.get(mid);
            if (midEle == ele)
                return midEle;
            else if (ele < midEle)
                end = mid - 1;
            else
                start = mid + 1;

        }

        int size = arr.size();
        start = (start+size)%size;
        end = (end+size)%size;

        int diffWithStart = Math.abs((arr.get(start)-ele));
        int diffWithEnd = Math.abs((arr.get(end)-ele));

        if (diffWithStart < diffWithEnd)
            return arr.get(start);

        return arr.get(end);
    }

    private static void printLn(String s){
        System.out.println(s);
    }
    private static void print(String s){
        System.out.print(s);
    }

}
