package binarySearch.binarySearchOnAnswerConcept;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchElementInBitonicArray {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        print("Enter elements of an bitonic array(only integers with first increase then decrease monotonically):");

        String[] a = sc.nextLine().split("\\s+");

        print("Enter the element to found(only integer):");

        int element = sc.nextInt();

        List<Integer> arr = Arrays.stream(a).map(Integer::parseInt)
                .collect(Collectors.toList());

        int peekElementIndex = searchPeekElement(arr);

        int arr1Index = searchInSortedArray(arr,element,0,peekElementIndex-1);
        int arr2Index = -1;

        String otpMsg = "";

        if (arr1Index == -1){
            arr2Index = searchInReverseSortedArray(arr,element,peekElementIndex,arr.size()-1);
        }else {
            otpMsg = element+" found at index "+arr1Index;
        }

        if (arr2Index != -1){
            otpMsg = element+" found at index "+arr2Index;
        }

        if (arr1Index==-1 && arr2Index==-1)
            otpMsg = element + " not found!";

        printLn(otpMsg);
    }

    private static int searchPeekElement(List<Integer> arr) {

        int size = arr.size();

        int start = 0;
        int end = size - 1;

        if (size == 1)
            return 0;

        while (start<=end){

            int mid = start + (end-start)/2;

            if (mid>0 && mid<size-1){

                int midEle = arr.get(mid);

                if (midEle > arr.get(mid-1) && midEle > arr.get(mid+1))
                    return mid;
                else if (arr.get(mid+1) > midEle)
                    start = mid + 1;
                else end = mid - 1;
            }
            else if (mid == 0){
                if (arr.get(0) > arr.get(1))
                    return 0;
                else return 1;
            }
            else if (mid == size-1){
                if (arr.get(size-1) > arr.get(size-2))
                    return size-1;
                else return size-2;
            }
        }

        return -1;
    }

    private static int searchInSortedArray(List<Integer> arr, int ele,int start, int end){

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

    private static int searchInReverseSortedArray(List<Integer> arr, int ele,int start, int end){

        while (start<=end){

            // used [ start + (end-start)/2 ] to reduce risk of Integer overflow
            // in case of array with large number of elements
            int mid = start + (end-start)/2;

            if (arr.get(mid) == ele)
                return mid;
            else if (ele < arr.get(mid))
                start = mid + 1;
            else if (ele > arr.get(mid))
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
