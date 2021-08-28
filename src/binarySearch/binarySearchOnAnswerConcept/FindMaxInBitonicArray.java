package binarySearch.binarySearchOnAnswerConcept;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Bitonic Array means first the array increases monotonically and then decreases monotonically
 *
 * Ex: 1 3 8 12 4 2
 *
 * This problem is just similar with Peak Element problem
 */
public class FindMaxInBitonicArray {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        print("Enter elements of an bitonic array(only integers with first increase then decrease monotonically):");

        String[] a = sc.nextLine().split("\\s+");

        List<Integer> arr = Arrays.stream(a).map(Integer::parseInt)
                .collect(Collectors.toList());

        int peekElementIndex = searchPeekElement(arr);

        String msg = (peekElementIndex == -1) ? "Error, maximum not found" :  "Maximum found at index "+peekElementIndex;
        printLn(msg);
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

    private static void printLn(String s){
        System.out.println(s);
    }
    private static void print(String s){
        System.out.print(s);
    }

}
