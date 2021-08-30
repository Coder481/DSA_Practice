package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NextAlphabetInSortedArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        print("Enter elements of sorted array(only alphabets):");

        String[] a = sc.nextLine().split("\\s+");

        print("Enter the element to find next of(only alphabet):");

        Character element = sc.next().charAt(0);

        List<Character> arr = new ArrayList<>();
        for (String s : a){
            arr.add(s.charAt(0));
        }

        char nextAlphabet = searchNextAlphabet(arr,element);

        String cM = "Next of "+element + " is "+nextAlphabet;
        String nextElementMsg = (nextAlphabet == '#') ? "Next of "+element+" not found" : cM;

        printLn(nextElementMsg);
    }

    private static char searchNextAlphabet(List<Character> arr, Character ele){

        int start = 0;
        int end = arr.size() - 1;

        char res = '#';

        while (start<=end){

            // used [ start + (end-start)/2 ] to reduce risk of Integer overflow
            // in case of array with large number of elements
            int mid = start + (end-start)/2;

            Character midEle = arr.get(mid);


            if (midEle > ele) {
                res = midEle;
                end = mid - 1;
            }
            else {
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
