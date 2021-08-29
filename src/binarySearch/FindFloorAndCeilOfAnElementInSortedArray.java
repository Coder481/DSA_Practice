package binarySearch;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindFloorAndCeilOfAnElementInSortedArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        print("Enter elements of sorted array(only integers):");

        String[] a = sc.nextLine().split("\\s+");

        print("Enter the element to find floor of(only integer)");

        int element = sc.nextInt();

        List<Integer> arr = Arrays.stream(a).map(Integer::parseInt)
                .collect(Collectors.toList());

        int floorElement = searchFloorElement(arr,element);
        int ceilElement = searchCeilElement(arr,element);

        String fM = "Floor of "+element + " is "+floorElement;
        String floorMsg = (floorElement == -1) ? "Floor of "+element+" not found" : fM;

        String cM = "Ceil of "+element + " is "+ceilElement;
        String ceilMsg = (ceilElement == -1) ? "Ceil of "+element+" not found" : cM;

        printLn(floorMsg+"\n"+ceilMsg);
    }

    private static int searchFloorElement(List<Integer> arr, int ele){

        int start = 0;
        int end = arr.size() - 1;

        int res = -1;

        while (start<=end){

            // used [ start + (end-start)/2 ] to reduce risk of Integer overflow
            // in case of array with large number of elements
            int mid = start + (end-start)/2;

            if (arr.get(mid) == ele)
                return arr.get(mid);
            else if (arr.get(mid) > ele)
                end = mid - 1;
            else if (arr.get(mid) < ele) {
                res = arr.get(mid);
                start = mid + 1;
            }

        }

        return res;
    }

    private static int searchCeilElement(List<Integer> arr, int ele){

        int start = 0;
        int end = arr.size() - 1;

        int res = -1;

        while (start<=end){

            // used [ start + (end-start)/2 ] to reduce risk of Integer overflow
            // in case of array with large number of elements
            int mid = start + (end-start)/2;

            if (arr.get(mid) == ele)
                return arr.get(mid);
            else if (arr.get(mid) > ele) {
                res = arr.get(mid);
                end = mid - 1;
            }
            else if (arr.get(mid) < ele) {
                start = mid + 1;
            }

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
