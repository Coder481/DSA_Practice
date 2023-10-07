package binarySearch.infiniteSortedArray;


import globalClasses.Pair;

import java.util.Arrays;
import java.util.List;

/**
 * As it is impossible to give input an infinite array
 * so to understand the code we will use a large array but treat it like infinite array
 */
public class FindIndexOfFirstOneInBinaryInfiniteSortedArray {


    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,
                1,1,1,1,1,1);

        printLn("The elements of infinite sorted array:"+arr);

        int key = 1;

        printLn("The element to search:"+key);

        Pair<Integer,Integer> startEnd = getIndexes(arr,key);

        int position = firstOccurrence(arr,key, startEnd.getKey(), startEnd.getValue());

        String msg = (position == -1) ? key + " not found" : key + "'s first occurrence is at position "+(position+1);
        printLn(msg);
    }

    private static Pair<Integer,Integer> getIndexes(List<Integer> arr, int key){

        int start = 0;
        int end = 1;

        while (key > arr.get(end)){
            start = end;
            end = end * 2;
        }

        return new Pair<>(start,end);
    }

    private static int firstOccurrence(List<Integer> arr, int key, int start, int end){

        int res = -1;

        while (start<=end){

            // used [ start + (end-start)/2 ] to reduce risk of Integer overflow
            // in case of array with large number of elements
            int mid = start + (end-start)/2;

            if (arr.get(mid) == key){
                res = mid;
                end = mid - 1;
            }
            else if (key < arr.get(mid))
                end = mid - 1;
            else if (key > arr.get(mid))
                start = mid + 1;

        }

        return res;
    }

    private static void printLn(String s){
        System.out.println(s);
    }

}
