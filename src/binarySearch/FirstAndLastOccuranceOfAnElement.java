package binarySearch;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstAndLastOccuranceOfAnElement {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        print("Enter elements of sorted array(only integers):");

        String[] a = sc.nextLine().split("\\s+");

        print("Enter the element to found(only integer)");

        int element = sc.nextInt();

        List<Integer> arr = Arrays.stream(a).map(Integer::parseInt)
                .collect(Collectors.toList());

        int firstOcc = firstOccurrence(arr,element);
        int lastOcc = lastOccurrence(arr,element);

        String msg = (firstOcc == -1 || lastOcc==-1) ? element + " not found" :
                "First Position of "+element+" is "+firstOcc+"\nLast Position of "+element+" is "+lastOcc;
        printLn(msg);
    }

    private static int firstOccurrence(List<Integer> arr, int ele){

        int start = 0;
        int end = arr.size() - 1;

        int res = -1;

        while (start<=end){

            // used [ start + (end-start)/2 ] to reduce risk of Integer overflow
            // in case of array with large number of elements
            int mid = start + (end-start)/2;

            if (arr.get(mid) == ele){
                res = mid;
                end = mid - 1;
            }
            else if (ele < arr.get(mid))
                end = mid - 1;
            else if (ele > arr.get(mid))
                start = mid + 1;

        }

        return res;
    }

    private static int lastOccurrence(List<Integer> arr, int ele){

        int start = 0;
        int end = arr.size() - 1;

        int res = -1;

        while (start<=end){

            // used [ start + (end-start)/2 ] to reduce risk of Integer overflow
            // in case of array with large number of elements
            int mid = start + (end-start)/2;

            if (arr.get(mid) == ele){
                res = mid;
                start = mid + 1;
            }
            else if (ele < arr.get(mid))
                end = mid - 1;
            else if (ele > arr.get(mid))
                start = mid + 1;

        }

        return res;
    }

    private static void printLn(String s){
        System.out.println(s);
    }
    private static void print(String s){
        System.out.print(s);
    }

}
