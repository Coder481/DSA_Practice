package binarySearch.sortedArrayVariations;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchInSortedRotatedArray {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        print("Enter elements of sorted array(only integers):");

        String[] a = sc.nextLine().split("\\s+");

        print("Enter the element to found(only integer)");

        int element = sc.nextInt();

        List<Integer> arr = Arrays.stream(a).map(Integer::parseInt)
                .collect(Collectors.toList());

        int position = search(arr,element);

        String msg = (position == -1) ? element + " not found" : element + " found at index "+position;
        printLn(msg);
    }

    private static int search(List<Integer> arr, int ele) {

        int index = getMinIndex(arr);

        int indexInArr1 = binarySearch(arr,ele,0,index-1);
        int indexInArr2 = binarySearch(arr,ele,index,arr.size()-1);

        if (indexInArr1 != -1)
            return indexInArr1;

        else return indexInArr2;
    }

    private static int binarySearch(List<Integer> arr, int ele, int start, int end){

        while (start<=end){

            // used [ start + (end-start)/2 ] to reduce risk of Integer overflow
            // in case of array with large number of elements
            int mid = start + (end-start)/2;

            if (arr.get(mid) == ele)
                return mid;
            else if (ele < arr.get(mid))
                end = mid - 1;
            else if (ele > arr.get(mid))
                start = mid + 1;

        }

        return -1;
    }

    private static int getMinIndex(List<Integer> arr){

        int size = arr.size();

        int start = 0;
        int end = size - 1;


        while (start<=end){

            if (arr.get(start)<=arr.get(end))
                return start;

            int mid = start + (end-start)/2;

            int next = (mid + 1)%size;
            int prev = (mid + size - 1)%size;

            if (arr.get(mid)<=arr.get(next) && arr.get(mid)<=arr.get(prev))
                return mid;

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
