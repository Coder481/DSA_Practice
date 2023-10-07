package binarySearch.infiniteSortedArray;



import globalClasses.Pair;

import java.util.Arrays;
import java.util.List;

/**
 * As it is impossible to give input an infinite array
 * so to understand the code we will use a large array but treat it like infinite array
 */
public class FindElementInInfiniteSortedArray {

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(1,2,3,4,5,6,7,8,9,10
                ,12,13,14,15,16,17,18,19,20
                ,21,22,23,24,25,26,27,28,29,30);

        printLn("The elements of infinite sorted array:"+arr);

        int element = 11;

        printLn("The element to search:"+element);

        Pair<Integer,Integer> startEnd = getIndexes(arr,element);

        int position = applyBinarySearch(arr,element, startEnd.getKey(), startEnd.getValue());

        String msg = (position == -1) ? element + " not found" : element + " found at position "+(position+1);
        printLn(msg);
    }

    private static Pair<Integer,Integer> getIndexes(List<Integer> arr, int ele){

        int start = 0;
        int end = 1;

        while (ele > arr.get(end)){
            start = end;
            end = end * 2;
        }

        return new Pair<>(start,end);
    }

    private static int applyBinarySearch(List<Integer> arr, int ele, int start, int end){

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

    private static void printLn(String s){
        System.out.println(s);
    }

}
